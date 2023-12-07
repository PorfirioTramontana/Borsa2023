package controller;

import dao.ListinoDAO;
import implementazionePostgresDAO.ListinoImplementazionePostgresDAO;
import model.Borsa;
import model.Giocatore;
import model.Societa;

import java.util.ArrayList;

/**
 * The type Controller.
 */
public class Controller {

    /**
     * The Giocatore.
     */
    public Giocatore giocatore;
    /**
     * The Borsa.
     */
    public Borsa borsa;

    /**
     * Sets nome giocatore.
     *
     * @param nome the nome
     */
    public void setNomeGiocatore(String nome) {
        giocatore = new Giocatore(nome);
    }

    /**
     * Sets citta borsa.
     *
     * @param nome the nome
     */
    public void setCittaBorsa(String nome) {
        borsa = new Borsa(nome);
    }

    /**
     * Add societa boolean.
     *
     * @param text the text
     * @param v    the v
     * @return the boolean
     */
    public boolean addSocieta(String text, float v) {
        return borsa.addSocieta(text, v);
    }

    /**
     * Gets nomi societa.
     *
     * @return the nomi societa
     */
    public ArrayList<String> getNomiSocieta() {
        return borsa.getNomiSocieta();
    }

    /**
     * Gets valori azione.
     *
     * @return the valori azione
     */
    public ArrayList<Float> getValoriAzione() {
        return borsa.getValoriAzione();
    }

    /**
     * Gets liquidita.
     *
     * @return the liquidita
     */
    public String getLiquidita() {
        return String.valueOf(giocatore.getLiquidita());
    }

    /**
     * Gets bilancio.
     *
     * @return the bilancio
     */
    public String getBilancio() {
        return String.valueOf(giocatore.calcolaBilancio());
    }

    /**
     * Is null giocatore boolean.
     *
     * @return the boolean
     */
    public boolean isNullGiocatore() {
        return giocatore == null;
    }

    /**
     * Leggi listino dao.
     */
    public void leggiListinoDAO() {
        ListinoDAO l=new ListinoImplementazionePostgresDAO();
        ArrayList<String> nomiSocieta=new ArrayList<String>();
        ArrayList<Float> prezziSocieta=new ArrayList<Float>();
        l.leggiListinoDB(borsa.getCitta(),nomiSocieta,prezziSocieta);  //legge listino dal DB
        for(int i=0;i<nomiSocieta.size();i++) {
            Societa s=new Societa(nomiSocieta.get(i),prezziSocieta.get(i));
            borsa.addSocieta(s);
        } // costruisce gli oggetti Model a partire dai risultati del db

    }

    /**
     * Acquista azione boolean.
     *
     * @param nomeSocieta     the nome societa
     * @param numeroAzioniInt the numero azioni int
     * @return the boolean
     */
    public boolean acquistaAzione(String nomeSocieta, int numeroAzioniInt) {
        return giocatore.acquistaAzione(nomeSocieta, numeroAzioniInt, borsa);
    }
}
