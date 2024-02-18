/**
 * RICCARDO LA ROCCA 4C INF
 * Esercizio Treno GUI con Java AWT/SWING
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrenoGui extends JFrame {
    public double lunghezzaTreno;
    public double pesoTreno;
    public Treno treno; //parametro che mi faccio passare dal main
    private JLabel jlbTitolo; // etichetta del titolo
    private JLabel jlbLunghezzaTreno; // etichetta di testo generica
    private JLabel jlbPesoTreno; // etichetta di testo generica
    private JPanel jpnTitolo; // pannello del titolo
    public JPanel jpnVagoni; // pannello con le img dei vagoni
    public JPanel jpDatiTreno; //pannello in basso che contiene lunghezza e peso del treno
    private JPanel jpnBottoniLaterali; // pannello con i bottoni per aggiungere vagoni (laterale)
    private JButton jbVagoneMerci; // bottone per aggiungere vagone merci
    private JButton jbVagonePasseggeri; // bottone vagone passeggeri
    private JLabel jlbTestoPasseggeri;
    private JLabel jlbTestoMerci;

    public TrenoGui(Treno trenoParametro) {
        this.treno = trenoParametro;
        this.setSize(1000, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        jlbTitolo = new JLabel();
        jlbTitolo.setText("Treno con interfaccia grafica");
        jlbTitolo.setForeground(Color.BLACK);
        jlbTitolo.setFont(new Font("Futura", Font.BOLD, 37));
        jlbTitolo.setHorizontalAlignment(JLabel.CENTER);

        jpnTitolo = new JPanel();
        jpnTitolo.add(jlbTitolo);

        jpnVagoni = new JPanel();
        jpnVagoni.setLayout(new FlowLayout());

        // aggiungi vagone merci (label e bottone)
        jlbTestoMerci = new JLabel();
        jlbTestoMerci.setText("Aggiungi vagone merci");
        jlbTestoMerci.setForeground(Color.BLACK);
        jlbTestoMerci.setFont(new Font("Futura", Font.BOLD, 17));
        jlbTestoMerci.setHorizontalAlignment(JLabel.CENTER);

        jbVagoneMerci = new JButton();
        jbVagoneMerci.add(jlbTestoMerci);
        jbVagoneMerci.setContentAreaFilled(false);
        jbVagoneMerci.setBorderPainted(false);
        jbVagoneMerci.addActionListener(new AscoltaVagoneMerci());

        // vagone passeggeri (label e bottone)
        jlbTestoPasseggeri = new JLabel();
        jlbTestoPasseggeri.setText("Aggiungi vagone passeggeri");
        jlbTestoPasseggeri.setForeground(Color.BLACK);
        jlbTestoPasseggeri.setFont(new Font("Futura", Font.BOLD, 17));
        jlbTestoPasseggeri.setHorizontalAlignment(JLabel.CENTER);

        jbVagonePasseggeri = new JButton();
        jbVagonePasseggeri.add(jlbTestoPasseggeri);
        jbVagonePasseggeri.setContentAreaFilled(false); //toglie il riquadro del bottone e il bordo
        jbVagonePasseggeri.setBorderPainted(false);
        jbVagonePasseggeri.addActionListener(new AscoltaVagonePasseggeri());

        // aggiungi bottoni al pannello
        jpnBottoniLaterali = new JPanel();
        jpnBottoniLaterali.setLayout(new GridLayout(0, 1));
        jpnBottoniLaterali.add(jbVagoneMerci);
        jpnBottoniLaterali.add(jbVagonePasseggeri);

        //etichetta con peso, lunghezza del treno
        jpDatiTreno = new JPanel();
        jlbLunghezzaTreno = new JLabel();
        jlbPesoTreno = new JLabel();
        lunghezzaTreno = 0;
        pesoTreno = 0;

        jlbLunghezzaTreno.setText("Lunghezza treno: 0 m");
        jlbLunghezzaTreno.setForeground(Color.BLACK);
        jlbLunghezzaTreno.setFont(new Font("Futura", Font.BOLD, 15));

        jlbPesoTreno.setText("Peso treno: 0 tonnellate");
        jlbPesoTreno.setForeground(Color.BLACK);
        jlbPesoTreno.setFont(new Font("Futura", Font.BOLD, 15));
        jpDatiTreno.add(jlbLunghezzaTreno);
        jpDatiTreno.add(jlbPesoTreno);

        // frame
        this.add(jpnTitolo, BorderLayout.NORTH);
        this.add(jpnBottoniLaterali, BorderLayout.EAST);
        this.add(jpnVagoni, BorderLayout.CENTER);
        this.add(jpDatiTreno, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    /**
     * Event listener di vagone merci button
     */
    class AscoltaVagoneMerci implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            VagoneMerci vagoneMerci = new VagoneMerci();
            treno.addVagone(vagoneMerci); //aggiungo un vagone al treno (peso etc.)

            ImageIcon icon = new ImageIcon("TrenoGUI/img/vagone_merci.jpg");
            Image immagine = icon.getImage();

            int larghezza = immagine.getWidth(null) / 3; // rimpicciolire l'immagine
            int altezza = immagine.getHeight(null) / 5; //
            Image rimensionata = immagine.getScaledInstance(larghezza, altezza, Image.SCALE_SMOOTH); //adatta l'immagine senza perdere di qualita'
            ImageIcon scaledIcon = new ImageIcon(rimensionata); //icona con l'immagine dimensionata

            JLabel label = new JLabel(scaledIcon); //label con l'immagine
            jpnVagoni.add(label);

            jpnVagoni.revalidate(); //notifica al layout che il pannello è cambiato
            jpnVagoni.repaint();
            pesoTreno = treno.returnPesoTreno(); //salvo il nuovo valore nella variabile e modifico l'etichetta
            lunghezzaTreno = treno.returnLunghezzaTreno();
            jlbLunghezzaTreno.setText("Lunghezza treno: " + lunghezzaTreno + " m");
            jlbPesoTreno.setText("Peso treno: " + pesoTreno + " tonnellate");
        }
    }

    /**
     * Event listener di vagone passeggeri button
     */
    class AscoltaVagonePasseggeri implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            VagonePasseggeri vagonePasseggeri = new VagonePasseggeri();
            treno.addVagone(vagonePasseggeri); //aggiungo un vagone al treno (peso etc.)

            ImageIcon icon = new ImageIcon("TrenoGUI/img/vagone_passeggeri.jpg");
            Image immagine = icon.getImage();

            int larghezza = immagine.getWidth(null) / 5; // rimpicciolire l'immagine
            int altezza = immagine.getHeight(null) / 3; //
            Image rimensionata = immagine.getScaledInstance(larghezza, altezza, Image.SCALE_SMOOTH); //adatta l'immagine senza perdere di qualita'
            ImageIcon scaledIcon = new ImageIcon(rimensionata); //icona con l'immagine dimensionata

            JLabel label = new JLabel(scaledIcon); //label con l'immagine
            jpnVagoni.add(label);

            jpnVagoni.revalidate(); //notifica al layout che il pannello è cambiato
            jpnVagoni.repaint();
            pesoTreno = treno.returnPesoTreno(); //salvo il nuovo valore nella variabile e modifico l'etichetta
            lunghezzaTreno = treno.returnLunghezzaTreno();
            jlbLunghezzaTreno.setText("Lunghezza treno: " + lunghezzaTreno + " m");
            jlbPesoTreno.setText("Peso treno: " + pesoTreno + " tonnellate");
        }
    }
}
