package com.example.auctionshortenedurl.api;

import com.example.auctionshortenedurl.bean.CreateUserRequest;
import com.example.auctionshortenedurl.bean.CreateUserResponse;
import com.example.auctionshortenedurl.business.IUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  private final IUserService iUserService;

  public UserController(IUserService iUserService) {
    this.iUserService = iUserService;
  }

  @PostMapping("/signup")
  public CreateUserResponse createUser(@RequestBody CreateUserRequest createUserRequest) {
    return iUserService.createUser(createUserRequest);
  }
}
