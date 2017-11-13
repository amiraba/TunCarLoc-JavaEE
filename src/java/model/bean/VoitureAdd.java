/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import javax.validation.constraints.Digits;
import model.annotations.VoitureAdd_UniqueMatriculeAnnotation;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Hela Chikhaoui
 */
public class VoitureAdd {
    @VoitureAdd_UniqueMatriculeAnnotation(message="{VoitureAdd_UniqueMatriculeAnnotation.matricule}")
    @Digits(integer=5, fraction=0, message="Veuillez entrer un numéro de matricule de 5 chiffres SVP")
    private String matricule;
   @NotBlank(message="{NotBlank.marque}")
    private String marque;
    private String couleur;
    @NotBlank
    private String age;
    private String moteur;
    private String puissance;
    @NotBlank(message="{NotBlank.prix}")
    private String prix;
    private String info; 
    @NotBlank
    private String disponibilite;
    private MultipartFile imageUpl;
    private String imageShown;

    public MultipartFile getImageUpl() {
        return imageUpl;
    }

    public void setImageUpl(MultipartFile imageUpl) {
        this.imageUpl = imageUpl;
    }

    public String getImageShown() {
        return imageShown;
    }

    public void setImageShown(String imageShown) {
        this.imageShown = imageShown;
    }

    
    
    

    public MultipartFile getImage() {
        return imageUpl;
    }

    public void setImage(MultipartFile image) {
        this.imageUpl = image;
    }

  

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMoteur() {
        return moteur;
    }

    public void setMoteur(String moteur) {
        this.moteur = moteur;
    }

    public String getPuissance() {
        return puissance;
    }

    public void setPuissance(String puissance) {
        this.puissance = puissance;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(String disponibilite) {
        this.disponibilite = disponibilite;
    }
    
    
    
    
}
