package Veicoli.SottoClasse;

import Enumerator.*;
import Veicoli.Veicoli;

import java.util.List;

public class Automobile extends Veicoli {

    private String targa;

    private int ltCarburante;

    private static ListinoPrezziAlMin prezziAutomobile = ListinoPrezziAlMin.AUTOMOBILE;
    private static float prezzoAlMinuto = prezziAutomobile.getValue();

    private static ConsumiVeicolo consumiAutomobile = ConsumiVeicolo.AUTOMOBILE;
    private static int kmConUnLitro = consumiAutomobile.getValue();

    private static Serbatoi serbatoioAutomobile = Serbatoi.AUTOMOBILE;
    private static int capienzaSerbatoio = serbatoioAutomobile.getValue();

    public Automobile(String ID, Patenti patente, Caschi casco, StatoVeicolo statoVeicolo, String posizioneGeografica, String targa, int ltCarburante) {
        super(ID, patente, casco, statoVeicolo, posizioneGeografica);
        this.targa = targa;
        this.ltCarburante = ltCarburante;
    }

    public int getLtCarburante() {
        return ltCarburante;
    }

    @Override
    public String toString() {
        return "\n Automobile: " +
                super.toString() +
                " targa='" + targa + '\'' +
                ", ltCarburante=" + ltCarburante + "\n"
                ;
    }
}
