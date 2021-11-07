package com.example.auctionshortenedurl.bean;

public class CreateUserResponse {

  private Long userId;

  public CreateUserResponse(Long userId) {
    this.userId = userId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}
