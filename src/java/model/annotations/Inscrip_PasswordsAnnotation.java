package model.annotations;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import model.validators.Inscrip_PasswordsValidator;

@Target( {ElementType.TYPE, ElementType.ANNOTATION_TYPE}) //@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = Inscrip_PasswordsValidator.class)

public @interface Inscrip_PasswordsAnnotation {
    String message() default "{inscrip.password2}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
  
    /*Cross Field Annotation*/
    
    String password(); //Requires the first password
    String password2();// Requires the second password 
}
