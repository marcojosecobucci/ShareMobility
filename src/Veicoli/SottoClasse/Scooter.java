package Veicoli.SottoClasse;

import Enumerator.*;
import Veicoli.Veicoli;

import java.util.List;

public class Scooter extends Veicoli {
    private String targa;

    private int ltCarburante;

    private static ListinoPrezziAlMin prezziScooter = ListinoPrezziAlMin.SCOOTER;
    private static float prezzoAlMinuto = prezziScooter.getValue();
    private static ConsumiVeicolo consumiScooter = ConsumiVeicolo.SCOOTER;
    private static int kmConUnLitro = consumiScooter.getValue();
    private static Serbatoi serbatoioScooter = Serbatoi.SCOOTER;
    private static int capienzaSerbatoio = serbatoioScooter.getValue();

    public Scooter(String ID, List<Patenti> patente, List<Caschi> casco, StatoVeicolo statoVeicolo, String posizioneGeografica, String targa, int ltCarburante) {
        super(ID, patente, casco, statoVeicolo, posizioneGeografica);
        this.targa = targa;
        this.ltCarburante = ltCarburante;
    }

    public int getLtCarburante() {
        return ltCarburante;
    }

    @Override
    public String toString() {
        return "\n Scooter" + super.toString() +
                "targa='" + targa + '\'' +
                ", ltCarburante=" + ltCarburante +
                "\n";
    }
}
