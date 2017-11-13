/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.classes;

import java.util.ArrayList;
import model.bean.Authentif;
import model.bean.Inscrip;

/**
 *
 * @author Hela Chikhaoui
 */
public interface IDaoUser {
     public Boolean loginExists (String s);
     public Boolean save(Inscrip inscrip);
     public boolean exist(Authentif authentif);

}
