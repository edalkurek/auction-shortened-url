package com.example.auctionshortenedurl.business;

import com.example.auctionshortenedurl.bean.CreateShortenedUrlRequest;
import com.example.auctionshortenedurl.bean.CreateShortenedUrlResponse;
import java.util.List;

public interface IUrlService {

  CreateShortenedUrlResponse createShortenedUrl(CreateShortenedUrlRequest createShortenedUrlRequest, Long userId);

  String getLongUrl(String urlHash);

  List<String> getUrlsByUserId(Long userId);

  String getUrlById(Long userId, Long urlId);

  void deleteUrlEntityById(Long userId, Long urlId);
}
