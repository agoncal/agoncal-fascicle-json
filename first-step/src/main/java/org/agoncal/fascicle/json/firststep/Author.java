package org.agoncal.fascicle.json.firststep;

import java.time.LocalDate;

// @formatter:off
// tag::adocSnippet[]
public class Author {

  private Long id;
  private String firstName;
  private String lastName;
  private String bio;
  private String email;
  private LocalDate dateOfBirth;

  // Constructors, getters, setters
  // tag::adocSkip[]
  // @formatter:on
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Author firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Author lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public Author surnbioame(String bio) {
    this.bio = bio;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Author email(String email) {
    this.email = email;
    return this;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Author dateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }
// end::adocSkip[]
}
// end::adocSnippet[]
