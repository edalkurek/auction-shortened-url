package com.example.auctionshortenedurl.business;

import com.example.auctionshortenedurl.bean.CreateUserRequest;
import com.example.auctionshortenedurl.bean.CreateUserResponse;

public interface IUserService {

  CreateUserResponse createUser(CreateUserRequest createUserRequest);
}
