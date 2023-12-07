package model;

/**
 * The type Acquisto azione.
 */
public class AcquistoAzione {
    private Giocatore acquirente;
    private Societa societa;

    private float prezzo;
    private int quantita;

    /**
     * Instantiates a new Acquisto azione.
     *
     * @param acquirente the acquirente
     * @param societa    the societa
     * @param quantita   the quantita
     */
    public AcquistoAzione(Giocatore acquirente, Societa societa, int quantita){
        prezzo = societa.getPrezzoAzione();
        float costo = prezzo*quantita;
        acquirente.setLiquidita(acquirente.getLiquidita()-costo);
        this.acquirente=acquirente;
        this.societa=societa;
        this.quantita=quantita;
    }

    /**
     * Gets societa.
     *
     * @return the societa
     */
    public Societa getSocieta() {
        return societa;
    }

    /**
     * Gets acquirente.
     *
     * @return the acquirente
     */
    public Giocatore getAcquirente() {
        return acquirente;
    }

    /**
     * Gets prezzo.
     *
     * @return the prezzo
     */
    public float getPrezzo() {
        return prezzo;
    }

    /**
     * Gets quantita.
     *
     * @return the quantita
     */
    public int getQuantita() {
        return quantita;
    }

}
