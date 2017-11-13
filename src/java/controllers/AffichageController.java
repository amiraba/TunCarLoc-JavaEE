package controllers;

import model.bean.KeyValue;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import model.iBusiness.IAffichageManager;
import model.iBusiness.IVoitureManager;
import model.bean.Rech;
import model.bean.Reservation;
import model.bean.VoitureAdd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AffichageController {
    @Autowired
    private IAffichageManager affichageManager;
    @Autowired
    private IVoitureManager voitureManager;

    
    
    @RequestMapping(value = "/pieChart", method = RequestMethod.GET)
    public String pieCharting(ModelMap modelMap) {
        List<KeyValue> pieDataList = affichageManager.getPieChartData();
        modelMap.addAttribute("pieDataList", pieDataList);
        return "pieChart";
    }
    
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcoming() {
        return ("index");
    }

    @RequestMapping(value = "/reservationsAdmin", method = RequestMethod.GET)
    public String reservationsAdmin(ModelMap model) {
        ArrayList reservListe = affichageManager.read();
        model.addAttribute("reservListe", reservListe);

        return ("reservationsAdmin");
    }

    @RequestMapping(value = "/rechDone", method = RequestMethod.GET)
    public String rechercheGet(ModelMap model, HttpServletRequest request) {
        String session = (String) request.getSession().getAttribute("mot_cle");
        Rech rech = new Rech();
        rech.setMotCle(session);
        ArrayList list = affichageManager.verify(rech);
        model.addAttribute("list", list);
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
        String dateNow = formatter.format(currentDate.getTime());
        System.out.println("Now the date is :=>  " + dateNow);

        return ("rechSuccess");
    }

    @RequestMapping(value = "/AlarmRed", method = RequestMethod.GET)
    public String RedReservations(ModelMap model) {
        ArrayList reservListe = affichageManager.readR();
        model.addAttribute("reservListe", reservListe);
        return ("reservationsAdmin");
    }

    @RequestMapping(value = "/MyReservations", method = RequestMethod.GET)
    public String MyReservations(ModelMap model, HttpServletRequest request) {
        HttpSession ClientSession = request.getSession(false);
        String login = (String) ClientSession.getAttribute("login");
        model.addAttribute("login", login);
        ArrayList liste = affichageManager.displayRes(login);
        model.addAttribute("liste", liste);

        return ("MyReservations");
    }

    @RequestMapping(value = "/affichage", method = RequestMethod.GET)
    public String affichage(ModelMap model) {
        ArrayList liste = affichageManager.display();
        model.addAttribute("liste", liste);
        model.addAttribute("reservation", new model.bean.Reservation());
        return ("affichage");
    }

    @RequestMapping(value = "/redirection.htm", method = RequestMethod.GET)
    public String redirectSpace(ModelMap model, HttpServletRequest request) {
        HttpSession ClientSession = request.getSession(false);
        String login = (String) ClientSession.getAttribute("login");
        if (login.equals("admina")) {
            ArrayList Liste = affichageManager.readR();
            model.addAttribute("Liste", Liste);
            return ("menuAdmin");
        } else {
            return ("menuClient");
        }

    }

    @RequestMapping(value = "/VoitureAddDone.htm", method = RequestMethod.GET)
    public String acceuil(HttpServletRequest request, ModelMap model) {
        if (model.containsKey("Added")) {
            ArrayList liste = affichageManager.display();
            model.addAttribute("liste", liste);
            model.addAttribute("reservation", new model.bean.Reservation());
            return ("affichage");
        } else {
            model.addAttribute("voitureAdd", new model.bean.VoitureAdd());
            return ("voitureAdd");
        }
    }

    @RequestMapping(value = "/rech", method = RequestMethod.GET)
    public String rech(ModelMap model) {
        model.addAttribute("rech", new Rech());
        return "rech";
    }

    @RequestMapping(value = "/rechDone", method = RequestMethod.POST)
    public String rechDone(@Valid Rech rech, BindingResult result, ModelMap model, HttpServletRequest request) {

        if (result.hasErrors()) {
            return ("rech");
        }
        HttpSession session = request.getSession();
        session.setAttribute("mot_cle", rech.getMotCle());
        ArrayList list = affichageManager.verify(rech);
        model.addAttribute("list", list);

        if (list.isEmpty()) {
            model.addAttribute("Vide", "Aucun résultat");
        }

        return ("rechSuccess");
    }

    @RequestMapping(value = "/reserve/{matricule}/pdf", method = RequestMethod.GET)
    public String delReserv(@PathVariable("matricule") String mat, ModelMap model, HttpServletResponse response) {
        Document document = new Document();

        VoitureAdd v = affichageManager.find(mat);
        Reservation r = affichageManager.findR(mat);

        try {
            response.setContentType("application/pdf");
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            document.add(new Paragraph("Reçu de réservation de la voiture", new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD, BaseColor.DARK_GRAY)));
            document.add(new Chunk(" "));
            document.add(new Chunk(" "));
            document.add(new Chunk(" "));

            PdfPTable pdfTable = new PdfPTable(2);
            PdfPCell Fields = new PdfPCell(new Phrase(" Champs"));
            Fields.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfTable.addCell(Fields);
            Fields = new PdfPCell(new Phrase(" Description"));
            Fields.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfTable.addCell(Fields);
            pdfTable.addCell("Login du client");
            pdfTable.addCell(r.getLogin());
            pdfTable.addCell("Date début de location");
            pdfTable.addCell("" + r.getDate());
            pdfTable.addCell("Date de remise de la voiture");
            pdfTable.addCell("" + r.getDater());
            pdfTable.addCell("Matricule de la voiture");
            pdfTable.addCell(r.getMatricule());
            pdfTable.addCell("Marque de la voiture");
            pdfTable.addCell(v.getMarque());
            pdfTable.addCell("Couleur de la voiture");
            pdfTable.addCell(v.getCouleur());

            document.add(pdfTable);

        } catch (Exception e) {
            e.printStackTrace();
        }

        document.close();
        return null;

    }
    @RequestMapping(value = "/clientsList", method = RequestMethod.GET)
    public String ClientsList(ModelMap model, HttpServletRequest request) {
        ArrayList liste = affichageManager.display_Clients();
        model.addAttribute("liste", liste);

        return ("clientsList");
    }


    public IAffichageManager getAffichageManager() {
        return affichageManager;
    }

    public void setAffichageManager(IAffichageManager affichageManager) {
        this.affichageManager = affichageManager;
    }

    public IVoitureManager getVoitureManager() {
        return voitureManager;
    }

    public void setVoitureManager(IVoitureManager voitureManager) {
        this.voitureManager = voitureManager;
    }

}
