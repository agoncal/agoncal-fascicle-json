package org.agoncal.fascicle.json.gettingstarted;

import com.github.javafaker.Faker;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateFakeArtists {

  public static void main(String[] args) throws IOException {
    Faker faker = new Faker();
    JsonWriter writer = Json.createWriter(new FileWriter("artists.json"));
    for (int i = 0; i < 10_000; i++) {
      JsonObject json = Json.createObjectBuilder().
        add("first-name", faker.name().firstName()).
        add("last-name", faker.name().lastName()).
        add("email", faker.internet().emailAddress()).
        add("bio", faker.lorem().characters()).
        add("date-birth", faker.date().birthday().toString()).
        build();
      writer.write(json);
    }
    //writer.close();
  }
}
