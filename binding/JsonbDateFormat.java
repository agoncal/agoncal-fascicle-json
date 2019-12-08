@JsonbAnnotation
@Target({ANNOTATION_TYPE, METHOD, FIELD, PARAMETER, TYPE, PACKAGE})
@Retention(RUNTIME)
public @interface JsonbDateFormat {

  String DEFAULT_LOCALE = "##default";
  String DEFAULT_FORMAT = "##default";
  String TIME_IN_MILLIS = "##time-in-millis";

  String value() default DEFAULT_FORMAT;

  String locale() default DEFAULT_LOCALE;
}
