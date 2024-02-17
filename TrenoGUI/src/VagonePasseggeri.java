/**
 * Per i vagoni passeggeri interessa sapere:
 *  numero massimo passeggeri (int)
 *  numero passeggeri (int)
 */
public class VagonePasseggeri extends Vagone {
    private int numeroMaxPasseggeri;
    private int numeroPasseggeri;

    public VagonePasseggeri(String matricola, int lunghezzaCm, double pesoaVuoto, int numeroMaxPasseggeri, int numeroPasseggeri) {
        super(matricola, lunghezzaCm, pesoaVuoto);
        this.numeroMaxPasseggeri = numeroMaxPasseggeri;
        this.numeroPasseggeri = numeroPasseggeri;
    }

    /**
     * Costruttore arbitrario
     */
    public VagonePasseggeri() {
        super();
        this.matricola = "ABC1";
        this.lunghezzaCm = 2600;
        this.pesoaVuoto = 80;
        this.numeroMaxPasseggeri = 60;
        this.numeroPasseggeri = 45;
    }

    public int getNumeroMaxPasseggeri() {
        return numeroMaxPasseggeri;
    }

    public void setNumeroMaxPasseggeri(int numeroMaxPasseggeri) {
        if (numeroMaxPasseggeri <= 60 && numeroMaxPasseggeri > numeroPasseggeri)
            this.numeroMaxPasseggeri = numeroMaxPasseggeri;
    }

    public int getNumeroPasseggeri() {
        return numeroPasseggeri;
    }

    public void setNumeroPasseggeri(int numeroPasseggeri) {
        if (numeroPasseggeri >= 0 && numeroPasseggeri <= numeroMaxPasseggeri)
            this.numeroPasseggeri = numeroPasseggeri;
    }

    @Override
    public String toString() {
        return "VagonePasseggeri: " + super.toString() +
                "numeroMaxPasseggeri=" + numeroMaxPasseggeri +
                ", numeroPasseggeri=" + numeroPasseggeri;
    }
}
