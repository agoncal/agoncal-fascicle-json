package org.agoncal.fascicle.json.binding;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;

import static org.agoncal.fascicle.json.UtilTest.initBufferedWriter;
import static org.agoncal.fascicle.json.UtilTest.jsonPath;
import static org.agoncal.fascicle.json.UtilTest.output;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class PurchaseOrderTest {

  private static Jsonb jsonb;

  @BeforeAll
  static void init() {
    jsonb = JsonbBuilder.create();
  }

  static BufferedWriter bw;

  @BeforeAll
  static void initFile() throws FileNotFoundException {
    bw = initBufferedWriter("src/main/java/org/agoncal/fascicle/json/binding/PurchaseOrder.json");
  }

  @AfterAll
  static void closeFile() throws IOException {
    bw.close();
  }

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldMarshallAPurchaseOrder() throws Exception {

    PurchaseOrder po = new PurchaseOrder(123456789, new BigDecimal(1580), (long) 17, 5.5, new BigDecimal(1888.99625));
    String json = jsonb.toJson(po);
    output(bw, json, "shouldMarshallAPurchaseOrder");

    assertEquals(123456789, jsonPath(json, "$.id"));
    assertEquals("1,580.00", jsonPath(json, "$.totalWithoutTax"));
    assertEquals("17.00", jsonPath(json, "$.taxRate"));
    assertEquals(5.5, jsonPath(json, "$.discountRate"));
    assertEquals("1,889.00", jsonPath(json, "$.totalTax"));
  }
}
