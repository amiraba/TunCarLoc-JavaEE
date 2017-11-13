/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.iBusiness;

import model.bean.Reservation;
import model.bean.VoitureAdd;

/**
 *
 * @author Hela Chikhaoui
 */
public interface IVoitureManager {
    public void deleteRes(String matr);
    public boolean delete(String matricule);
    public boolean reserve(Reservation reservation);
    public void add(VoitureAdd voitureAdd);
    public void update(VoitureAdd voitureAdd);
    public boolean deleteUser(String log);

}
