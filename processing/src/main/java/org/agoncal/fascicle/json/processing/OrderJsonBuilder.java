package org.agoncal.fascicle.json.processing;

import javax.json.Json;
import javax.json.JsonObject;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class OrderJsonBuilder {

  public JsonObject buildPurchaseOrder() {
    return Json.createObjectBuilder().add("order", Json.createObjectBuilder()
      .add("@id", "1234")
      .add("@date", "05/06/2013")
      .add("customer", Json.createObjectBuilder()
        .add("@first_name", "James")
        .add("@last_name", "Rorrison")
        .add("email", "j.rorri@me.com")
        .add("phoneNumber", "+44 1234 1234"))
      .add("content", Json.createObjectBuilder()
        .add("order_line", Json.createArrayBuilder()
          .add(Json.createObjectBuilder()
            .add("@item", "H2G2")
            .add("@quantity", "1")
            .add("unit_price", "23.5"))
          .add(Json.createObjectBuilder()
            .add("@item", "Harry Potter")
            .add("@quantity", "2")
            .add("unit_price", "34.99"))))
      .add("credit_card", Json.createObjectBuilder()
        .add("@number", "1357")
        .add("@expiry_date", "10/13")
        .add("@control_number", "234")
        .add("@type", "Visa"))).build();
  }
  // tag::adocSkip[]

  public static void main(String[] args) {
    System.out.println(new OrderJsonBuilder().buildPurchaseOrder());
  }

  // end::adocSkip[]
}
// end::adocSnippet[]
