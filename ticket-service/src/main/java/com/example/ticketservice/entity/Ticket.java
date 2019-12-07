package com.example.ticketservice.entity;

public class Ticket {
  private String id;
  private String title;
  private String createdBy;
  private boolean isDeleted = false;

  public Ticket() {
  }

  public Ticket(String id, String title, String createdBy, Boolean isDeleted) {
    this.id = id;
    this.title = title;
    this.createdBy = createdBy;
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

  @Override
  public String toString() {
    return "Ticket{" +
            "id='" + id + '\'' +
            ", title='" + title + '\'' +
            ", createdBy='" + createdBy + '\'' +
            ", isDeleted=" + isDeleted +
            '}';
  }
}
