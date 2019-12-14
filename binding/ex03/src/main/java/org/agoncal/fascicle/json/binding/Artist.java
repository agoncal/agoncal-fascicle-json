package org.agoncal.fascicle.json.binding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class Artist {

  private String firstName;
  private String lastName;
  private List<CD> appearsOnCDs;

  // Constructors, getters, setters
  // tag::adocSkip[]

  public Artist() {
  }

  public Artist(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
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

  public List<CD> getAppearsOnCDs() {
    return appearsOnCDs;
  }

  public void setAppearsOnCDs(List<CD> appearsOnCDs) {
    this.appearsOnCDs = appearsOnCDs;
  }

  public void appearsOn(CD cd) {
    if (appearsOnCDs == null)
      appearsOnCDs = new ArrayList<CD>();
    appearsOnCDs.add(cd);
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
