/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.validators;

import dao.classes.IDaoVoiture;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import model.annotations.VoitureAdd_UniqueMatriculeAnnotation;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Amira
 */
public class VoitureAdd_UniqueMatriculeValidator implements ConstraintValidator <VoitureAdd_UniqueMatriculeAnnotation, String>{
    
    @Autowired
    IDaoVoiture daoVoiture;
    
    @Override
    public void initialize(VoitureAdd_UniqueMatriculeAnnotation constraintAnnotation) {  
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
       return (daoVoiture.matriculeExists(value) );
    }

}
