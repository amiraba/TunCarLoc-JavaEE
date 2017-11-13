/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.validators;


import java.util.logging.Level;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.AssertTrue;
import model.bean.Inscrip;
import model.annotations.Inscrip_PasswordsAnnotation;
import org.jboss.logging.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/**
 *
 * @author Amira
 */
public class Inscrip_PasswordsValidator implements ConstraintValidator<Inscrip_PasswordsAnnotation, Object>{
    
    @Autowired
    private Inscrip inscrip;
    private String password;
    private String password2;
    
    @Override
    public void initialize(Inscrip_PasswordsAnnotation constraintAnnotation) {
     password=constraintAnnotation.password();
     password2=constraintAnnotation.password2();
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
         //       java.util.logging.Logger.getLogger(Inscrip_PasswordsValidator.class.getName()).log(Level.INFO, "in Inscrip_PasswordsValidator: "+ value+"compare to"+ inscrip.getPassword()+ inscrip.getPassword2());
                BeanWrapperImpl wrapper = new BeanWrapperImpl(obj);
                String errorMessage = "Fields do not match";
                Object password = wrapper.getPropertyValue("password");
                Object password2=wrapper.getPropertyValue("password2");
                if (password.equals(password2)){
                    return true;
                     }
                context.disableDefaultConstraintViolation();
		context.buildConstraintViolationWithTemplate(errorMessage).addPropertyNode("password").addConstraintViolation();
                context.buildConstraintViolationWithTemplate(errorMessage).addPropertyNode("password2").addConstraintViolation();

            return false;
     
    } 
}