package Veicoli.SottoClasse;

import Administrator.Administrator;
import Enumerator.*;
import Interfaces.Rifornimento;
import Veicoli.Veicoli;

public class Scooter extends Veicoli implements Rifornimento {
    private String targa;

    private int ltCarburante;

    private static ListinoPrezziAlMin prezziScooter = ListinoPrezziAlMin.SCOOTER;
    public static float prezzoAlMinuto = prezziScooter.getValue();
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

    public void setLtCarburante(int km) {
        float ltUsati = (float) km / kmConUnLitro;
        ltCarburante -= (ltUsati);
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
