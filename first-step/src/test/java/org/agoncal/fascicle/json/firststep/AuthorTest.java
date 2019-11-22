package org.agoncal.fascicle.json.firststep;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocBegin[]
public class AuthorTest {

  private static Jsonb jsonb ;

  @BeforeAll
  static void init() {
    Jsonb jsonb = JsonbBuilder.create();
  }
  // end::adocBegin[]

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  void shouldCreateAnAuthor() {

    // tag::adocShouldCreateAnAuthor[]
    Author author = new Author().firstName("Adams").lastName("Douglas");

    String result = jsonb.toJson(author);

    assertNotNull(author.getId(), "Id should not be null");
    // end::adocShouldCreateAnAuthor[]
  }
}
