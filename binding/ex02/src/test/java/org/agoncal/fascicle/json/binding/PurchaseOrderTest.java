package org.agoncal.fascicle.json.binding;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import static org.agoncal.fascicle.json.UtilTest.initBufferedWriter;
import static org.agoncal.fascicle.json.UtilTest.output;

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
  public void shouldMarshallAnOrderWithTwoOrderLines() throws Exception {

    OrderLine ol1 = new OrderLine("H2G2", 12d, 1);
    OrderLine ol2 = new OrderLine("The White Album", 14.5d, 2);
    PurchaseOrder order = new PurchaseOrder();
    order.setOrderLines(Arrays.asList(ol1, ol2));

    String json = jsonb.toJson(order);
    output(bw, json, "shouldMarshallAnOrderWithTwoOrderLines");

    // TODO Assert 2 order line
  }
}
