/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Date;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import model.annotations.Reservation_NonValidMatriculeAnnotation;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Hela Chikhaoui
 */
public class Reservation {
    private String login;
   @Reservation_NonValidMatriculeAnnotation(message="Reservation_NonValidMatriculeAnnotation.matricule")
    private String matricule;
    private Date date;
    private Date dater;

    public Reservation() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDater() {
        return dater;
    }

    public void setDater(Date dater) {
        this.dater = dater;
    }

    public Reservation(String matricule, Date date) {
        this.matricule = matricule;
        this.date = date;
    }
    

    public Reservation(String matricule) {
        this.matricule = matricule;
    }
    
    
}
