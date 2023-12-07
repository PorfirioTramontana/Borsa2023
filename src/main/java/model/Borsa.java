package model;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * The type Borsa.
 * Classe che rappresenta la borsa di una città
 * La borsa è caratterizzata da una città, un orario di apertura e uno di chiusura
 * La borsa contiene una lista di società
 * La borsa può assegnare un premio
 * La borsa può aggiungere e rimuovere società
 * La borsa può stampare la lista delle società
 * La borsa può modificare il nome e il prezzo di un'azione di una società
 * La borsa può stampare il nome e il prezzo di un'azione di una società
 * La borsa può stampare il nome e il prezzo di un'azione di tutte le società
 */
public class Borsa {
    /**
     * Instantiates a new Borsa.
     * Costruttore vuoto
     * Imposta l'orario di apertura alle 9:30 e quello di chiusura alle 16:00
     */
    public Borsa(){
        oraApertura=LocalTime.of(9,30);
        oraChiusura=LocalTime.of(16,0);
    }
    private String citta="New York";
    private LocalTime oraApertura;
    private LocalTime oraChiusura;

    private ArrayList<Societa> societa=new ArrayList<Societa>();

    /**
     * Instantiates a new Borsa.
     * Costruttore con parametro
     * Imposta il nome della città
     *
     * @param nome
     */
    public Borsa(String nome) {
        this.citta=nome;
    }

    /**
     * Assegna premio.
     */
    public void assegnaPremio(){
    }

    /**
     * Get citta string.
     *
     * @return the string
     */
    public String getCitta(){
        return citta;
    }

    /**
     * Get ora apertura local time.
     *
     * @return the local time
     */
    public LocalTime getOraApertura(){
        return oraApertura;
    }

    /**
     * Get ora chiusura local time.
     *
     * @return the local time
     */
    public LocalTime getOraChiusura(){
        return oraChiusura;
    }

    /**
     * Set citta.
     *
     * @param citta the citta
     */
    public void setCitta(String citta){
        this.citta=citta;
    }

    /**
     * Set ora apertura.
     *
     * @param oraApertura the ora apertura
     */
    public void setOraApertura(LocalTime oraApertura){
        this.oraApertura=oraApertura;
    }

    /**
     * Set ora chiusura.
     *
     * @param oraChiusura the ora chiusura
     */
    public void setOraChiusura(LocalTime oraChiusura){
        this.oraChiusura=oraChiusura;
    }

    /**
     * Add societa.
     *
     * @param s the s
     */
    public void addSocieta(Societa s){
        societa.add(s);
    }

    /**
     * Remove societa.
     *
     * @param s the s
     */
    public void removeSocieta(Societa s){
        societa.remove(s);
    }

    /**
     * Get lista societa array list.
     *
     * @return the array list
     */
    public ArrayList<Societa> getListaSocieta(){
        return societa;
    }

    /**
     * Set lista societa.
     *
     * @param listaSocieta the lista societa
     */
    public void setListaSocieta(ArrayList<Societa> listaSocieta){
        this.societa=listaSocieta;
    }

    /**
     * Get societa societa.
     *
     * @param nome the nome
     * @return the societa
     */
    public Societa getSocieta(String nome){
        for(Societa s: societa){
            if(s.getNome().equals(nome)){
                return s;
            }
        }
        return null;
    }

    /**
     * Set societa.
     *
     * @param nome         the nome
     * @param prezzoAzione the prezzo azione
     */
    public void setSocieta(String nome, float prezzoAzione){
        for(Societa s: societa){
            if(s.getNome().equals(nome)){
                s.setPrezzoAzione(prezzoAzione);
            }
        }
    }

    /**
     * Modifica societa.
     *
     * @param nome         the nome
     * @param nomeNuovo    the nome nuovo
     * @param prezzoAzione the prezzo azione
     */
    public void modificaSocieta(String nome, String nomeNuovo, float prezzoAzione){
        for(Societa s: societa){
            if(s.getNome().equals(nome)){
                s.setNome(nomeNuovo);
                s.setPrezzoAzione(prezzoAzione);
            }
        }
    }

    /**
     * Modifica nome societa.
     *
     * @param nome      the nome
     * @param nomeNuovo the nome nuovo
     */
    public void modificaNomeSocieta(String nome, String nomeNuovo){
        for(Societa s: societa){
            if(s.getNome().equals(nome)){
                s.setNome(nomeNuovo);
            }
        }
    }

    /**
     * Modifica prezzo azione societa.
     *
     * @param nome         the nome
     * @param prezzoAzione the prezzo azione
     */
    public void modificaPrezzoAzioneSocieta(String nome, float prezzoAzione){
        for(Societa s: societa){
            if(s.getNome().equals(nome)){
                s.setPrezzoAzione(prezzoAzione);
            }
        }
    }

    /**
     * Stampa societa.
     */
    public void stampaSocieta(){
        for(Societa s: societa){
            System.out.println("Nome: "+s.getNome());
            System.out.println("Prezzo azione: "+s.getPrezzoAzione());
        }
    }


    /**
     * Add societa boolean.
     *
     * @param nome   the nome
     * @param prezzo the prezzo
     * @return the boolean
     */
    public boolean addSocieta(String nome, float prezzo) {
        for(Societa s: societa){
            if(s.getNome().equals(nome)){
                return false;
            }
        }
        societa.add(new Societa(nome, prezzo));
        return true;
    }

    /**
     * Gets nomi societa.
     *
     * @return the nomi societa
     */
    public ArrayList<String> getNomiSocieta() {
        ArrayList<String> nomiSocieta=new ArrayList<String>();
        for(Societa s: societa){
            nomiSocieta.add(s.getNome());
        }
        return nomiSocieta;
    }

    /**
     * Gets valori azione.
     *
     * @return the valori azione
     */
    public ArrayList<Float> getValoriAzione() {
        ArrayList<Float> valoriAzione=new ArrayList<Float>();
        for(Societa s: societa){
            valoriAzione.add(s.getPrezzoAzione());
        }
        return valoriAzione;
    }




}
