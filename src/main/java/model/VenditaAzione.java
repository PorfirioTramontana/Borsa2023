package model;

/**
 * The type Vendita azione.
 */
public class VenditaAzione {
    private Giocatore venditore;
    private Societa societa;

    private float prezzo;
    private int quantita;

    /**
     * Instantiates a new Vendita azione.
     *
     * @param venditore the venditore
     * @param societa   the societa
     * @param quantita  the quantita
     */
    public VenditaAzione(Giocatore venditore, Societa societa, int quantita){
        prezzo = societa.getPrezzoAzione();
        float guadagno = prezzo*quantita;
        venditore.setLiquidita(venditore.getLiquidita()+guadagno);
        this.venditore=venditore;
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
     * Gets venditore.
     *
     * @return the venditore
     */
    public Giocatore getVenditore() {
        return venditore;
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
