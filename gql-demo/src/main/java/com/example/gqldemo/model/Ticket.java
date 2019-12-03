package com.example.gqldemo.model;

public class Ticket {
  private String id;
  private String title;
  private String createdBy;
  private User user;
  private boolean isDeleted = false;

  public Ticket() {
  }

  public Ticket(String id, String title, String createdBy, User user, boolean isDeleted) {
    this.id = id;
    this.title = title;
    this.createdBy = createdBy;
    this.user = user;
    this.isDeleted = isDeleted;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public boolean getDeleted() {
    return isDeleted;
  }

  public void setDeleted(boolean deleted) {
    isDeleted = deleted;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
