/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.validators;
import dao.classes.IDaoUser;
import model.annotations.Inscrip_UniqueLoginAnnotation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Amira
 */
public class Inscrip_UniqueLoginValidator implements ConstraintValidator<Inscrip_UniqueLoginAnnotation, String>{

    @Autowired
    IDaoUser daoUser;
    
    @Override
    public void initialize(Inscrip_UniqueLoginAnnotation constraintAnnotation) {
        
    }

    @Override
    public boolean isValid(String login, ConstraintValidatorContext context) {
        return (daoUser.loginExists(login) );
    }
    
}
