package org.agoncal.fascicle.json.binding;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyNamingStrategy;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import static org.agoncal.fascicle.json.UtilTest.initBufferedWriter;
import static org.agoncal.fascicle.json.UtilTest.jsonPath;
import static org.agoncal.fascicle.json.UtilTest.output;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocBegin[]
public class AuthorTest {

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

    // tag::adocShouldMarshallAnAuthorWithCaseInsensitive[]
    Author author = new Author().firstName("Adams").lastName("Douglas").email("adams@douglas.com").dateOfBirth(LocalDate.of(1952, 03, 11));

    JsonbConfig config = new JsonbConfig().withPropertyNamingStrategy(PropertyNamingStrategy.CASE_INSENSITIVE);
    Jsonb jsonb = JsonbBuilder.create(config);
    String json = jsonb.toJson(author);
    // end::adocShouldMarshallAnAuthorWithCaseInsensitive[]

    output(bw, json, "adocShouldMarshallAnAuthorWithCaseInsensitive");

    assertEquals("Adams", jsonPath(json, "$.firstName"));
    assertEquals("Douglas", jsonPath(json,"$.lastName"));
    assertEquals("adams@douglas.com", jsonPath(json,"$.email"));
    assertEquals("1952-03-11", jsonPath(json,"$.dateOfBirth"));
  }

  @Test
  void shouldMarshallAnAuthorWithIdentity() throws IOException {

    // tag::adocShouldMarshallAnAuthorWithIdentity[]
    Author author = new Author().firstName("Adams").lastName("Douglas").email("adams@douglas.com").dateOfBirth(LocalDate.of(1952, 03, 11));

    JsonbConfig config = new JsonbConfig().withPropertyNamingStrategy(PropertyNamingStrategy.IDENTITY);
    Jsonb jsonb = JsonbBuilder.create(config);
    String json = jsonb.toJson(author);
    // end::adocShouldMarshallAnAuthorWithIdentity[]

    output(bw, json, "adocShouldMarshallAnAuthorWithIdentity");

    assertEquals("Adams", jsonPath(json, "$.firstName"));
    assertEquals("Douglas", jsonPath(json,"$.lastName"));
    assertEquals("adams@douglas.com", jsonPath(json,"$.email"));
    assertEquals("1952-03-11", jsonPath(json,"$.dateOfBirth"));
  }

  @Test
  void shouldMarshallAnAuthorWithLowerCaseWithDashes() throws IOException {

    // tag::adocShouldMarshallAnAuthorWithLowerCaseWithDashes[]
    Author author = new Author().firstName("Adams").lastName("Douglas").email("adams@douglas.com").dateOfBirth(LocalDate.of(1952, 03, 11));

    JsonbConfig config = new JsonbConfig().withPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE_WITH_DASHES);
    Jsonb jsonb = JsonbBuilder.create(config);
    String json = jsonb.toJson(author);
    // end::adocShouldMarshallAnAuthorWithLowerCaseWithDashes[]

    output(bw, json, "adocShouldMarshallAnAuthorWithLowerCaseWithDashes");

    assertEquals("Adams", jsonPath(json, "$.first-name"));
    assertEquals("Douglas", jsonPath(json,"$.last-name"));
    assertEquals("adams@douglas.com", jsonPath(json,"$.email"));
    assertEquals("1952-03-11", jsonPath(json,"$.date-of-birth"));
  }

  @Test
  void shouldMarshallAnAuthorWithLowerCaseWithUnderscores() throws IOException {

    // tag::adocShouldMarshallAnAuthorWithLowerCaseWithUnderscores[]
    Author author = new Author().firstName("Adams").lastName("Douglas").email("adams@douglas.com").dateOfBirth(LocalDate.of(1952, 03, 11));

    JsonbConfig config = new JsonbConfig().withPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE_WITH_UNDERSCORES);
    Jsonb jsonb = JsonbBuilder.create(config);
    String json = jsonb.toJson(author);
    // end::adocShouldMarshallAnAuthorWithLowerCaseWithUnderscores[]

    output(bw, json, "adocShouldMarshallAnAuthorWithLowerCaseWithUnderscores");

    assertEquals("Adams", jsonPath(json, "$.first_name"));
    assertEquals("Douglas", jsonPath(json,"$.last_name"));
    assertEquals("adams@douglas.com", jsonPath(json,"$.email"));
    assertEquals("1952-03-11", jsonPath(json,"$.date_of_birth"));
  }

  @Test
  void shouldMarshallAnAuthorWithUpperCamelCase() throws IOException {

    // tag::adocShouldMarshallAnAuthorWithUpperCamelCase[]
    Author author = new Author().firstName("Adams").lastName("Douglas").email("adams@douglas.com").dateOfBirth(LocalDate.of(1952, 03, 11));

    JsonbConfig config = new JsonbConfig().withPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
    Jsonb jsonb = JsonbBuilder.create(config);
    String json = jsonb.toJson(author);
    // end::adocShouldMarshallAnAuthorWithUpperCamelCase[]

    output(bw, json, "adocShouldMarshallAnAuthorWithUpperCamelCase");

    assertEquals("Adams", jsonPath(json, "$.FirstName"));
    assertEquals("Douglas", jsonPath(json,"$.LastName"));
    assertEquals("adams@douglas.com", jsonPath(json,"$.Email"));
    assertEquals("1952-03-11", jsonPath(json,"$.DateOfBirth"));
  }

  @Test
  void shouldMarshallAnAuthorWithUpperCamelCaseWithSpaces() throws IOException {

    // tag::adocShouldMarshallAnAuthorWithUpperCamelCaseWithSpaces[]
    Author author = new Author().firstName("Adams").lastName("Douglas").email("adams@douglas.com").dateOfBirth(LocalDate.of(1952, 03, 11));

    JsonbConfig config = new JsonbConfig().withPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE_WITH_SPACES);
    Jsonb jsonb = JsonbBuilder.create(config);
    String json = jsonb.toJson(author);
    // end::adocShouldMarshallAnAuthorWithUpperCamelCaseWithSpaces[]

    output(bw, json, "adocShouldMarshallAnAuthorWithUpperCamelCaseWithSpaces");

    assertEquals("Adams", jsonPath(json, "$.['First Name']"));
    assertEquals("Douglas", jsonPath(json,"$.['Last Name']"));
    assertEquals("adams@douglas.com", jsonPath(json,"$.['Email']"));
    assertEquals("1952-03-11", jsonPath(json,"$.['Date Of Birth']"));
  }
}
