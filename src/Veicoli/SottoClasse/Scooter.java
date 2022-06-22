package Veicoli.SottoClasse;

import Administrator.Administrator;
import Enumerator.*;
import Interaces.Rifornimento;
import Veicoli.Veicoli;

import java.util.List;

public class Scooter extends Veicoli implements Rifornimento {
    private String targa;

    private int ltCarburante;

    private static ListinoPrezziAlMin prezziScooter = ListinoPrezziAlMin.SCOOTER;
    private static float prezzoAlMinuto = prezziScooter.getValue();
    private static ConsumiVeicolo consumiScooter = ConsumiVeicolo.SCOOTER;
    private static int kmConUnLitro = consumiScooter.getValue();
    private static Serbatoi serbatoioScooter = Serbatoi.SCOOTER;
    private static int capienzaSerbatoio = serbatoioScooter.getValue();

    public Scooter(String ID, StatoVeicolo statoVeicolo, String posizioneGeografica, String targa, int ltCarburante) {
        super(ID, Patenti.PATENTE_A, Caschi.CASCO, statoVeicolo, posizioneGeografica);
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

    @Override
    public void pieno() {
        Administrator.consumiBenzina(capienzaSerbatoio - ltCarburante);
        ltCarburante = capienzaSerbatoio;
    }
}
