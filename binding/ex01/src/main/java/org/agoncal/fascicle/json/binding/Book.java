package org.agoncal.fascicle.json.binding;

import javax.json.bind.annotation.JsonbProperty;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class Book {

  @JsonbProperty(value = "book_title", nillable = false)
  private String title;
  private Float price;
  @JsonbProperty(value = "desc")
  private String description;
  private String isbn;
  @JsonbProperty(value = "nb_of_pages", nillable = true)
  private Integer nbOfPages;
  private Boolean illustrations;

  // Constructors, getters, setters
  // tag::adocSkip[]

  public Book() {
  }

  public Book(String title, Float price, String description, String isbn, Integer nbOfPages, Boolean illustrations) {
    this.title = title;
    this.price = price;
    this.description = description;
    this.isbn = isbn;
    this.nbOfPages = nbOfPages;
    this.illustrations = illustrations;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Book title(String title) {
    this.title = title;
    return this;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public Book price(Float price) {
    this.price = price;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Book description(String description) {
    this.description = description;
    return this;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Book isbn(String isbn) {
    this.isbn = isbn;
    return this;
  }

  public Integer getNbOfPages() {
    return nbOfPages;
  }

  public void setNbOfPages(Integer nbOfPages) {
    this.nbOfPages = nbOfPages;
  }

  public Book nbOfPages(Integer nbOfPages) {
    this.nbOfPages = nbOfPages;
    return this;
  }

  public Boolean getIllustrations() {
    return illustrations;
  }

  public void setIllustrations(Boolean illustrations) {
    this.illustrations = illustrations;
  }

  public Book illustrations(Boolean illustrations) {
    this.illustrations = illustrations;
    return this;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
