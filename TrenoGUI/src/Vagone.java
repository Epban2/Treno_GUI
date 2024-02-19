public abstract class Vagone {
    protected String matricola;
    protected int lunghezzaCm;
    protected double pesoaVuoto;

    public Vagone(String matricola, int lunghezzaCm, double pesoaVuoto) {
        this.matricola = matricola;
        this.lunghezzaCm = lunghezzaCm;
        this.pesoaVuoto = pesoaVuoto;
    }

    public Vagone() {

    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public int getLunghezzaCm() {
        return lunghezzaCm;
    }

    public void setLunghezzaCm(int lunghezzaCm) {
        if (lunghezzaCm >= 2000 && lunghezzaCm <= 5000)
            this.lunghezzaCm = lunghezzaCm;
    }

    public double getPesoaVuoto() {
        return pesoaVuoto;
    }

    public void setPesoaVuoto(double pesoaVuoto) {
        if (pesoaVuoto > 30 && pesoaVuoto <= 120)
            this.pesoaVuoto = pesoaVuoto;
    }

    @Override
    public String toString() {
        return "matricola='" + matricola + '\'' +
                ", lunghezzaCm=" + lunghezzaCm +
                ", pesoaVuoto=" + pesoaVuoto + "\n";
    }

    /** metodo astratto */
    public abstract double pesoVagone();

}
