package model;

import java.util.ArrayList;

/**
 * The type Giocatore.
 */
public class Giocatore {
    private String nome;
    private float liquidita;
    private ArrayList<AcquistoAzione> listaAcquisti=new ArrayList<AcquistoAzione>();
    private ArrayList<VenditaAzione> listaVendite=new ArrayList<VenditaAzione>();

    /**
     * Instantiates a new Giocatore.
     *
     * @param nome      the nome
     * @param liquidita the liquidita
     */
    public Giocatore(String nome, float liquidita){
        this.nome=nome;
        this.liquidita=liquidita;
    }

    /**
     * Instantiates a new Giocatore.
     *
     * @param nome the nome
     */
    public Giocatore(String nome){
        this.nome=nome;
        this.liquidita=10000;
    }

    /**
     * Get nome string.
     *
     * @return the string
     */
    public String getNome(){
        return nome;
    }

    /**
     * Get liquidita float.
     *
     * @return the float
     */
    public float getLiquidita(){
        return liquidita;
    }

    /**
     * Set nome.
     *
     * @param nome the nome
     */
    public void setNome(String nome){
        this.nome=nome;
    }

    /**
     * Set liquidita.
     *
     * @param liquidita the liquidita
     */
    public void setLiquidita(float liquidita){
        this.liquidita=liquidita;
    }

    /**
     * Acquista.
     *
     * @param societa  the societa
     * @param quantita the quantita
     */
    public void acquista(Societa societa, int quantita){
        float prezzo = societa.getPrezzoAzione();
        float costo = prezzo*quantita;
        if (this.getLiquidita() < costo){
            System.out.println("Non hai abbastanza soldi per comprare queste azioni");
            return;
        }
        AcquistoAzione a=new AcquistoAzione(this, societa, quantita);
        listaAcquisti.add(a);
    }

    /**
     * Calcola bilancio float.
     *
     * @return the float
     */
    public float calcolaBilancio(){
        float bilancio=liquidita;
        for(AcquistoAzione a: listaAcquisti){
            bilancio+=a.getSocieta().getPrezzoAzione()*a.getQuantita();
        }
    return bilancio;
    }

    /**
     * Stampa bilancio.
     */
    public void stampaBilancio(){
        System.out.println("Bilancio: "+ calcolaBilancio());
    }

    /**
     * Stampa giocatore.
     */
    public void stampaGiocatore(){
        System.out.println("Nome: "+ nome);
        System.out.println("Liquidità: "+ liquidita + " $ ");
    }

    /**
     * Stampa acquisti.
     */
    public void stampaAcquisti(){
        System.out.println("Acquisti: ");
        for(AcquistoAzione a: listaAcquisti){
            System.out.println("Acquirente: "+this.nome);
            System.out.println("Società: "+ a.getSocieta().getNome());
            System.out.println("Prezzo: "+ a.getPrezzo());
            System.out.println("Quantità: "+ a.getQuantita());
        }
    }

    /**
     * Add acquisto.
     *
     * @param a the a
     */
    public void addAcquisto(AcquistoAzione a){
        listaAcquisti.add(a);
    }

    /**
     * Remove acquisto.
     *
     * @param a the a
     */
    public void removeAcquisto(AcquistoAzione a){
        listaAcquisti.remove(a);
    }

    /**
     * Get lista acquisti array list.
     *
     * @return the array list
     */
    public ArrayList<AcquistoAzione> getListaAcquisti(){
        return listaAcquisti;
    }

    /**
     * Set lista acquisti.
     *
     * @param listaAcquisti the lista acquisti
     */
    public void setListaAcquisti(ArrayList<AcquistoAzione> listaAcquisti){
        this.listaAcquisti=listaAcquisti;
    }

    /**
     * Vendita azione.
     *
     * @param venditore the venditore
     * @param societa   the societa
     * @param quantita  the quantita
     */
    public void venditaAzione(Giocatore venditore, Societa societa, int quantita){
        int azioniPossedute=0;
        for(AcquistoAzione a: listaAcquisti){
            if(a.getSocieta().equals(societa)){
                azioniPossedute+=a.getQuantita();
            }
        }
        if (azioniPossedute<quantita){
            System.out.println("Non hai abbastanza azioni per vendere");
            return;
        }
        VenditaAzione v=new VenditaAzione(venditore, societa, quantita);
        listaVendite.add(v);
    }


    /**
     * Vendi tutto societa.
     *
     * @param venditore the venditore
     * @param societa   the societa
     */
    public void vendiTuttoSocieta(Giocatore venditore, Societa societa){
        int azioniPossedute=0;
        for(AcquistoAzione a: listaAcquisti){
            if(a.getSocieta().equals(societa)){
                azioniPossedute+=a.getQuantita();
            }
        }
        VenditaAzione v=new VenditaAzione(venditore, societa, azioniPossedute);
    }

    /**
     * Stampa vendite.
     */
    public void stampaVendite(){
        System.out.println("Vendite: ");
        for(VenditaAzione a: listaVendite){
            System.out.println("Venditore: "+this.nome);
            System.out.println("Società: "+ a.getSocieta().getNome());
            System.out.println("Prezzo: "+ a.getPrezzo());
            System.out.println("Quantità: "+ a.getQuantita());
        }
    }


    /**
     * Acquista azione boolean.
     *
     * @param nomeSocieta     the nome societa
     * @param numeroAzioniInt the numero azioni int
     * @param borsa           the borsa
     * @return the boolean
     */
    public boolean acquistaAzione(String nomeSocieta, int numeroAzioniInt, Borsa borsa) {
        Societa societa = borsa.getSocieta(nomeSocieta);
        if(societa==null){
            return false;
        }
        acquista(societa, numeroAzioniInt);
        return true;
    }
}
