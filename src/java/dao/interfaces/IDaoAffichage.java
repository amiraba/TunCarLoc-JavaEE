/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.util.ArrayList;
import model.bean.KeyValue;
import model.bean.Rech;
import model.bean.Reservation;
import model.bean.VoitureAdd;

/**
 *
 * @author Amira
 */
public interface IDaoAffichage {
        public java.util.List<KeyValue> getPieChartData();
    public ArrayList display();
    public Reservation findRByMatricule(String s);
    public ArrayList display(Rech rech);
    public ArrayList verify(Rech rech);
    public ArrayList getRes(String login);
    public VoitureAdd findByMatricule(String s);
    public ArrayList read();
    public ArrayList display_Clients();




}
