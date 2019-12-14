package org.agoncal.fascicle.json.binding;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.agoncal.fascicle.json.UtilTest.initBufferedWriter;
import static org.agoncal.fascicle.json.UtilTest.output;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class ItemTest {

  private static Jsonb jsonb;

  @BeforeAll
  static void init() {
    jsonb = JsonbBuilder.create();
  }

  static BufferedWriter bw;

  @BeforeAll
  static void initFile() throws FileNotFoundException {
    bw = initBufferedWriter("src/main/java/org/agoncal/fascicle/json/binding/Item.json");
  }

  @AfterAll
  static void closeFile() throws IOException {
    bw.close();
  }

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldMarshallSeveralItems() throws Exception {

    Item item = new Item("Junk", 52.50f, "A piece of junk");
    CD cd = new CD("St Pepper", 12.80f, "Beatles master piece", "Apple", 1, 53.32f, "Pop/Rock");
    Book book = new Book("H2G2", 21f, "Best IT book", "123-456-789", "Pinguin", 321, false);

    output(bw, jsonb.toJson(item), "shouldMarshallAnItem");
    output(bw, jsonb.toJson(cd), "shouldMarshallACD");
    output(bw, jsonb.toJson(book), "shouldMarshallABook");
  }
}
