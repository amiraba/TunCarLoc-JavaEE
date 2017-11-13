/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;
import java.util.List;
import model.bean.KeyValue;
 
import org.springframework.beans.factory.annotation.Autowired;
import model.bean.Reservation;
import model.bean.VoitureAdd;
import model.bean.Rech;
import java.util.ArrayList;
import dao.classes.IDaoAffichage;
import java.util.Iterator;
import model.iBusiness.IAffichageManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Amira
 */
public class AffichageManager implements IAffichageManager {
    IDaoAffichage daoAffichage;
    
    @Override
    public ArrayList display(){
        return (daoAffichage.display());
    }
    @Override
    public ArrayList read(){
            return daoAffichage.read();
        }
 @Override
    public ArrayList readR(){
            return daoAffichage.readR();
        }
    
    @Override
    public ArrayList displayRes(String login){
       ArrayList l=daoAffichage.getRes(login);
       
       ArrayList list= new ArrayList<VoitureAdd>();
       
        for (Iterator it = l.iterator(); it.hasNext();) {
         Reservation r = (Reservation) it.next();
         VoitureAdd v=daoAffichage.findByMatricule(r.getMatricule());
         list.add(v);
        }
        return list;
        
    }
    @Override
    public VoitureAdd find(String matricule){
        return daoAffichage.findByMatricule(matricule);
    }
    
     @Override
     public ArrayList verify(Rech rech){
        return (daoAffichage.verify(rech));
    }
     @Override
    public ArrayList display(Rech rech){
        return (daoAffichage.display(rech));
    }
    
    public IDaoAffichage getDaoAffichage() {
        return daoAffichage;
    }

    public void setDaoAffichage(IDaoAffichage daoAffichage) {
        this.daoAffichage = daoAffichage;
    }
 
    @Override
    public List<KeyValue> getPieChartData() {
        return daoAffichage.getPieChartData();
    }

    @Override
    public Reservation findR(String mat) {
        return daoAffichage.findRByMatricule(mat);
    }
    @Override
    public ArrayList display_Clients() {
            return daoAffichage.display_Clients();
    }
}
