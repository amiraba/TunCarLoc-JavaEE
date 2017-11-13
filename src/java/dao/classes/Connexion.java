
package dao.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



class Connexion {
    private Connection connect=null;
    private String DBurl;
    
   Connection getInstance(){ //singleton
      
       if (connect==null)
       {
           try {
            connect = DriverManager.getConnection(DBurl);
            } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
             }
       }
       
       return(connect);
   }

    private Connexion() { //pour le pattern singleton
    }
   
   

    public Connection getConnect() {
        return connect;
    }

    public void setConnect(Connection connect) {
        this.connect = connect;
    }

    public String getDBurl() {
        return DBurl;
    }

    public void setDBurl(String DBurl) {
        this.DBurl = DBurl;
    }
    
    
}
