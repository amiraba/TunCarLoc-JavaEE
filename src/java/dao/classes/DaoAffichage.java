/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.classes;

import com.itextpdf.text.pdf.codec.Base64;
import java.sql.Blob;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.OverridesAttribute.List;
import model.bean.Inscrip;
import model.bean.KeyValue;
import model.bean.Rech;
import model.bean.Reservation;
import model.bean.VoitureAdd;

/**
 *
 * @author Amira
 */
public class DaoAffichage implements IDaoAffichage {

    private Connexion cnx;

    @Override
    public java.util.List<KeyValue> getPieChartData() {
        Logger.getLogger(Connexion.class.getName()).log(Level.INFO,"----> ENTREE");
        //return PieChartData.getPieDataList();
        String req="SELECT V.MARQUE AS MARQUE, COUNT(*) AS COUNT FROM APP.RESERVATION R, APP.VOITURE V WHERE R.MATRICULE=V.MATRICULE GROUP BY V.MARQUE";
        PreparedStatement stmt;
        try {
            stmt = cnx.getInstance().prepareStatement(req);
            ResultSet rs = stmt.executeQuery();
            java.util.List<KeyValue> pieDataList=new ArrayList<KeyValue>();;
            while (rs.next()) {
                KeyValue x=new KeyValue(rs.getString("MARQUE"),rs.getString("COUNT"));
                pieDataList.add(x);
                Logger.getLogger(Connexion.class.getName()).log(Level.INFO,"----> in DaoPieCshart:"+rs.getString("MARQUE")+"\t"+rs.getString("COUNT"));
            }
            return pieDataList;
        }catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.INFO,"----> in DaoPieChart");
        }
        return null;
    }
    
    /**
     *
     * @param @return
     *
     */
    public ArrayList read() {
        ArrayList listeRes = new ArrayList<Reservation>();

        String req = "SELECT * FROM APP.RESERVATION ";

        PreparedStatement stmt;
        try {
            stmt = getCnx().getInstance().prepareStatement(req);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Reservation r = new Reservation();
                r.setLogin(rs.getString("LOGIN"));
                r.setMatricule(rs.getString("MATRICULE"));
                DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                try {
                    java.util.Date date = formatter.parse(rs.getString("DATE"));
                    java.sql.Date sqlDate = new Date(date.getTime());
                    r.setDate(sqlDate);
                    java.util.Date dater;
                    dater = formatter.parse(rs.getString("DATER"));
                    java.sql.Date sqlDater = new Date(dater.getTime());
                    r.setDater(sqlDater);

                } catch (ParseException ex) {
                    Logger.getLogger(DaoAffichage.class.getName()).log(Level.SEVERE, null, ex);
                }

                listeRes.add(r);
            }
            return listeRes;

        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList readR() {
        ArrayList listeRes = new ArrayList<Reservation>();

        String req = "SELECT * FROM APP.RESERVATION ";

        PreparedStatement stmt;
        try {
            stmt = getCnx().getInstance().prepareStatement(req);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Reservation r = new Reservation();
                r.setLogin(rs.getString("LOGIN"));
                r.setMatricule(rs.getString("MATRICULE"));
                DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                try {
                    java.util.Date date = formatter.parse(rs.getString("DATE"));
                    java.sql.Date sqlDate = new Date(date.getTime());
                    r.setDate(sqlDate);
                    java.util.Date dater;
                    dater = formatter.parse(rs.getString("DATER"));
                    java.sql.Date sqlDater = new Date(dater.getTime());
                    r.setDater(sqlDater);
                    Calendar currentDate = Calendar.getInstance(); //Get the current date
                    SimpleDateFormat formatt = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss"); //format it as per your requirement
                    String dateNow = formatt.format(currentDate.getTime());
                    java.util.Date dateNowU = formatt.parse(dateNow);
                    if (dater.before(dateNowU)) {
                        listeRes.add(r);
                    }

                } catch (ParseException ex) {
                    Logger.getLogger(DaoAffichage.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            return listeRes;

        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList display() {
        ArrayList listeVoitures = new ArrayList<VoitureAdd>();
        String req = "SELECT * FROM APP.VOITURE ";
        PreparedStatement stmt;
        try {
            stmt = getCnx().getInstance().prepareStatement(req);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                VoitureAdd v = new VoitureAdd();
                v.setMarque(rs.getString("MARQUE"));
                v.setMatricule(rs.getString("MATRICULE"));
                v.setPrix(rs.getString("PRIX"));
                v.setCouleur(rs.getString("COULEUR"));
                v.setMoteur(rs.getString("MOTEUR"));
                v.setInfo(rs.getString("INFO"));
                v.setDisponibilite(rs.getString("DISPONIBILITE"));
                Blob b = rs.getBlob("IMAGE");
                byte[] Img = b.getBytes(1, (int) b.length());
                String encoded = Base64.encodeBytes(Img);
                v.setImageShown(encoded);
                listeVoitures.add(v);
            }

            return listeVoitures;

        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, "hey");
        }
        return null;
    }

     
    public ArrayList getRes(String login) {
      ArrayList listeRes =  new ArrayList<Reservation>();
      System.out.println(login);
        String req = "SELECT * FROM APP.RESERVATION WHERE (LOGIN =?)";
        
        PreparedStatement stmt;
        try {
            
            stmt = cnx.getInstance().prepareStatement(req);
           stmt.setString(1, login);
            ResultSet rs =stmt.executeQuery();

            while ( rs.next() ){
                System.out.println("hvhv");
                Reservation r= new Reservation();
                r.setLogin(rs.getString("LOGIN"));
                r.setMatricule(rs.getString("MATRICULE"));
                DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                try {
                java.util.Date date = formatter.parse(rs.getString("DATE"));
                java.sql.Date sqlDate = new Date(date.getTime());
                r.setDate(sqlDate);
                java.util.Date dater;
                 dater = formatter.parse(rs.getString("DATER"));
                java.sql.Date sqlDater = new Date(dater.getTime());
                r.setDater(sqlDater);
                
                } catch (ParseException ex) {
                    Logger.getLogger(DaoAffichage.class.getName()).log(Level.SEVERE, null, ex);
                }

                listeRes.add(r);
            }
         return listeRes;

        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public VoitureAdd findByMatricule(String s) {
        String req = "SELECT * FROM APP.VOITURE WHERE (MATRICULE =?)";
        PreparedStatement stmt;
        try {
            stmt = cnx.getInstance().prepareStatement(req);
            stmt.setString(1, s);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {

                VoitureAdd v = new VoitureAdd();
                v.setMarque(rs.getString("MARQUE"));
                v.setCouleur(rs.getString("COULEUR"));
                v.setMatricule(rs.getString("MATRICULE"));
                v.setPrix(rs.getString("PRIX"));
                v.setMoteur(rs.getString("MOTEUR"));
                v.setInfo(rs.getString("INFO"));
                v.setDisponibilite(rs.getString("DISPONIBILITE"));
                Blob b = rs.getBlob("IMAGE");
                byte[] Img = b.getBytes(1, (int) b.length());
                String encoded = Base64.encodeBytes(Img);
                v.setImageShown(encoded);

                return v;

            }
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, "In find Dao Affichage");
        }
        return null;
    }

    public Reservation findRByMatricule(String s) {
        String req = "SELECT * FROM APP.RESERVATION WHERE (MATRICULE =?)";
        PreparedStatement stmt;
        try {
            stmt = cnx.getInstance().prepareStatement(req);
            stmt.setString(1, s);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {

                Reservation r = new Reservation();
                r.setLogin(rs.getString("LOGIN"));
                r.setMatricule(rs.getString("MATRICULE"));
                DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                try {
                    java.util.Date date = formatter.parse(rs.getString("DATE"));
                    java.sql.Date sqlDate = new Date(date.getTime());
                    r.setDate(sqlDate);
                    java.util.Date dater;
                    dater = formatter.parse(rs.getString("DATER"));
                    java.sql.Date sqlDater = new Date(dater.getTime());
                    r.setDater(sqlDater);

                } catch (ParseException ex) {
                    Logger.getLogger(DaoAffichage.class.getName()).log(Level.SEVERE, null, ex);
                }

                return r;

            }
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, "In find Dao Affichage");
        }
        return null;
    }

    @Override
    public ArrayList verify(Rech rech) {
        ArrayList listeVoitures = new ArrayList<VoitureAdd>();

        String req = "SELECT * FROM APP.VOITURE WHERE ( MARQUE=? OR MOTEUR=? OR INFO=? )";
        PreparedStatement stmt;
        try {
            stmt = cnx.getInstance().prepareStatement(req);
            stmt.setString(1, rech.getMotCle());
            stmt.setString(2, rech.getMotCle());
            stmt.setString(3, rech.getMotCle());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                VoitureAdd v = new VoitureAdd();
                v.setMarque(rs.getString("marque"));
                v.setMoteur(rs.getString("moteur"));
                v.setCouleur(rs.getString("couleur"));
                v.setDisponibilite(rs.getString("disponibilite"));
                v.setMatricule(rs.getString("matricule"));
                v.setPrix(rs.getString("prix"));
                v.setInfo(rs.getString("INFO"));
                Blob b = rs.getBlob("IMAGE");
                byte[] Img = b.getBytes(1, (int) b.length());
                String encoded = Base64.encodeBytes(Img);
                v.setImageShown(encoded);
                listeVoitures.add(v);

            }
            return listeVoitures;

        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, "in DaoRech: ------------------");
        }
        return null;
    }

    @Override
    public ArrayList display(Rech rech) {
        ArrayList listeVoitures = new ArrayList<VoitureAdd>();
        String req = "SELECT * FROM APP.VOITURE ";
        PreparedStatement stmt;
        try {
            stmt = cnx.getInstance().prepareStatement(req);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                VoitureAdd v = new VoitureAdd();
                v.setMarque(rs.getString("MARQUE"));
                v.setPrix(rs.getString("COULEUR"));
                v.setMoteur(rs.getString("MOTEUR"));
                v.setInfo(rs.getString("INFO"));
                listeVoitures.add(v);
            }
            return listeVoitures;
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList display_Clients(){
         
          ArrayList listeVoitures =  new ArrayList<VoitureAdd>();
      

        String req="SELECT * FROM APP.CLIENT ";
        PreparedStatement stmt;
        try {
            stmt = cnx.getInstance().prepareStatement(req);
            ResultSet rs =stmt.executeQuery();
            while ( rs.next() ){
                Inscrip cl= new Inscrip();
               cl.setLogin(rs.getString("LOGIN"));
                cl.setName(rs.getString("NOM"));
                cl.setEmail(rs.getString("EMAIL"));
                cl.setSurname(rs.getString("PRENOM"));
                listeVoitures.add(cl);
            }
         return listeVoitures;

        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    /**
     * @return the cnx
     */
    public Connexion getCnx() {
        return cnx;
    }

    /**
     * @param cnx the cnx to set
     */
    public void setCnx(Connexion cnx) {
        this.cnx = cnx;
    }
}
