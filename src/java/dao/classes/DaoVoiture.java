package dao.classes;
import com.itextpdf.text.pdf.codec.Base64;
import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Reservation;
import model.bean.VoitureAdd;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Hela Chikhaoui
 */
public class DaoVoiture implements IDaoVoiture {
       private Connexion cnx;

    public void save(VoitureAdd voitureAdd)
    {
    
    String req="INSERT INTO APP.VOITURE(matricule,marque,couleur,age,moteur,puissance,prix,info,disponibilite,image) VALUES(?,?,?,?,?,?,?,?,?,?)";
          PreparedStatement stmt;
        try {
         stmt = cnx.getInstance().prepareStatement(req);

            stmt.setString(1, voitureAdd.getMatricule());
            stmt.setString(2, voitureAdd.getMarque());
            stmt.setString(3, voitureAdd.getCouleur());
            stmt.setString(4, voitureAdd.getAge());
            stmt.setString(5, voitureAdd.getMoteur());
            stmt.setString(6, voitureAdd.getPuissance());
            stmt.setString(7, voitureAdd.getPrix());
            stmt.setString(8, voitureAdd.getInfo());
            stmt.setString(9, voitureAdd.getDisponibilite());
            MultipartFile image = voitureAdd.getImage();
        
        try {
            stmt.setBinaryStream(10,image.getInputStream(), (int) image.getSize());
        } catch (IOException ex) {
            Logger.getLogger(DaoVoiture.class.getName()).log(Level.SEVERE, "FileUpload Exception");
        }


            stmt.execute();
         } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, "in DaoVoitureDelete: ---------");
            
         }
    }
    
    public boolean saveR(Reservation reservation){
        boolean b = true;
        String req="INSERT INTO APP.RESERVATION(matricule,login,date,dater) VALUES(?,?,?,?)";
        String requ="UPDATE  APP.VOITURE SET DISPONIBILITE=? WHERE (matricule=?)";
        String re="SELECT * FROM APP.VOITURE WHERE( matricule=? )";
          PreparedStatement stmt;
          PreparedStatement stm;
          PreparedStatement state;
        try {
           String reqGetNom="SELECT * FROM APP.CLIENT WHERE( login= ? )";
            PreparedStatement st;
            st=cnx.getInstance().prepareStatement(reqGetNom);
            state=cnx.getInstance().prepareStatement(re);
            state.setString(1, reservation.getMatricule());
            st.setString(1, reservation.getLogin());
            ResultSet rsGetNom=st.executeQuery();
                        if (rsGetNom.next())
            System.out.println(""+reservation.getLogin()+"**"+reservation.getMatricule());
            stmt = cnx.getInstance().prepareStatement(req);
            stm=cnx.getInstance().prepareStatement(requ);
            stmt.setString(1, reservation.getMatricule());
            stmt.setString(2, rsGetNom.getString("login"));
            DateFormat df = new java.text.SimpleDateFormat("MM/dd/yyyy");
               String BDDate = df.format(reservation.getDate());
               String BDDater = df.format(reservation.getDater());

            stmt.setString(3, BDDate);
            stmt.setString(4,BDDater);
            ResultSet rsGetDispo=state.executeQuery();
            DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            

            if (rsGetDispo.next()&!(rsGetDispo.getString("DISPONIBILITE").equals("disponible")))
                {
                    
                    try {
                java.util.Date dateDis = formatter.parse(rsGetDispo.getString("DISPONIBILITE"));
                java.util.Date dater = reservation.getDate();
                    if(dateDis.before(dater))
                    {
                      b=true;
                      stmt.execute();
                      stm.setString(1,BDDater);
                      stm.setString(2,reservation.getMatricule());
                      stm.execute();
                    }
                    else b=false;
                    
                } catch (ParseException ex) {
                    Logger.getLogger(DaoAffichage.class.getName()).log(Level.SEVERE, null, ex);
                }
                   
                


         }
           if (rsGetDispo.getString("DISPONIBILITE").equals("disponible")){
           
           
                
                      b=true;
                      stmt.execute();
                      stm.setString(1,BDDater);
                      stm.setString(2,reservation.getMatricule());
                      stm.execute();
                    
                    
              
           }
        
        }catch (SQLException ex) {
         Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        
         }
                return b;
    }
    
    public boolean delete(String matricule){
        String req="DELETE FROM APP.VOITURE WHERE (MATRICULE =?)";
        String requ="SELECT * FROM APP.VOITURE WHERE (MATRICULE =?)";
          PreparedStatement stmt;
          PreparedStatement stm;
        try {
            stm = cnx.getInstance().prepareStatement(requ);
            stm.setString(1, matricule);
            ResultSet rsGetM=stm.executeQuery();
             if (rsGetM.next()& rsGetM.getString("DISPONIBILITE").equals("disponible"))
            {
            stmt = cnx.getInstance().prepareStatement(req);
            stmt.setString(1, matricule);
            stmt.execute();
            return true;
            }
           
         } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, "DaoVoiture: -Delete Method");
         }
        return false;
    }
    
    public void deleteRes(String matr){
        String req="DELETE FROM APP.RESERVATION WHERE ( matricule=?)";
          PreparedStatement stmt;
        try {
            stmt = cnx.getInstance().prepareStatement(req);
            stmt.setString(1, matr);
            stmt.execute();
            VoitureAdd v = findByMatricule(matr);
            v.setDisponibilite("disponible");
            update(v);
         } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, "DaoVoiture: ----------");
         }
    }

    public VoitureAdd findByMatricule(String s){
        String req="SELECT * FROM APP.VOITURE WHERE (MATRICULE =?)";
        PreparedStatement stmt;
        try {
            stmt = cnx.getInstance().prepareStatement(req);
            stmt.setString(1, s);
            ResultSet rs=stmt.executeQuery();
            if (rs.next())
            {
                
                VoitureAdd v= new VoitureAdd();
                v.setMarque(rs.getString("MARQUE"));
                v.setAge(rs.getString("AGE"));
                v.setCouleur(rs.getString("COULEUR"));
                v.setMatricule(rs.getString("MATRICULE"));
                v.setPrix(rs.getString("PRIX"));
                v.setMoteur(rs.getString("MOTEUR"));
                v.setInfo(rs.getString("INFO"));
                v.setDisponibilite(rs.getString("DISPONIBILITE"));
                Blob b = rs.getBlob("IMAGE");
               byte[] Img = b.getBytes(1, (int) b.length());
              String encoded=Base64.encodeBytes(Img);
              v.setImageShown(encoded);
                
                        return v;

            }
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, "In find Dao Affichage");
        }
        return null;
}
    
    public Connexion getCnx() {
        return cnx;
    }

    public void setCnx(Connexion cnx) {
        this.cnx = cnx;
    }
    
       @Override
    public Boolean matriculeExists(String s){
        String req="SELECT * FROM APP.VOITURE WHERE (MATRICULE=?)";
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
     public void update(VoitureAdd voitureAdd){
       
       String req;;
       PreparedStatement stmt;
       if(!voitureAdd.getDisponibilite().isEmpty()){
           req="UPDATE  APP.VOITURE SET DISPONIBILITE=? WHERE (matricule=?)";
            try {
            stmt = cnx.getInstance().prepareStatement(req);
            stmt.setString(1, voitureAdd.getDisponibilite());
            stmt.setString(2, voitureAdd.getMatricule());
            stmt.execute();
         } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, "DaoVoiture: ----------");
         }
       }
       if(!voitureAdd.getAge().isEmpty()){
           req="UPDATE  APP.VOITURE SET AGE=? WHERE (matricule=?)";
            try {
            stmt = cnx.getInstance().prepareStatement(req);
            stmt.setString(1, voitureAdd.getAge());
            stmt.setString(2, voitureAdd.getMatricule());
            stmt.execute();
         } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, "DaoVoiture: ----------");
         }
     }
     }
      public boolean deleteUser(String log){
        String req="DELETE FROM APP.CLIENT WHERE ( login=?)";
          PreparedStatement stmt;
        try {
            stmt = cnx.getInstance().prepareStatement(req);
            stmt.setString(1, log);
            stmt.execute();
            return true;
         } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, "DaoVoiture: ----------");
    }
        return false;
    }

    
 
}

