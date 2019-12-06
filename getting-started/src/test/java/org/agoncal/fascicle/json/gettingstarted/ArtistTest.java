package org.agoncal.fascicle.json.gettingstarted;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import java.time.LocalDate;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocBegin[]
public class ArtistTest {

  private static Jsonb jsonb;

  @BeforeAll
  static void init() {
    JsonbConfig config = new JsonbConfig().withFormatting(true);
    jsonb = JsonbBuilder.create(config);
  }
  // end::adocBegin[]

  // ======================================
  // =              Methods               =
  // ======================================

  // tag::adocShouldRaiseNoConstraintViolation[]
  @Test
  void shouldRaiseNoConstraintViolation() {

    Artist artist = new Artist().firstName("Adams").lastName("Douglas");

  }
  // end::adocShouldRaiseNoConstraintViolation[]

  // tag::shouldRaiseConstraintViolationCauseFirstNameIsNull[]
  @Test
  void shouldRaiseConstraintViolationCauseFirstNameIsNull() {

    Artist artist = new Artist().firstName(null).lastName("Douglas");

  }
  // end::shouldRaiseConstraintViolationCauseFirstNameIsNull[]

  // tag::shouldRaiseConstraintViolationCauseInvalidEmail[]
  @Test
  void shouldRaiseConstraintViolationCauseInvalidEmail() {

    Artist artist = new Artist().firstName("Adams").lastName("Douglas").email("wrong");

  }
  // end::shouldRaiseConstraintViolationCauseInvalidEmail[]

  // tag::shouldRaiseTwoConstraintViolationsCauseInvalidEmailAndFutureDate[]
  @Test
  void shouldRaiseTwoConstraintViolationsCauseInvalidEmailAndFutureDate() {

    LocalDate dateOfBirth = LocalDate.of(2678, 12, 01);
    Artist artist = new Artist().firstName("Adams").lastName("Douglas").email("wrong").dateOfBirth(dateOfBirth);

  }
  // end::shouldRaiseTwoConstraintViolationsCauseInvalidEmailAndFutureDate[]
}
