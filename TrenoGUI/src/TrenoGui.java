/**
Commento
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrenoGui extends JFrame {
    public Treno treno;
    private JLabel jlbTitolo; //etichetta del titolo
    private JLabel jlbTesto; //etichetta di testo generica
    private JPanel jpnTitolo; //pannello del titolo
    private JPanel jpnVagoni; //pannello con le img dei vagoni

    private JPanel jpnBottoniLaterali; //pannello con i bottoni per aggiungere vagoni (laterale)

    private JButton jbVagoneMerci; //bottone per aggiungere vagone merci
    private JButton jbVagonePasseggeri; //vagone passeggeri


    public TrenoGui(Treno trenoParametro) {
        this.treno=trenoParametro;
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

        jlbTesto = new JLabel();
        jlbTesto.setText("Aggiungi vagone merci");
        jlbTesto.setForeground(Color.BLACK);
        jlbTesto.setFont(new Font("Futura", Font.BOLD, 20));
        jlbTesto.setHorizontalAlignment(JLabel.CENTER);

        jbVagoneMerci = new JButton();
        jbVagoneMerci.add(jlbTesto);
        jbVagoneMerci.addActionListener(new AscoltaVagoneMerci());

        jpnBottoniLaterali = new JPanel();
        jpnBottoniLaterali.add(jbVagoneMerci);

        this.add(jpnTitolo, BorderLayout.NORTH);
        this.add(jpnBottoniLaterali, BorderLayout.EAST);
        this.add(jpnVagoni, BorderLayout.CENTER);
        this.setVisible(true);
    }

    /**
     * Bottone Reset
     */
    class AscoltaVagoneMerci implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
