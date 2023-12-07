package dao;

import java.util.ArrayList;

/**
 * The interface Listino dao.
 */
public interface ListinoDAO {
    /**
     * Leggi listino db.
     *
     * @param citta         the citta
     * @param nomiSocieta   the nomi societa
     * @param prezziSocieta the prezzi societa
     */
    void leggiListinoDB(String citta, ArrayList<String> nomiSocieta, ArrayList<Float> prezziSocieta);
}
