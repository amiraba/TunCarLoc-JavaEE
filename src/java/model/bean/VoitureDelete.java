/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import javax.validation.constraints.Digits;
import model.annotations.VoitureDelete_NonExistantMatriculeAnnotation;

/**
 *
 * @author Amira
 */
public class VoitureDelete {
    @VoitureDelete_NonExistantMatriculeAnnotation(message="{VoitureDelete_NonExistantMatriculeAnnotation.matricule}")
    @Digits(integer=5, fraction=0, message="Veuillez entrer un numéro de matricule de 5 chiffres SVP")
    String matricule;

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
}
