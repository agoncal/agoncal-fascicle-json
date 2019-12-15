package org.agoncal.fascicle.json.binding;

import com.jayway.jsonpath.PathNotFoundException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyNamingStrategy;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;

import static org.agoncal.fascicle.json.UtilTest.initBufferedWriter;
import static org.agoncal.fascicle.json.UtilTest.jsonPath;
import static org.agoncal.fascicle.json.UtilTest.output;
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
  }
  // end::adocBegin[]

  static BufferedWriter bw;

  @BeforeAll
  static void initFile() throws FileNotFoundException {
    bw = initBufferedWriter("src/main/java/org/agoncal/fascicle/json/binding/Author.json");
  }

  @AfterAll
  static void closeFile() throws IOException {
    bw.close();
  }

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  void shouldMarshallAnAuthorWithCaseInsensitive() throws IOException {

    // tag::adocShouldMarshallAnAuthor[]
    Author author = new Author().firstName("Adams").lastName("Douglas").email("adams@douglas.com").dateOfBirth(LocalDate.of(1952, 03, 11));

    JsonbConfig config = new JsonbConfig().withPropertyNamingStrategy(PropertyNamingStrategy.CASE_INSENSITIVE);
    Jsonb jsonb = JsonbBuilder.create(config);
    String json = jsonb.toJson(author);
    // end::adocShouldMarshallAnAuthor[]

    output(bw, json, "shouldMarshallAnAuthorWithCaseInsensitive");
    JsonReader reader = Json.createReader(new StringReader(json));
    JsonObject jsonObject = reader.readObject();

    assertEquals("Adams", jsonObject.getString("first_name"));
    assertEquals("Douglas", jsonObject.getString("last_name"));
    assertEquals("11.03.1952", jsonObject.getString("dateOfBirth"));
  }

  @Test
  void shouldNotMarshallAnAuthorWithTransientEmail() {

    // tag::adocShouldNotMarshallAnAuthorWithTransientEmail[]
    Author author = new Author().email("adams@douglas.co.uk");

    Jsonb jsonb = JsonbBuilder.create();
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

    assertEquals("Adams", jsonPath(json, "$.first_name"));
    assertEquals("Douglas", jsonPath(json, "$.last_name"));
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
}
