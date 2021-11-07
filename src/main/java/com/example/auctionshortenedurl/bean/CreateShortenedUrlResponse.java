package com.example.auctionshortenedurl.bean;

public class CreateShortenedUrlResponse {

  private Long id;

  private String shortenedUrl;

  public CreateShortenedUrlResponse(Long id, String shortenedUrl) {
    this.id = id;
    this.shortenedUrl = shortenedUrl;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getShortenedUrl() {
    return shortenedUrl;
  }

  public void setShortenedUrl(String shortenedUrl) {
    this.shortenedUrl = shortenedUrl;
  }
}
