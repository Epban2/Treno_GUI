
/**
Commento
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
            JLabel label = new JLabel();
            label.setIcon(new ImageIcon("TrenoGUI/img/vagone_merci.jpg"));

            jpnVagoni.add(label);

        }
    }

    /**
     * Event listener di vagone passeggeri button
     */
    class AscoltaVagonePasseggeri implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
