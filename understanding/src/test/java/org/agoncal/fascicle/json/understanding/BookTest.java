package org.agoncal.fascicle.json.understanding;

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
  // =              Methods               =
  // ======================================

  @Test
  void shouldBindABook() {

    Book book = new Book().title("H2G2").price(12.5F).isbn("1-84023-742-2").nbOfPages(354).illustrations(false).description("Best Sci-fi book ever");

    String json = jsonb.toJson(book);

    assertEquals("H2G2", jsonPath(json, "$.title"));
    assertEquals(12.5, jsonPath(json, "$.price"));
    assertEquals("1-84023-742-2", jsonPath(json, "$.isbn"));
    assertEquals(354, jsonPath(json, "$.nbOfPages"));
    assertEquals(Boolean.FALSE, jsonPath(json, "$.illustrations"));
    assertEquals("Best Sci-fi book ever", jsonPath(json, "$.description"));
  }

  @Test
  void output() {
    Book book = new Book().title("H2G2");
    String json = jsonb.toJson(book);
    System.out.println(json);
  }

  private Object jsonPath(String json, String jsonPath) {
    return JsonPath.read(json, jsonPath);
  }
}
