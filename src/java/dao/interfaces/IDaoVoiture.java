/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import model.bean.Reservation;
import model.bean.VoitureAdd;


/**
 *
 * @author Hela Chikhaoui
 */
public interface IDaoVoiture {
    
    public void save(VoitureAdd voitureAdd);
    public void update(VoitureAdd voitureAdd);
    public Boolean matriculeExists(String s);
    public boolean saveR(Reservation reservation);
    public boolean delete(String matricule);
    public void deleteRes(String matr);
    public boolean deleteUser(String log);



    
}
