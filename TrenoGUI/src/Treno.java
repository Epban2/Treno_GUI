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
        return lunghezzaComplessiva;
    }

    /**
     * Ritorna il peso complessivo del treno in tonnellate
     *
     * @return
     */
    public double returnPesoTreno() {
        double pesoComplessivo = 0;
        for (Vagone vagone : treno) {
            if (vagone instanceof VagoneMerci)
                pesoComplessivo += ((VagoneMerci) vagone).getCaricoAttuale(); //il peso vuoto è gia' incluso
            else {
                VagonePasseggeri vagone2 = ((VagonePasseggeri) vagone);
                pesoComplessivo += vagone2.getPesoaVuoto() + vagone2.getNumeroPasseggeri() * 0.07; //ogni persona pesa 70Kg
            }
        }
        return pesoComplessivo;
    }
}
