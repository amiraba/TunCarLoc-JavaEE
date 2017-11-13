package model.annotations;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import model.validators.VoitureDelete_NonExistantMatriculeValidator;


@Target( { FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = VoitureDelete_NonExistantMatriculeValidator.class)

public @interface VoitureDelete_NonExistantMatriculeAnnotation {
    String message();// default "{com.mycompany.constraints.checkcase}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
