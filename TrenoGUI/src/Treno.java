import java.util.ArrayList;

public class Treno {
    private ArrayList<Vagone> treno;

    public Treno() {
        this.treno = new ArrayList<>();
    }

    /**
     * Aggiunge un vagone al treno
     *
     * @param vagone
     */
    public void addVagone(Vagone vagone) {
        treno.add(vagone);
    }

    /**
     * Ritorna una stringa con la lista dei vagoni presenti
     *
     * @return
     */
    public String returnVagoni() {
        String str = "Lista vagoni: \n";
        for (Vagone vagone : treno) {
            str += vagone.getClass().getName() + ", ";
        }
        return str;
    }

    /**
     * Ritorna la lunghezza complessiva del treno
     *
     * @return
     */
    public double returnLunghezzaTreno() {
        double lunghezzaComplessiva = 0;
        for (Vagone vagone : treno) {
            lunghezzaComplessiva += vagone.getLunghezzaCm();
        }
        return lunghezzaComplessiva / 100;
    }

    /**
     * Ritorna il peso complessivo del treno in tonnellate
     *
     * @return
     */
    public double returnPesoTreno() {
        double pesoComplessivo = 0;
        for (Vagone vagone : treno) {
            pesoComplessivo += vagone.pesoVagone();
        }
        return pesoComplessivo;
    }
}
