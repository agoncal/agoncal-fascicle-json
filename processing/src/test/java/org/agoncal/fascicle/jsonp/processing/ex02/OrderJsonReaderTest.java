package org.agoncal.fascicle.jsonp.processing.ex02;


import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class OrderJsonReaderTest {

  // ======================================
  // =             Attributes             =
  // ======================================

  public static final String orderJSon = "{\"id\":\"1234\",\"date\":\"05/06/2013\",\"customer\":{\"first_name\":\"James\",\"last_name\":\"Rorrison\",\"email\":\"j.rorri@me.com\",\"phoneNumber\":\"+44 1234 1234\"},\"content\":{\"order_line\":[{\"item\":\"H2G2\",\"quantity\":\"1\",\"unit_price\":\"23.5\"},{\"item\":\"Harry Potter\",\"quantity\":\"2\",\"unit_price\":\"34.99\"}]},\"credit_card\":{\"number\":\"1357\",\"expiry_date\":\"10/13\",\"control_number\":\"234\",\"type\":\"Visa\"}}";

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldBuildPurchaseOrder() throws FileNotFoundException {

    assertEquals(orderJSon, new OrderJsonReader().readPurchaseOrder().toString());

  }
}
