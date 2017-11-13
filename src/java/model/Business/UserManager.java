/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;

import model.bean.Inscrip;
import model.bean.Authentif;
import dao.classes.IDaoUser;
import model.iBusiness.IUserManager;

/**
 *
 * @author Hela Chikhaoui
 */
public class UserManager implements IUserManager {
    
    IDaoUser daoUser;
    @Override
     public boolean verif (Authentif authentif){
       return (daoUser.exist(authentif));
    }
     @Override
     public Boolean add(Inscrip inscrip){
        return (daoUser.save(inscrip) );
    }

    public IDaoUser getDaoUser() {
        return daoUser;
    }

    public void setDaoUser(IDaoUser daoUser) {
        this.daoUser = daoUser;
    }

}
