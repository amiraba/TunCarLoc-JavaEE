package model.Business;
import model.bean.Reservation;
import model.bean.VoitureAdd;
import dao.classes.IDaoVoiture;
import model.iBusiness.IVoitureManager;

/**
 *
 * @author Hela Chikhaoui
 */
public class VoitureManager implements IVoitureManager {
    
    IDaoVoiture daovoiture;
    
    @Override
   public void add(VoitureAdd voitureAdd){
        daovoiture.save(voitureAdd);
    }
   @Override
   public boolean reserve(Reservation reservation){
       return(daovoiture.saveR(reservation));
    }
    @Override
    public boolean delete(String matricule){
        return daovoiture.delete(matricule);
    }
    
    @Override
    public void deleteRes(String matr){
        daovoiture.deleteRes(matr);
    }

    @Override
    public void update(VoitureAdd voitureAdd){
        daovoiture.update(voitureAdd);
    }

    public IDaoVoiture getDaovoiture() {
        return daovoiture;
    }

    public void setDaovoiture(IDaoVoiture daovoiture) {
        this.daovoiture = daovoiture;
    }
 @Override
    public boolean deleteUser(String log){
         return daovoiture.deleteUser(log);
    }  

}