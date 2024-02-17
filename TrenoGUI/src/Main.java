public class Main {
    public static void main(String[] args) {
        Treno treno = new Treno();

        VagonePasseggeri vagonePasseggeri = new VagonePasseggeri();
        VagoneMerci vagoneMerci1 = new VagoneMerci();
        VagoneMerci vagoneMerci2 = new VagoneMerci();

        treno.addVagone(vagonePasseggeri);
        treno.addVagone(vagoneMerci1);
        treno.addVagone(vagoneMerci2);
        System.out.println(treno.returnVagoni());
        System.out.println("La lunghezza del treno e': " + treno.returnLunghezzaTreno() / 100 + "m");
        System.out.println("Il peso del treno e': " + treno.returnPesoTreno() + " tonnellate");

        TrenoGui interfaccia = new TrenoGui(treno);

    }
}