package Veicoli.SottoClasse;

import Enumerator.*;
import Veicoli.Veicoli;

import java.util.List;

public class Furgoncini extends Veicoli {
    private String targa;

    private int ltCarburante;

    private static ListinoPrezziAlMin prezziFurgoncino = ListinoPrezziAlMin.FURGONCINO;
    private static float prezzoAlMinuto = prezziFurgoncino.getValue();
    private static ConsumiVeicolo consumiFurgoncino = ConsumiVeicolo.FURGONCINO;
    private static int kmConUnLitro = consumiFurgoncino.getValue();

    private static Serbatoi serbatoioFurgoncino = Serbatoi.FURGONCINO;
    private static int capienzaSerbatoio = serbatoioFurgoncino.getValue();

    public Furgoncini(String ID, List<Patenti> patente, List<Caschi> casco, StatoVeicolo statoVeicolo, String posizioneGeografica, String targa, int ltCarburante) {
        super(ID, patente, casco, statoVeicolo, posizioneGeografica);
        this.targa = targa;
        this.ltCarburante = ltCarburante;
    }

    public int getLtCarburante() {
        return ltCarburante;
    }

    @Override
    public String toString() {
        return "\n Furgoncini: " +
                super.toString() +
                "targa='" + targa + '\'' +
                ", ltCarburante=" + ltCarburante + "\n";
    }


}
