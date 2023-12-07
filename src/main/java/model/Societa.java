package model;

/**
 * The type Societa.
 */
public class Societa {
    private String nome;
    private float prezzoAzione;

    private Borsa borsa;

    /**
     * Instantiates a new Societa.
     *
     * @param nome         the nome
     * @param prezzoAzione the prezzo azione
     */
    public Societa(String nome, float prezzoAzione){
        this.nome=nome;
        this.prezzoAzione=prezzoAzione;
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
     * Get prezzo azione float.
     *
     * @return the float
     */
    public float getPrezzoAzione(){
        return prezzoAzione;
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
     * Set prezzo azione.
     *
     * @param prezzoAzione the prezzo azione
     */
    public void setPrezzoAzione(float prezzoAzione){
        this.prezzoAzione=prezzoAzione;
    }

    /**
     * Set borsa.
     *
     * @param borsa the borsa
     */
    public void setBorsa(Borsa borsa){
        this.borsa=borsa;
    }

    /**
     * Get borsa borsa.
     *
     * @return the borsa
     */
    public Borsa getBorsa(){
        return borsa;
    }

}
