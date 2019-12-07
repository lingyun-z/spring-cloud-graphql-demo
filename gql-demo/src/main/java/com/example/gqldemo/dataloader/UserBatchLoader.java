package com.example.gqldemo.dataloader;

import com.example.gqldemo.model.User;
import com.example.gqldemo.service.UserService;
import org.dataloader.BatchLoader;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Component
public class UserBatchLoader implements BatchLoader<String, User> {
  private final Logger logger = LoggerFactory.getLogger(UserBatchLoader.class);

  @Resource
  private UserService userService;

  @Override
  public CompletionStage<List<User>> load(List<String> keys) {
    return CompletableFuture.supplyAsync(() -> userService.getUserByIds(keys));
  }
}
