/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import model.bean.Authentif;
import model.iBusiness.IAffichageManager;
import model.iBusiness.IUserManager;
import model.bean.Inscrip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Hela Chikhaoui
 */
@Controller
public class UserController {

    @Autowired
    IUserManager userManager;
    @Autowired
    IAffichageManager affichageManager;

    @RequestMapping(value = "/logOut", method = RequestMethod.GET)
    public String logOut(HttpServletRequest request, ModelMap model) {
        HttpSession ClientSession = request.getSession(false);
        ClientSession.invalidate();
        ArrayList liste = affichageManager.display();
        model.addAttribute("liste", liste);
        model.addAttribute("reservation", new model.bean.Reservation());

        return "affichage";
    }

    @RequestMapping(value = "/authentif", method = RequestMethod.GET)
    public String authentif(ModelMap model) {
        model.clear();
        model.addAttribute("authentif", new Authentif());
        return "authentif";
    }

    @RequestMapping(value = "/authentifDone", method = RequestMethod.GET)
    public String menu(HttpServletRequest request, ModelMap model) {
        HttpSession ClientSession = request.getSession(false);
        if (!ClientSession.getAttribute("login").equals("")) {
            if (ClientSession.getAttribute("login").equals("admina")) {
                ArrayList Liste = affichageManager.readR();
                model.addAttribute("Liste", Liste);
                return ("menuAdmin");
            } else {
                return ("menuClient");
            }
        } else {
            model.addAttribute("authentif", new Authentif());
            return "authentif";
        }
    }

    @RequestMapping(value = "/inscripDone", method = RequestMethod.GET)
    public String InscripRedirect(HttpServletRequest request, ModelMap model) {

        model.addAttribute("inscrip", new Inscrip());
        return "inscrip";
    }

    @RequestMapping(value = "/authentifDone", method = RequestMethod.POST)
    public String authentifDone(@Valid Authentif authentif, BindingResult result, HttpServletRequest request, ModelMap model) {
        boolean b = false;
        if (result.hasErrors()) {
            return ("authentif");
        }
        b = userManager.verif(authentif);
        HttpSession ClientSession = request.getSession();
        ClientSession.setAttribute("login", authentif.getLogin());
        if (authentif.getLogin().equals("admina") && b == true) {
            ArrayList Liste = affichageManager.readR();
            model.addAttribute("Liste", Liste);
            return ("menuAdmin");
        } else if (b == true) {
            return ("menuClient");
        } else {
            ClientSession.invalidate();
            model.addAttribute("AuthError", "Login ou Mot de passe incorrects");
            return ("authentif");
        }
    }

    @RequestMapping(value = "/inscrip", method = RequestMethod.GET)
    public String inscrip(ModelMap model) {
        model.addAttribute("inscrip", new Inscrip());
        return "inscrip";
    }

    @RequestMapping(value = "/inscripDone", method = RequestMethod.POST)
    public String inscripDone(@Valid Inscrip inscrip, BindingResult result, HttpServletRequest request, ModelMap model) {
        java.util.logging.Logger.getLogger(UserController.class.getName()).log(Level.INFO, "in InscripCtrl/inscripDone: " + inscrip.getPassword());
        java.util.logging.Logger.getLogger(UserController.class.getName()).log(Level.INFO, "in InscripCtrl/inscripDone: " + inscrip.getPassword2());
        if (result.hasErrors()) {
            return ("inscrip");
        }
        Boolean b = userManager.add(inscrip);
        if (!b) {
            return ("inscrip");

        }
        HttpSession ClientSession = request.getSession();
        ClientSession.setAttribute("login", inscrip.getLogin());
        return ("menuClient");
    }

    public IUserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(IUserManager userManager) {
        this.userManager = userManager;
    }

    public IAffichageManager getAffichageManager() {
        return affichageManager;
    }

    public void setAffichageManager(IAffichageManager affichageManager) {
        this.affichageManager = affichageManager;
    }

}
