package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * The type Home.
 */
public class Home {
    private JPanel panel;
    private JButton buttonListaSocieta;
    private JButton buttonInserisciNome;
    private JButton buttonCittaBorsa;
    private JPanel panelPulsantiIniziali;
    private JPanel panelAltreFinestre;
    private JPanel panelAzioni;
    private JButton buttonAggiungiSocieta;
    private JPanel panelStato;
    private JLabel txtDisponibilita;
    private JLabel txtBilancio;
    private JButton buttonAcquistaAzione;
    private JButton buttonModificaValoreAzione;

    /**
     * The constant frame.
     */
    public static JFrame frame;
    /**
     * The Controller.
     */
    public Controller controller = new Controller();

    /**
     * Instantiates a new Home.
     * Costruttore della classe Home
     */
    public Home() {
        buttonAggiungiSocieta.setEnabled(false);
        buttonListaSocieta.setEnabled(false);
        buttonListaSocieta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.leggiListinoDAO();
                ListaSocieta listaSocieta = new ListaSocieta(frame, controller);
                listaSocieta.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
        buttonInserisciNome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Inserisci il tuo nome");
                controller.setNomeGiocatore(nome);
                JOptionPane.showMessageDialog(null, "Ciao " + nome);
                buttonInserisciNome.setEnabled(false);
                if (controller.giocatore != null && controller.borsa != null) {
                    controller.leggiListinoDAO();
                    txtDisponibilita.setText("Disponibilità: " + controller.getLiquidita());
                    txtBilancio.setText("Bilancio: " + controller.getBilancio());
                }
            }
        });
        buttonCittaBorsa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Inserisci la città della borsa");
                controller.setCittaBorsa(nome);
                JOptionPane.showMessageDialog(null, "La borsa si trova a " + nome);
                buttonCittaBorsa.setEnabled(false);
                buttonAggiungiSocieta.setEnabled(true);
                buttonListaSocieta.setEnabled(true);
                if (controller.giocatore != null && controller.borsa != null) {
                    controller.leggiListinoDAO();
                    txtDisponibilita.setText("Disponibilità: " + controller.getLiquidita());
                    txtBilancio.setText("Bilancio: " + controller.getBilancio());
                }
            }
        });
        buttonAggiungiSocieta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finestraAggiungiSocieta aggiungiSocieta = new finestraAggiungiSocieta(frame, controller);
                aggiungiSocieta.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
        frame.addComponentListener(new ComponentAdapter() {
            public void componentHidden(ComponentEvent e) {
                /* code run when component hidden*/
            }

            public void componentShown(ComponentEvent e) {
                aggiorna();
            }
        });
        buttonAcquistaAzione.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FinestraAcquistaAzione acquistaAzione = new FinestraAcquistaAzione(frame, controller);
                acquistaAzione.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        frame = new JFrame("Home");
        frame.setContentPane(new Home().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void aggiorna() {
        if (!controller.isNullGiocatore()) {
            txtDisponibilita.setText("Disponibilita': " + controller.getLiquidita());
            txtBilancio.setText("Bilancio: " + controller.getBilancio());
        }
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelPulsantiIniziali = new JPanel();
        panelPulsantiIniziali.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel.add(panelPulsantiIniziali);
        buttonInserisciNome = new JButton();
        buttonInserisciNome.setText("Inserisci Nome");
        panelPulsantiIniziali.add(buttonInserisciNome);
        buttonCittaBorsa = new JButton();
        buttonCittaBorsa.setText("Inserisci Citta Borsa");
        panelPulsantiIniziali.add(buttonCittaBorsa);
        panelAltreFinestre = new JPanel();
        panelAltreFinestre.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel.add(panelAltreFinestre);
        buttonListaSocieta = new JButton();
        buttonListaSocieta.setText("Lista Societa");
        panelAltreFinestre.add(buttonListaSocieta);
        panelAzioni = new JPanel();
        panelAzioni.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel.add(panelAzioni);
        buttonAggiungiSocieta = new JButton();
        buttonAggiungiSocieta.setText("Aggiungi Societa");
        panelAzioni.add(buttonAggiungiSocieta);
        buttonAcquistaAzione = new JButton();
        buttonAcquistaAzione.setText("Acquista Azione");
        panelAzioni.add(buttonAcquistaAzione);
        buttonModificaValoreAzione = new JButton();
        buttonModificaValoreAzione.setText("Modifica Valore Azione");
        panelAzioni.add(buttonModificaValoreAzione);
        panelStato = new JPanel();
        panelStato.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel.add(panelStato);
        txtDisponibilita = new JLabel();
        txtDisponibilita.setText("");
        panelStato.add(txtDisponibilita);
        txtBilancio = new JLabel();
        txtBilancio.setText("");
        panelStato.add(txtBilancio);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }
}
