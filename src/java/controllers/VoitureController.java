package controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import model.iBusiness.IAffichageManager;
import model.iBusiness.IVoitureManager;
import model.bean.Reservation;
import model.bean.VoitureAdd;
import model.validators.DatesValidValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Hela Chikhaoui
 */
@Controller
public class VoitureController {

    @Autowired
    IVoitureManager voitureManager;
    @Autowired
    IAffichageManager affichageManager;

    @RequestMapping(value = "/voitureAdd.htm", method = RequestMethod.GET)
    public String voitureAdd(ModelMap model) {
        VoitureAdd v = new VoitureAdd();
        v.setDisponibilite("disponible");
        model.addAttribute("voitureAdd", v);
        return "voitureAdd";
    }

    @RequestMapping(value = "/reserve/{matricule}/locate", method = RequestMethod.GET)
    public String reserve(@PathVariable("matricule") String mat, ModelMap model) {

        ArrayList liste = affichageManager.display();
        model.addAttribute("liste", liste);
        Reservation r = new Reservation();
        r.setMatricule(mat);
        model.addAttribute("reservation", r);
        return "reservationMenu";

    }

    @RequestMapping(value = "/{matricule}/voitureUpdate", method = RequestMethod.GET)
    public String update(@PathVariable("matricule") String mat, ModelMap model) {

        ArrayList liste = affichageManager.display();
        model.addAttribute("liste", liste);
        VoitureAdd v = new VoitureAdd();
        v.setMatricule(mat);
        model.addAttribute("voitureAdd", v);
        return "updateMenu";

    }

    @RequestMapping(value = "/updateVoiture", method = RequestMethod.POST)
    public String updateVoiture(VoitureAdd voitureAdd, ModelMap model, BindingResult result, HttpServletRequest request) {

        if (result.hasErrors()) {
            return ("updateMenu");
        }
        voitureManager.update(voitureAdd);
        ArrayList liste = affichageManager.display();
        model.addAttribute("liste", liste);

        return ("affichage");

    }

    @RequestMapping(value = "/VoitureAddDone.htm", method = RequestMethod.POST)
    public String VoitureAddDone(@Valid @ModelAttribute("voitureAdd") VoitureAdd voitureAdd, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("Added", "true");
            return ("voitureAdd");
        }
        model.clear();
        voitureManager.add(voitureAdd);
        ArrayList liste = affichageManager.display();
        model.addAttribute("liste", liste);
        return ("affichage");
    }

    @RequestMapping(value = "/{matricule}/voitureDelete.htm", method = RequestMethod.GET)
    public String voitureDelete(@PathVariable("matricule") String mat, ModelMap model) {
        model.clear();
        boolean b = voitureManager.delete(mat);
        if (!b) {
            model.addAttribute("DelError", "La voiture que vous voulez supprimer est déjà réservée");
        }
        ArrayList liste = affichageManager.display();
        model.addAttribute("liste", liste);
        return "affichage";
    }

    @RequestMapping(value = "/reserve/{matricule}/deleteRes", method = RequestMethod.GET)
    public String delReserv(@PathVariable("matricule") String mat, ModelMap model,HttpServletRequest request) {

        voitureManager.deleteRes(mat);
        HttpSession ClientSession = request.getSession(false);
        String login = (String) ClientSession.getAttribute("login");
        ArrayList liste = affichageManager.displayRes(login);
        model.addAttribute("liste", liste);
        return ("MyReservations");

    }

    /**
     *
     * @param reservation
     * @param model
     * @param result
     * @param request
     * @param date
     * @param dater
     * @return
     */
    @RequestMapping(value = "/reserveVoiture", method = RequestMethod.POST)
    public String reserveVoiture(@Valid @ModelAttribute("reservation") Reservation reservation, ModelMap model, BindingResult result, HttpServletRequest request) {
        DatesValidValidator val = new DatesValidValidator();
        HttpSession ClientSession = request.getSession(false);
        val.validate(reservation, result, ClientSession);
        if (result.hasErrors()) {
            return ("reservationMenu");
        }
        String login = (String) ClientSession.getAttribute("login");
        reservation.setLogin(login);
        boolean b = voitureManager.reserve(reservation);
        if (!b) {
            if (LocaleContextHolder.getLocale().getDisplayLanguage() == "anglais") {
                model.addAttribute("resFail", "Car not available");
            } else {
                model.addAttribute("resFail", "Voiture non disponible");
            }
            return ("reservationMenu");
        }

        ArrayList liste = affichageManager.display();
        model.addAttribute("liste", liste);
        model.addAttribute("msg", "reservation.success");

        return ("menuClient");

    }

    @RequestMapping(value = "/reserveVoiture", method = RequestMethod.GET)
    public String reserveVoitureGet(@Valid Reservation reservation, ModelMap model, BindingResult result, HttpServletRequest request) {

        ArrayList liste = affichageManager.display();
        model.addAttribute("liste", liste);

        return ("affichage");

    }
    @RequestMapping(value = "/{login}/deleteUser", method = RequestMethod.GET)
    public String delUser(@PathVariable("login") String log, ModelMap model) {
        String msg;
        if (LocaleContextHolder.getLocale().getDisplayLanguage() == "anglais") {
            msg = "User banned";
        } else {
            msg = "utilisateur banni";
        }
        if (voitureManager.deleteUser(log)) {
            model.addAttribute("SuccessDelUser", msg);
        }
        ArrayList liste = affichageManager.display_Clients();
        model.addAttribute("liste", liste);
        return ("clientsList");

    }

    public IVoitureManager getVoitureManager() {
        return voitureManager;
    }

    public void setVoitureManager(IVoitureManager voitureManager) {
        this.voitureManager = voitureManager;
    }

}
