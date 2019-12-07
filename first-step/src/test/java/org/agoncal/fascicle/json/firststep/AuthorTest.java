package org.agoncal.fascicle.json.firststep;

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
    JsonbConfig config = new JsonbConfig().withFormatting(true);
    jsonb = JsonbBuilder.create(config);
  }
  // end::adocBegin[]

  static BufferedWriter bw;

  @BeforeAll
  static void initFile() throws FileNotFoundException {
    bw = initBufferedWriter("src/test/java/org/agoncal/fascicle/json/firststep/AuthorTest.json");
  }

  @AfterAll
  static void closeFile() throws IOException {
    bw.close();
  }

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  void shouldMarshallAnAuthor() throws IOException {

    // tag::adocShouldMarshallAnAuthor[]
    Author author = new Author().firstName("Adams").lastName("Douglas").dateOfBirth(LocalDate.of(1952, 03, 11));

    Jsonb jsonb = JsonbBuilder.create();
    String json = jsonb.toJson(author);

    // tag::adocSkip[]
    output(bw, json, "adocShouldMarshallAnAuthor");
    // end::adocSkip[]
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
}
