import model.Borsa;
import model.Giocatore;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println("Borsa 2023");

        Borsa b=new Borsa();
        System.out.println("Città: "+ b.getCitta());
        System.out.println("Ora apertura: "+ b.getOraApertura());
        System.out.println("Ora chiusura: "+ b.getOraChiusura());

        b.addSocieta("Apple", 100);
        b.addSocieta("Google", 200);
        b.addSocieta("Microsoft", 300);
        b.addSocieta("Amazon", 400);
        b.addSocieta("Facebook", 500);
        b.addSocieta("Tesla", 600);
        b.addSocieta("Netflix", 700);
        b.addSocieta("Twitter", 800);
        b.addSocieta("Intel", 900);
        b.addSocieta("IBM", 1000);
        b.stampaSocieta();

        Giocatore g=new Giocatore("Io");
        g.stampaGiocatore();

        g.acquista(b.getSocieta("Apple"), 100);
        g.acquista(b.getSocieta("Google"), 100);
        g.acquista(b.getSocieta("Microsoft"), 100);
        g.acquista(b.getSocieta("Google"), 50);

        g.stampaAcquisti();

        g.venditaAzione(g, b.getSocieta("Apple"), 50);
        g.venditaAzione(g, b.getSocieta("Google"), 80);
        g.venditaAzione(g, b.getSocieta("Microsoft"), 300);

        g.stampaVendite();

        g.stampaBilancio();
        b.getSocieta("Apple").setPrezzoAzione(200);
        g.stampaBilancio();

    }
}
