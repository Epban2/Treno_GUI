
/**
 * Commento
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrenoGui extends JFrame {
    public Treno treno;
    private JLabel jlbTitolo; // etichetta del titolo
    private JLabel jlbTesto; // etichetta di testo generica
    private JPanel jpnTitolo; // pannello del titolo
    public JPanel jpnVagoni; // pannello con le img dei vagoni

    // #
    private JPanel jpnBottoniLaterali; // pannello con i bottoni per aggiungere vagoni (laterale)

    private JButton jbVagoneMerci; // bottone per aggiungere vagone merci
    private JButton jbVagonePasseggeri; // vagone passeggeri

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

        // aggiungi vagone merci
        jlbTestoMerci = new JLabel();
        jlbTestoMerci.setText("Aggiungi vagone merci");
        jlbTestoMerci.setForeground(Color.BLACK);
        jlbTestoMerci.setFont(new Font("Futura", Font.BOLD, 17));
        jlbTestoMerci.setHorizontalAlignment(JLabel.CENTER);

        jbVagoneMerci = new JButton();
        jbVagoneMerci.add(jlbTestoMerci);
        jbVagoneMerci.addActionListener(new AscoltaVagoneMerci());

        // vagone passeggeri
        jbVagonePasseggeri = new JButton();
        jlbTestoPasseggeri = new JLabel();
        jlbTestoPasseggeri.setText("Aggiungi vagone passeggeri");
        jlbTestoPasseggeri.setForeground(Color.BLACK);
        jlbTestoPasseggeri.setFont(new Font("Futura", Font.BOLD, 17));
        jlbTestoPasseggeri.setHorizontalAlignment(JLabel.CENTER);

        jbVagonePasseggeri.add(jlbTestoPasseggeri);
        jbVagonePasseggeri.addActionListener(new AscoltaVagonePasseggeri());

        // aggiungi bottoni al pannello
        jpnBottoniLaterali = new JPanel();
        jpnBottoniLaterali.setLayout(new BoxLayout(jpnBottoniLaterali, BoxLayout.Y_AXIS));
        jpnBottoniLaterali.add(jbVagoneMerci);
        jpnBottoniLaterali.add(jbVagonePasseggeri);

        // frame
        this.add(jpnTitolo, BorderLayout.NORTH);
        this.add(jpnBottoniLaterali, BorderLayout.EAST);
        this.add(jpnVagoni, BorderLayout.CENTER);
        this.setVisible(true);
    }

    /**
     * Event listener di vagone merci button
     */
    class AscoltaVagoneMerci implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ImageIcon icon = new ImageIcon("TrenoGUI/img/vagone_merci.jpg");
            Image image = icon.getImage();

            int width = image.getWidth(null) / 3; // rimpicciolire l'immagine
            int height = image.getHeight(null) / 5  ; //
            Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); //adatta l'immagine senza perdere di qualita'
            ImageIcon scaledIcon = new ImageIcon(scaledImage); //icona con l'immagine dimensionata

            JLabel label = new JLabel(scaledIcon); //label con l'immagine
            jpnVagoni.add(label);

            jpnVagoni.revalidate(); //notifica al layout che il pannello è cambiato
            jpnVagoni.repaint();
        }
    }

    /**
     * Event listener di vagone passeggeri button
     */
    class AscoltaVagonePasseggeri implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ImageIcon icon = new ImageIcon("TrenoGUI/img/vagone_passeggeri.jpg");
            Image image = icon.getImage();

            int width = image.getWidth(null) / 5; // rimpicciolire l'immagine
            int height = image.getHeight(null) / 3; //
            Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); //adatta l'immagine senza perdere di qualita'
            ImageIcon scaledIcon = new ImageIcon(scaledImage); //icona con l'immagine dimensionata

            JLabel label = new JLabel(scaledIcon); //label con l'immagine
            jpnVagoni.add(label);

            jpnVagoni.revalidate(); //notifica al layout che il pannello è cambiato
            jpnVagoni.repaint();
        }
    }
}
