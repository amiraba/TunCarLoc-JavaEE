/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.validators;

import dao.classes.IDaoVoiture;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import model.annotations.Reservation_NonValidMatriculeAnnotation;
import model.annotations.VoitureAdd_UniqueMatriculeAnnotation;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Hela Chikhaoui
 */
public class Reservation_NonValidMatriculeValidator implements ConstraintValidator <Reservation_NonValidMatriculeAnnotation, String>{
    
    @Autowired
    IDaoVoiture daoVoiture;
    
    @Override
    public void initialize(Reservation_NonValidMatriculeAnnotation constraintAnnotation) {  
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
       return (!daoVoiture.matriculeExists(value) );
    }

}
