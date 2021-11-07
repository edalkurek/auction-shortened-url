package com.example.auctionshortenedurl.config;

import com.example.auctionshortenedurl.business.IUrlService;
import com.example.auctionshortenedurl.business.IUserService;
import com.example.auctionshortenedurl.business.UrlServiceImpl;
import com.example.auctionshortenedurl.business.UserServiceImpl;
import com.example.auctionshortenedurl.repository.IUrlRepository;
import com.example.auctionshortenedurl.repository.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuctionShortenedUrlConfig {

  @Bean
  public IUserService iUserService(IUserRepository iUserRepository) {
    return new UserServiceImpl(iUserRepository);
  }

  @Bean
  public IUrlService iUrlService(IUrlRepository iUrlRepository) {
    return new UrlServiceImpl(iUrlRepository);
  }
}
