/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.validators;

import dao.classes.IDaoVoiture;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import model.annotations.VoitureDelete_NonExistantMatriculeAnnotation;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Amira
 */
public class VoitureDelete_NonExistantMatriculeValidator implements ConstraintValidator <VoitureDelete_NonExistantMatriculeAnnotation, String>{

    @Autowired
    IDaoVoiture daoVoiture;
    
    @Override
    public void initialize(VoitureDelete_NonExistantMatriculeAnnotation constraintAnnotation) {
        
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return (!daoVoiture.matriculeExists(value) );
    }
    
}
