package org.agoncal.fascicle.json.binding;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import static org.agoncal.fascicle.json.UtilTest.initBufferedWriter;
import static org.agoncal.fascicle.json.UtilTest.jsonPath;
import static org.agoncal.fascicle.json.UtilTest.output;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class CDTest {

  private static Jsonb jsonb;

  @BeforeAll
  static void init() {
    jsonb = JsonbBuilder.create();
  }

  static BufferedWriter bw;

  @BeforeAll
  static void initFile() throws FileNotFoundException {
    bw = initBufferedWriter("src/main/java/org/agoncal/fascicle/json/binding/CD.json");
  }

  @AfterAll
  static void closeFile() throws IOException {
    bw.close();
  }

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldMarshallACDWithAMapOfTracks() throws Exception {

    HashMap<Integer, String> tracks = new HashMap<>();
    tracks.put(1, "Wind Up Workin' in a Gas Station");
    tracks.put(2, "Black Napkins");
    tracks.put(3, "The Torture Never Stops");
    CD cd = new CD("Zoot Allures", 12.5F, "Released in October 1976", tracks);

    String json = jsonb.toJson(cd);
    output(bw, json, "shouldMarshallACDWithAMapOfTracks");

    assertEquals("Zoot Allures", jsonPath(json, "$.title"));
    assertEquals(12.5, jsonPath(json, "$.price"));
    assertEquals("Released in October 1976", jsonPath(json, "$.description"));
    // TODO Assert there are 3 tracks
  }
}
