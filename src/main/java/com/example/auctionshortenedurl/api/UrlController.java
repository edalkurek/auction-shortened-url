package com.example.auctionshortenedurl.api;

import com.example.auctionshortenedurl.bean.CreateShortenedUrlRequest;
import com.example.auctionshortenedurl.bean.CreateShortenedUrlResponse;
import com.example.auctionshortenedurl.business.IUrlService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/{userId}/url")
public class UrlController {

  private final IUrlService iUrlService;

  public UrlController(IUrlService iUrlService) {
    this.iUrlService = iUrlService;
  }

  @PostMapping("/create")
  public CreateShortenedUrlResponse createShortenedUrl(@RequestBody CreateShortenedUrlRequest createShortenedUrlRequest,
                                                       @PathVariable Long userId) {
    return iUrlService.createShortenedUrl(createShortenedUrlRequest, userId);
  }

  @GetMapping("/list")
  public List<String> getUrls(@PathVariable Long userId) {
    return iUrlService.getUrlsByUserId(userId);
  }

  @GetMapping("/detail/{urlId}")
  public String getUrl(@PathVariable Long userId, @PathVariable Long urlId) {
    return iUrlService.getUrlById(userId, urlId);
  }

  @DeleteMapping("/detail/{urlId}")
  public void deleteUrl(@PathVariable Long userId, @PathVariable Long urlId) {
    iUrlService.deleteUrlEntityById(userId, urlId);
  }
}
