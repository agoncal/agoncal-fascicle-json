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
import static org.agoncal.fascicle.json.UtilTest.jsonPath;
import static org.agoncal.fascicle.json.UtilTest.output;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class CreditCardTest {

  private static Jsonb jsonb;

  @BeforeAll
  static void init() {
    jsonb = JsonbBuilder.create();
  }

  static BufferedWriter bw;

  @BeforeAll
  static void initFile() throws FileNotFoundException {
    bw = initBufferedWriter("src/main/java/org/agoncal/fascicle/json/binding/CreditCard.json");
  }

  @AfterAll
  static void closeFile() throws IOException {
    bw.close();
  }

  // ======================================
  // =              Unit tests            =
  // ======================================
  @Test
  public void shouldMarshallACreditCard() throws Exception {

    CreditCard creditCard = new CreditCard("123412341234", "12/12", 1253, CreditCardType.AMERICAN_EXPRESS);
    String json = jsonb.toJson(creditCard);
    output(bw, json, "shouldMarshallACreditCard");

    assertEquals("123412341234", jsonPath(json, "$.number"));
    assertEquals("12/12", jsonPath(json, "$.expiryDate"));
    assertEquals(1253, jsonPath(json, "$.controlNumber"));
    assertEquals("AMERICAN_EXPRESS", jsonPath(json, "$.type"));
  }
}
