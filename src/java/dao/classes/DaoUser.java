/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.classes;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Authentif;
import model.bean.Inscrip;
import model.bean.Reservation;

/**
 *
 * @author Hela Chikhaoui
 */
public class DaoUser implements IDaoUser {
           private Connexion cnx;

           
          

           
       @Override
    public Boolean save(Inscrip inscrip)
    {
   
    String req="INSERT INTO APP.CLIENT(NOM,PRENOM,EMAIL,LOGIN,PASSWORD) VALUES(?,?,?,?,?)";
          PreparedStatement stmt;
          Boolean b=true;
          try {
         stmt = cnx.getInstance().prepareStatement(req);
            System.out.println("name"+inscrip.getName()+"surname"+inscrip.getSurname()+"mail"+inscrip.getEmail()+"login"+inscrip.getLogin()+"passwd"+inscrip.getPassword());
            stmt.setString(1, inscrip.getName());
           stmt.setString(2, inscrip.getSurname());
            stmt.setString(3, inscrip.getEmail());
           stmt.setString(4, inscrip.getLogin());
            stmt.setString(5, inscrip.getPassword());
            stmt.execute();
         } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, "DaoInscrip: -------");
            b=false;
         }
          return b;
    }
    
       @Override
    public Boolean loginExists (String s){
        String req="SELECT * FROM APP.CLIENT WHERE (LOGIN=?)";
        PreparedStatement stmt;
        try {
            stmt = cnx.getInstance().prepareStatement(req);
            stmt.setString(1, s);
            ResultSet rs=stmt.executeQuery();
            if (rs.next())
                return false;
            return true;
         } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
         }
    }
    
    
    @Override
    public boolean exist(Authentif authentif) {
        boolean b = false;
        String req="SELECT * FROM APP.CLIENT WHERE ( login=? AND password=? )";
        PreparedStatement stmt;
        try {
            stmt = cnx.getInstance().prepareStatement(req);
            stmt.setString(1, authentif.getLogin());
            stmt.setString(2, authentif.getPassword());
            ResultSet rs =stmt.executeQuery();
            if (rs.next() ){
                b=true;
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        Logger.getLogger(Connexion.class.getName()).log(Level.INFO, "******************* b in dao: "+b);
        return b;
    }

    public Connexion getCnx() {
        return cnx;
    }

    public void setCnx(Connexion cnx) {
        this.cnx = cnx;
    }
    
    
}
