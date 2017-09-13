package org.agoncal.fascicle.jsonp.processing.ex05;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import java.io.IOException;
import java.io.StringWriter;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class OrderJsonGenerator {
  public static void main(String[] args) throws IOException {
    System.out.println(new OrderJsonGenerator().generatePurchaseOrder());
  }

  // tag::adocsnippet[]
  public StringWriter generatePurchaseOrder() throws IOException {
    StringWriter writer = new StringWriter();
    JsonGenerator generator = Json.createGenerator(writer);
    generator.writeStartObject()
      .write("id", "1234")
      .write("date", "05/06/2013")
      .writeStartObject("customer")
      .write("first_name", "James")
      .write("last_name", "Rorrison")
      .write("email", "j.rorri@me.com")
      .write("phoneNumber", "+44 1234 1234")
      .writeEnd()
      .writeStartArray("content")
      .writeStartObject()
      .write("item", "H2G2")
      .write("unit_price", "23.5")
      .write("quantity", "1")
      .writeEnd()
      .writeStartObject()
      .write("item", "Harry Potter")
      .write("unit_price", "34.99")
      .write("quantity", "2")
      .writeEnd()
      .writeEnd()
      .writeStartObject("credit_card")
      .write("number", "123412341234")
      .write("expiry_date", "10/13")
      .write("control_number", "234")
      .write("type", "Visa")
      .writeEnd()
      .writeEnd()
      .close();
    return writer;
  }
  // end::adocsnippet[]
}
