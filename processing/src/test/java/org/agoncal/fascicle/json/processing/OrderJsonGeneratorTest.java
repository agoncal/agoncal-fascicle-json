package org.agoncal.fascicle.json.processing;


import org.agoncal.fascicle.json.processing.OrderJsonGenerator;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class OrderJsonGeneratorTest {

  // ======================================
  // =             Attributes             =
  // ======================================

  public static final String orderJSon = "{\"id\":\"1234\",\"date\":\"05/06/2013\",\"customer\":{\"first_name\":\"James\",\"last_name\":\"Rorrison\",\"email\":\"j.rorri@me.com\",\"phoneNumber\":\"+44 1234 1234\"},\"content\":[{\"item\":\"H2G2\",\"unit_price\":\"23.5\",\"quantity\":\"1\"},{\"item\":\"Harry Potter\",\"unit_price\":\"34.99\",\"quantity\":\"2\"}],\"credit_card\":{\"number\":\"123412341234\",\"expiry_date\":\"10/13\",\"control_number\":\"234\",\"type\":\"Visa\"}}";

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldGeneratePurchaseOrder() throws IOException {

    assertEquals(orderJSon, new OrderJsonGenerator().generatePurchaseOrder().toString());

  }
}
