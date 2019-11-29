package org.agoncal.fascicle.json.gettingstarted;

import com.github.javafaker.Faker;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateFakeArtists {

  public static void main(String[] args) throws IOException {
    Faker faker = new Faker();
    FileWriter writer = new FileWriter("artists.json");
    JsonGenerator generator = Json.createGenerator(writer);
    generator.writeStartArray();

    for (int i = 0; i < 1_000; i++) {
//      JsonObject json = Json.createObjectBuilder().
//        add("first-name", faker.name().firstName()).
//        add("last-name", faker.name().lastName()).
//        add("email", faker.internet().emailAddress()).
//        add("bio", faker.lorem().characters()).
//        add("date-birth", faker.date().birthday().toString()).
//        build();

      generator.writeStartObject();
      generator.write("first-name", faker.name().firstName());
      generator.write("last-name", faker.name().lastName());
      generator.write("email", faker.internet().emailAddress());
      generator.write("bio", faker.lorem().paragraph());
      generator.write("date-birth", faker.date().birthday().toString());
      generator.writeEnd();
    }
    generator.writeEnd();
    generator.close();

    //writer.close();
  }
}
