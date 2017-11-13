/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.iBusiness;

import model.bean.Inscrip;
import model.bean.Authentif;
import java.util.ArrayList;

/**
 *
 * @author Hela Chikhaoui
 */
public interface IUserManager {
     public boolean verif (Authentif authentif);
     public Boolean add(Inscrip inscrip);

}
