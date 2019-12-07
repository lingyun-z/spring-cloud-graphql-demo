package com.example.userservice.controller;

import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
  @Resource
  private UserService userService;

  private final Logger logger = LoggerFactory.getLogger(UserController.class);

  @GetMapping
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> result = null;
    try{
      result = userService.getAll();
      logger.info("getAllUsers");
    } catch (Exception e) {
      logger.error(e.getMessage());
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
    User result = null;
    try {
      result = userService.selectUserById(id);
      logger.info("getUserById id: {}", id);
    } catch (Exception e) {
      logger.error(e.getMessage());
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @PostMapping("/batch")
  public ResponseEntity<List<User>> getUserByIds(@RequestBody List<String> ids) {
    List<User> result = null;
    try {
      result = userService.getUserByIds(ids);
      logger.info("getUserByIds ids: {}", ids.toString());
    } catch (Exception e) {
      logger.error(e.getMessage());
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody User user) {
    User result = null;
    try {
      result = userService.createUser(user);
      logger.info("createUser user: {}", user.toString());
    } catch (Exception e) {
      logger.error(e.getMessage());
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody User user) {
    User result = null;
    try {
      user.setId(id);
      result = userService.updateUser(user);
      logger.info("updateUser id: {} user: {}", id, user.toString());
    } catch (Exception e) {
      logger.error(e.getMessage());
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteUserById(@PathVariable("id") String id) {
    HttpStatus result = HttpStatus.OK;
    try {
      if (userService.deleteUserById(id) == 0) {
        logger.info("deleteUserById id: {}", id);
        result = HttpStatus.BAD_REQUEST;
      }
    } catch (Exception e) {
      logger.error(e.getMessage());
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(result);
  }
}
