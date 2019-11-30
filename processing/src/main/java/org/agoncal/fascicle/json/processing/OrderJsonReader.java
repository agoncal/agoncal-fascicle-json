package org.agoncal.fascicle.json.processing;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class OrderJsonReader {

  public JsonObject readPurchaseOrder() throws FileNotFoundException {
    // tag::adocSnippet[]
    JsonReader reader = Json.createReader(new FileReader("src/main/resources/order.json"));
    JsonObject jsonObject = reader.readObject();
    jsonObject = jsonObject.getJsonObject("order");
    // end::adocSnippet[]
    return jsonObject;
  }

  public static void main(String[] args) throws FileNotFoundException {
    System.out.println(new OrderJsonReader().readPurchaseOrder());
  }
}
