@JsonbAnnotation
@Target({ANNOTATION_TYPE, METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
public @interface JsonbProperty {

  String value() default "";

  boolean nillable() default false;
}
