package org.agoncal.fascicle.json.firststep;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    jsonb = JsonbBuilder.create();
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
    System.out.println(result);

    assertEquals("Adams", jsonPath(result, "$.firstName"));
    assertEquals("Douglas", jsonPath(result, "$.lastName"));
    // end::adocShouldCreateAnAuthor[]
  }

  private String jsonPath(String json, String jsonPath) {
    return JsonPath.read(json, jsonPath);
  }

}
