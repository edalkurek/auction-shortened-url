package com.example.auctionshortenedurl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "url")
public class UrlEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "shortened_url", nullable = false)
  private String shortenedUrl;

  @Column(name = "user_id", nullable = false)
  private Long userId;

  public UrlEntity() {

  }

  public UrlEntity(String shortenedUrl, Long userId) {
    this.shortenedUrl = shortenedUrl;
    this.userId = userId;
  }

  public Long getId() {
    return id;
  }

  public String getShortenedUrl() {
    return shortenedUrl;
  }

  public void setShortenedUrl(String shortenedUrl) {
    this.shortenedUrl = shortenedUrl;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}
