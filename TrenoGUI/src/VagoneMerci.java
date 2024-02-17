/**
 * Per i vagoni merci interessa sapere:
 *  carico massimo in quintali (double)
 *  carico attuale in quintali (double)
 */
public class VagoneMerci extends Vagone {
    private double caricoMassimo;
    private double caricoAttuale;

    public VagoneMerci(String matricola, int lunghezzaCm, double pesoaVuoto, double caricoMassimo, double caricoAttuale) {
        super(matricola, lunghezzaCm, pesoaVuoto);
        this.caricoMassimo = caricoMassimo;
        this.caricoAttuale = caricoAttuale;
    }

    /**
     * Costruttore arbitrario
     */
    public VagoneMerci() {
        super();
        this.matricola = "DFE2";
        this.lunghezzaCm = 1900;
        this.pesoaVuoto = 100;
        this.caricoMassimo = 250;
        this.caricoAttuale = 220;
    }

    public double getCaricoMassimo() {
        return caricoMassimo;
    }

    public void setCaricoMassimo(double caricoMassimo) {
        if (caricoMassimo >= pesoaVuoto && caricoMassimo <= 1000)
            this.caricoMassimo = caricoMassimo;
    }

    public double getCaricoAttuale() {
        return caricoAttuale;
    }

    public void setCaricoAttuale(double caricoAttuale) {
        if (caricoAttuale <= caricoMassimo && caricoAttuale >= pesoaVuoto)
            this.caricoAttuale = caricoAttuale + pesoaVuoto;
    }

    @Override
    public String toString() {
        return "VagoneMerci: " + super.toString() +
                "caricoMassimo=" + caricoMassimo +
                ", caricoAttuale=" + caricoAttuale;
    }
}
