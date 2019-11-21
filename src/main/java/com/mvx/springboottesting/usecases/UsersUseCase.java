package com.mvx.springboottesting.usecases;

import com.mvx.springboottesting.entities.User;
import com.mvx.springboottesting.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersUseCase {

    @Autowired
    private UserRepository repo;

  public List<User> findAll() {
    return repo.findAll();
  }
}