package org.agoncal.fascicle.json.gettingstarted;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import java.time.LocalDate;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
// tag::adocSnippet[]
public class Artist {

  @JsonbProperty("first-name")
  private String firstName;

  @JsonbProperty(value="last-name", nillable=true)
  private String lastName;

  private String email;

  private String bio;

  @JsonbProperty("date-birth")
  @JsonbDateFormat("dd.MM.yyyy")
  private LocalDate dateOfBirth;

  // Constructors, getters, setters
  // tag::adocSkip[]
  // @formatter:on
  public Artist() {
  }

  public Artist(String firstName, String lastName, String email, String bio, LocalDate dateOfBirth) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.bio = bio;
    this.dateOfBirth = dateOfBirth;
  }


  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Artist firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Artist lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Artist email(String email) {
    this.email = email;
    return this;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public Artist bio(String bio) {
    this.bio = bio;
    return this;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Artist dateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  // ======================================
  // =         hash, equals, toString     =
  // ======================================

  @Override
  public String toString() {
    return "Artist{" +
      "firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", email='" + email + '\'' +
      ", bio='" + bio + '\'' +
      ", dateOfBirth=" + dateOfBirth +
      '}';
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
