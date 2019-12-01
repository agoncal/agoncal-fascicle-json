package org.agoncal.fascicle.json.binding;


import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class BookTest {

  private static Jsonb jsonb;

  @BeforeAll
  static void init() {
    JsonbConfig config = new JsonbConfig().withFormatting(true);
    jsonb = JsonbBuilder.create(config);
  }

  // ======================================
  // =              Unit tests            =
  // ======================================
  @Test
  public void shouldCreateABook() throws Exception {

    Book book = new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "The Hitchhiker's Guide to the Galaxy is a science fiction comedy series created by Douglas Adams.", "1-84023-742-2", 354, false);
    String json = jsonb.toJson(book);
    System.out.println(json);
    assertEquals("The Hitchhiker's Guide to the Galaxy", jsonPath(json, "$.book_title"));
    assertEquals(new Double(12.5F), jsonPathDouble(json, "$.price"));
    assertEquals("The Hitchhiker's Guide to the Galaxy is a science fiction comedy series created by Douglas Adams.", jsonPath(json, "$.desc"));
    assertEquals("1-84023-742-2", jsonPath(json, "$.isbn"));
    assertEquals(new Integer(354), jsonPathInt(json, "$.nb_of_pages"));
    assertEquals(new Boolean(false), jsonPathBool(json, "$.illustrations"));
  }

  private String jsonPath(String json, String jsonPath) {
    return JsonPath.read(json, jsonPath);
  }
  private Double jsonPathDouble(String json, String jsonPath) {
    return JsonPath.read(json, jsonPath);
  }
  private Integer jsonPathInt(String json, String jsonPath) {
    return JsonPath.read(json, jsonPath);
  }
  private Boolean jsonPathBool(String json, String jsonPath) {
    return JsonPath.read(json, jsonPath);
  }
}
