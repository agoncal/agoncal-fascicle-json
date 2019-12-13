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
public class CustomerTest {

  private static Jsonb jsonb;

  @BeforeAll
  static void init() {
    jsonb = JsonbBuilder.create();
  }

  static BufferedWriter bw;

  @BeforeAll
  static void initFile() throws FileNotFoundException {
    bw = initBufferedWriter("src/main/java/org/agoncal/fascicle/json/binding/Customer.json");
  }

  @AfterAll
  static void closeFile() throws IOException {
    bw.close();
  }

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldMarshallACustomerWithOneAddress() throws Exception {

    Customer customer = new Customer("John", "Smith", "jsmith@gmail.com", "1234565");
    Address address = new Address("65B Ritherdon Rd", "At James place", "London", "LDN", "7QE554", "UK");
    customer.setAddress(address);

    String json = jsonb.toJson(customer);
    output(bw, json, "shouldMarshallACustomerWithOneAddress");

    assertEquals("John", jsonPath(json, "$.firstName"));
    assertEquals("Smith", jsonPath(json, "$.lastName"));
    assertEquals("jsmith@gmail.com", jsonPath(json, "$.email"));
    assertEquals("1234565", jsonPath(json, "$.phoneNumber"));
    assertEquals("65B Ritherdon Rd", jsonPath(json, "$.address.street1"));
    assertEquals("At James place", jsonPath(json, "$.address.street2"));
    assertEquals("London", jsonPath(json, "$.address.city"));
    assertEquals("LDN", jsonPath(json, "$.address.state"));
    assertEquals("7QE554", jsonPath(json, "$.address.zipcode"));
    assertEquals("UK", jsonPath(json, "$.address.country"));
  }
}
