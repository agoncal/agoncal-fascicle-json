package org.agoncal.fascicle.json.puttingtogether;

import org.junit.jupiter.api.Test;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class CreditCardJSonTest {

  public static final String CREDIT_CARD_JSON =
    "{\"creditCard\":" +
      "{\"number\":\"12345678\"," +
      "\"expiryDate\":\"10/14\"," +
      "\"controlNumber\":566," +
      "\"type\":\"Visa\"}" +
      "}";

  @Test
  public void shouldGenerateACreditCard() {

    CreditCard creditCard = new CreditCard("12345678", "10/14", 566, "Visa");

    StringWriter writer = new StringWriter();
    JsonGenerator generator = Json.createGenerator(writer);
    generator.writeStartObject()
      .writeStartObject("creditCard")
      .write("number", creditCard.getNumber())
      .write("expiryDate", creditCard.getExpiryDate())
      .write("controlNumber", creditCard.getControlNumber())
      .write("type", creditCard.getType())
      .writeEnd()
      .writeEnd()
      .close();

    assertEquals(CREDIT_CARD_JSON, writer.toString().trim());
  }
}
// end::adocSnippet[]
