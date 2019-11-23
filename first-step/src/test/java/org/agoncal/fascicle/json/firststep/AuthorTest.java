package org.agoncal.fascicle.json.firststep;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocBegin[]
public class AuthorTest {

  private static Jsonb jsonb;

  @BeforeAll
  static void init() {
    jsonb = JsonbBuilder.create();
  }
  // end::adocBegin[]

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  void shouldMarshallAnAuthor() {

    // tag::adocShouldMarshallAnAuthor[]
    Author author = new Author().firstName("Adams").lastName("Douglas");

    String json = jsonb.toJson(author);

    assertEquals("Adams", jsonPath(json, "$.first-name"));
    assertEquals("Douglas", jsonPath(json, "$.last-name"));
    // end::adocShouldMarshallAnAuthor[]
  }

  @Test
  void shouldNotMarshallAnAuthorWithTransientDateOfBirth() {

    // tag::adocShouldNotMarshallAnAuthorWithTransientDateOfBirth[]
    Author author = new Author().firstName("Adams").lastName("Douglas").dateOfBirth(LocalDate.now());

    String json = jsonb.toJson(author);

    assertThrows(PathNotFoundException.class, () -> jsonPath(json, "$.dateOfBirth"));
    // end::adocShouldNotMarshallAnAuthorWithTransientDateOfBirth[]
  }

  private String jsonPath(String json, String jsonPath) {
    return JsonPath.read(json, jsonPath);
  }
}
