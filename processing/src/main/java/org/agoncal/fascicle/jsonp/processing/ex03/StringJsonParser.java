package org.agoncal.fascicle.jsonp.processing.ex03;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParserFactory;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.Map;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// TODO create test
public class StringJsonParser {

  public JsonParser parseString() {
    // tag::adocsnippet[]
    StringReader reader = new StringReader("{'hello', 'world'}");
    JsonParser parser = Json.createParser(reader);
    // end::adocsnippet[]
    return parser;
  }

  public JsonParser parseStringProperties() {
    Map properties = null;
    // tag::adocsnippet2[]
    StringReader reader = new StringReader("{'hello', 'world'}");
    JsonParserFactory factory = Json.createParserFactory(properties);
    JsonParser parser = factory.createParser(reader);
    // end::adocsnippet2[]
    return parser;
  }

  public static void main(String[] args) throws FileNotFoundException {
    JsonParser parser = new StringJsonParser().parseString();
    System.out.println(parser.getString());
  }
}
