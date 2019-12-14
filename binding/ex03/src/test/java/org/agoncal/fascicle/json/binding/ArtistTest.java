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
public class ArtistTest {

  private static Jsonb jsonb;

  @BeforeAll
  static void init() {
    jsonb = JsonbBuilder.create();
  }

  static BufferedWriter bw;

  @BeforeAll
  static void initFile() throws FileNotFoundException {
    bw = initBufferedWriter("src/main/java/org/agoncal/fascicle/json/binding/Artist.json");
  }

  @AfterAll
  static void closeFile() throws IOException {
    bw.close();
  }

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldMarshallThreeCDsAndFourArtists() throws Exception {

    Artist ringo = new Artist("Ringo", "Starr");
    Artist john = new Artist("John", "Lennon");
    Artist franck = new Artist("Franck", "Zappa");
    Artist jimi = new Artist("Jimi", "Hendrix");

    CD zoot = new CD("Zoot Allures", 12.5F, "Released in October 1976, it is mostly a studio album");
    CD sgtpepper = new CD("Sergent Pepper", 28.5F, "Best Beatles Album");
    CD heyjoe = new CD("Hey Joe", 32F, "Hendrix live with friends");

    ringo.appearsOn(sgtpepper);
    john.appearsOn(sgtpepper);
    john.appearsOn(heyjoe);
    franck.appearsOn(zoot);
    franck.appearsOn(heyjoe);
    jimi.appearsOn(heyjoe);
    jimi.appearsOn(sgtpepper);

    zoot.createdBy(franck);
    sgtpepper.createdBy(ringo);
    sgtpepper.createdBy(john);
    heyjoe.createdBy(jimi);

    String json = jsonb.toJson(john);
    output(bw, json, "shouldMarshallThreeCDsAndFourArtists");

    assertEquals("John", jsonPath(json, "$.firstName"));
  }
}
