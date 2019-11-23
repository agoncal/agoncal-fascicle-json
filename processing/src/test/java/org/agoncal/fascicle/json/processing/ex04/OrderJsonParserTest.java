package org.agoncal.fascicle.json.processing.ex04;


import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class OrderJsonParserTest {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldBuildPurchaseOrder() throws FileNotFoundException {
    // TODO not a great test
    assertNull(new OrderJsonParser().parsePurchaseOrderAndReturnEmail());

  }
}
