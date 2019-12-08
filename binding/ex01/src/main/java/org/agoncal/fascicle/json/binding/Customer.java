package org.agoncal.fascicle.json.binding;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbTransient;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class Customer {

  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  @JsonbDateFormat
  private LocalDate dateOfBirth;
  // tag::adocSkiptransient[]
  @JsonbTransient
  private Integer age;
  // end::adocSkiptransient[]
  private LocalDateTime creationDate;
  @JsonbDateFormat
  private LocalDateTime updateDate;
  @JsonbDateFormat
  private Date deleteDate;

  // Constructors, getters, setters
  // tag::adocSkip[]

  public Customer() {
  }

  public Customer(String firstName, String lastName, String email, String phoneNumber, LocalDate dateOfBirth, LocalDateTime creationDate) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.dateOfBirth = dateOfBirth;
    this.creationDate = creationDate;
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

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public LocalDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
  }

  public LocalDateTime getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(LocalDateTime updateDate) {
    this.updateDate = updateDate;
  }

  public Date getDeleteDate() {
    return deleteDate;
  }

  public void setDeleteDate(Date deleteDate) {
    this.deleteDate = deleteDate;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
