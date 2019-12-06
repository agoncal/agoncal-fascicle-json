package org.agoncal.fascicle.json.processing;

import javax.json.Json;
import javax.json.stream.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
// tag::adocSnippet[]
public class OrderJsonParser {

  public String parsePurchaseOrderAndReturnEmail() throws FileNotFoundException {
    String email = null;

    JsonParser parser = Json.createParser(new FileReader("src/main/resources/order.json"));
    while (parser.hasNext()) {
      JsonParser.Event event = parser.next();
      while (parser.hasNext() && !(event.equals(JsonParser.Event.KEY_NAME) && parser.getString().matches("email"))) {
        event = parser.next();
      }

      if (event.equals(JsonParser.Event.KEY_NAME) && parser.getString().matches("email")) {
        parser.next();
        email = parser.getString();
      }
    }
    return email;
  }
  // tag::adocSkip[]

  public static void main(String[] args) throws FileNotFoundException {
    System.out.println(new OrderJsonParser().parsePurchaseOrderAndReturnEmail());
  }

  // end::adocSkip[]
}
// end::adocSnippet[]
