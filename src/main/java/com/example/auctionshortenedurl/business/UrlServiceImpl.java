package com.example.auctionshortenedurl.business;

import com.example.auctionshortenedurl.bean.CreateShortenedUrlRequest;
import com.example.auctionshortenedurl.bean.CreateShortenedUrlResponse;
import com.example.auctionshortenedurl.core.UrlUtil;
import com.example.auctionshortenedurl.entity.UrlEntity;
import com.example.auctionshortenedurl.repository.IUrlRepository;
import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

public class UrlServiceImpl implements IUrlService {

  private final IUrlRepository iUrlRepository;

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  public UrlServiceImpl(IUrlRepository iUrlRepository) {
    this.iUrlRepository = iUrlRepository;
  }

  @Override
  public CreateShortenedUrlResponse createShortenedUrl(CreateShortenedUrlRequest createShortenedUrlRequest,
                                                       Long userId) {
    var longUrl = createShortenedUrlRequest.getUrl();
    if (UrlUtil.isValid(longUrl)) {
      var shortenedUrl = getShortenedUrl(longUrl);
      var urlEntity = addUrl(shortenedUrl, userId);
      return new CreateShortenedUrlResponse(urlEntity.getId(), urlEntity.getShortenedUrl());
    }

    throw new RuntimeException(String.format("Url Invalid: %s", longUrl));
  }

  @Override
  public String getLongUrl(String urlHash) {
    return stringRedisTemplate.opsForValue().get(urlHash);
  }

  @Override
  public List<String> getUrlsByUserId(Long userId) {
    return iUrlRepository.selectUrlsByUserId(userId);
  }

  @Override
  public String getUrlById(Long userId, Long urlId) {
    return iUrlRepository.selectUrlById(userId, urlId).orElseThrow(() -> {
      throw new RuntimeException(String.format("There is no data for userId: %d urlId: %d", userId, urlId));
    });
  }

  @Override
  public void deleteUrlEntityById(Long userId, Long urlId) {
    var urlEntity = iUrlRepository.selectUrlEntityById(userId, urlId).orElseThrow(() -> {
      throw new RuntimeException(String.format("There is no data for userId: %d urlId: %d", userId, urlId));
    });
    iUrlRepository.delete(urlEntity);
  }

  private String getShortenedUrl(String longUrl) {
    var hash = Hashing.murmur3_32().hashString(longUrl, StandardCharsets.UTF_8).toString();
    stringRedisTemplate.opsForValue().set(hash, longUrl);
    return String.format("http://localhost:8080/s/%s", hash);
  }

  private UrlEntity addUrl(String shortenedUrl, Long userId) {
    if (isCreatedBefore(shortenedUrl)) {
      throw new RuntimeException(String.format("This url is created before: %s ", shortenedUrl));
    }
    var urlEntity = new UrlEntity(shortenedUrl, userId);
    return iUrlRepository.save(urlEntity);
  }

  private boolean isCreatedBefore(String shortenedUrl) {
    return iUrlRepository.selectUrlEntityByShortenedUrl(shortenedUrl).isPresent();
  }
}
