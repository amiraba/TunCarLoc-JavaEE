/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.validators;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import dao.classes.IDaoVoiture;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import model.bean.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BindingResult;

/**
 *
 * @author Hela Chikhaoui
 */
public class DatesValidValidator {
        @Autowired
        IDaoVoiture daovoiture;
    public void validate( Reservation reservation, BindingResult result,HttpSession sess) {

         if (reservation.getDate().after(reservation.getDater()))
         {  if (LocaleContextHolder.getLocale().getDisplayLanguage()=="anglais")
             result.rejectValue("date", "invalidDate", "Date of return should be after reservation date");
         else
            result.rejectValue("date", "invalidDate", "la date de remise doit être antérieure à la date de réservation");
 }  
             
          Calendar currentDate = Calendar.getInstance();
         SimpleDateFormat formatt= new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss"); 
          String dateNow = formatt.format(currentDate.getTime());
          java.util.Date dateNowU;
          System.out.println(LocaleContextHolder.getLocale().getDisplayLanguage());
            try {
                dateNowU = formatt.parse(dateNow);
                if(reservation.getDate().before(dateNowU))
                {     if (LocaleContextHolder.getLocale().getDisplayLanguage()=="anglais")
                    result.rejectValue("date", "PastDate", "Oups , today's date is : "+dateNow);
                      else
                    result.rejectValue("date", "PastDate", "Oups ,  On est le : "+dateNow);

                }
            } catch (ParseException ex) {
                Logger.getLogger(DatesValidValidator.class.getName()).log(Level.SEVERE, null, ex);
            }
         

         if (sess.getAttribute("login")==null)
            {     if (LocaleContextHolder.getLocale().getDisplayLanguage() =="English")
              result.rejectValue("matricule","oup","You need to log in to reserve");
                 else
              result.rejectValue("matricule","oup","Vous devez vous connecter pour réserver");
                
          
    }
    }
}

   
    

    
    