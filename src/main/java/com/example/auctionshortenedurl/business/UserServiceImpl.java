package com.example.auctionshortenedurl.business;

import com.example.auctionshortenedurl.bean.CreateUserRequest;
import com.example.auctionshortenedurl.bean.CreateUserResponse;
import com.example.auctionshortenedurl.entity.User;
import com.example.auctionshortenedurl.repository.IUserRepository;

public class UserServiceImpl implements IUserService {

  private final IUserRepository iUserRepository;

  public UserServiceImpl(IUserRepository iUserRepository) {
    this.iUserRepository = iUserRepository;
  }

  @Override
  public CreateUserResponse createUser(CreateUserRequest createUserRequest) {
    var user = new User(createUserRequest.getUsername(), createUserRequest.getPassword());
    return new CreateUserResponse(iUserRepository.save(user).getId());
  }
}
