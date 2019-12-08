package org.agoncal.fascicle.json.binding;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.agoncal.fascicle.json.UtilTest.initBufferedWriter;
import static org.agoncal.fascicle.json.UtilTest.jsonPath;
import static org.agoncal.fascicle.json.UtilTest.output;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class CustomerTest {

  private static Jsonb jsonb;

  @BeforeAll
  static void init() {
    jsonb = JsonbBuilder.create();
  }

  static BufferedWriter bw;

  @BeforeAll
  static void initFile() throws FileNotFoundException {
    bw = initBufferedWriter("src/test/java/org/agoncal/fascicle/json/binding/CustomerTest.json");
  }

  @AfterAll
  static void closeFile() throws IOException {
    bw.close();
  }

  // ======================================
  // =              Unit tests            =
  // ======================================
  @Test
  public void shouldMarshallACustomer() throws Exception {

    Customer customer = new Customer("John", "Smith", "jsmith@gmail.com", "1234565", LocalDate.now(), LocalDateTime.now());
    String json = jsonb.toJson(customer);
    output(bw, json, "adocShouldMarshallACustomer");

    assertEquals("John", jsonPath(json, "$.firstName"));
    assertEquals("Smith", jsonPath(json, "$.lastName"));
    assertEquals("jsmith@gmail.com", jsonPath(json, "$.email"));
    assertEquals("1234565", jsonPath(json, "$.phoneNumber"));
  }
}
