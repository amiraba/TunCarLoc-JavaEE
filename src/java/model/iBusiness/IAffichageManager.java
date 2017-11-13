/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.iBusiness;

import model.bean.Reservation;
import model.bean.VoitureAdd;
import model.bean.Rech;
import java.util.ArrayList;
import java.util.List;
import model.bean.KeyValue;

/**
 *
 * @author Hela Chikhaoui
 */
public interface IAffichageManager {
        public ArrayList display(Rech rech);
        public ArrayList read();
        public ArrayList readR();
        public VoitureAdd find(String matricule);
        public ArrayList verify(Rech rech);
        public ArrayList displayRes(String login);
        public ArrayList display();
        public Reservation findR(String mat);
        public List<KeyValue> getPieChartData();
        public ArrayList display_Clients();
}
