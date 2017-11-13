package model.annotations;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import model.validators.VoitureAdd_UniqueMatriculeValidator;


@Target( { FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = VoitureAdd_UniqueMatriculeValidator.class)

public @interface VoitureAdd_UniqueMatriculeAnnotation {
    String message();// default "{com.mycompany.constraints.checkcase}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
