package org.agoncal.fascicle.json.firststep;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import java.io.StringReader;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
    JsonbConfig config = new JsonbConfig().withFormatting(true);
    jsonb = JsonbBuilder.create(config);
  }
  // end::adocBegin[]

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  void shouldMarshallAnAuthor() {

    // tag::adocShouldMarshallAnAuthor[]
    Author author = new Author().firstName("Adams").lastName("Douglas").dateOfBirth(LocalDate.of(1952, 03, 11));

    Jsonb jsonb = JsonbBuilder.create();
    String json = jsonb.toJson(author);

    JsonReader reader = Json.createReader(new StringReader(json));
    JsonObject jsonObject = reader.readObject();

    assertEquals("Adams", jsonObject.getString("first-name"));
    assertEquals("Douglas", jsonObject.getString("last-name"));
    assertEquals("11.03.1952", jsonObject.getString("dateOfBirth"));
    // end::adocShouldMarshallAnAuthor[]
  }

  @Test
  void shouldNotMarshallAnAuthorWithTransientEmail() {

    // tag::adocShouldNotMarshallAnAuthorWithTransientEmail[]
    Author author = new Author().firstName("Adams").lastName("Douglas").email("adams@douglas.co.uk");

    String json = jsonb.toJson(author);

    JsonReader reader = Json.createReader(new StringReader(json));
    JsonObject jsonObject = reader.readObject();

    assertNull(jsonObject.get("email"));
    // end::adocShouldNotMarshallAnAuthorWithTransientEmail[]
  }

  @Test
  void shouldMarshallAnAuthorWithPath() {

    // tag::adocShouldMarshallAnAuthorWithPath[]
    Author author = new Author().firstName("Adams").lastName("Douglas").dateOfBirth(LocalDate.of(1952, 03, 11));

    String json = jsonb.toJson(author);

    assertEquals("Adams", jsonPath(json, "$.first-name"));
    assertEquals("Douglas", jsonPath(json, "$.last-name"));
    assertEquals("11.03.1952", jsonPath(json, "$.dateOfBirth"));
    // end::adocShouldMarshallAnAuthorWithPath[]
  }

  @Test
  void shouldNotMarshallAnAuthorWithTransientEmailWithPath() {

    // tag::adocShouldNotMarshallAnAuthorWithTransientEmailWithPath[]
    Author author = new Author().firstName("Adams").lastName("Douglas").email("adams@douglas.co.uk");

    String json = jsonb.toJson(author);

    assertThrows(PathNotFoundException.class, () -> jsonPath(json, "$.email"));
    // end::adocShouldNotMarshallAnAuthorWithTransientEmailWithPath[]
  }

  @Test
  void output() {
    Author author = new Author().firstName("Adams").lastName("Douglas").dateOfBirth(LocalDate.of(1952, 03, 11));
    String json = jsonb.toJson(author);
    System.out.println(json);
  }

  private String jsonPath(String json, String jsonPath) {
    return JsonPath.read(json, jsonPath);
  }
}
