package Veicoli.SottoClasse;

import Administrator.Administrator;
import Enumerator.*;
import Interfaces.Rifornimento;
import Veicoli.Veicoli;

public class Furgoncini extends Veicoli implements Rifornimento {
    private final String targa;

    private int ltCarburante;

    public static float prezzoAlMinuto = ListinoPrezziAlMin.FURGONCINO.getValue();
    private static final int kmConUnLitro = ConsumiVeicolo.FURGONCINO.getValue();

    private static final int capienzaSerbatoio = Serbatoi.FURGONCINO.getValue();

    public Furgoncini(String ID, StatoVeicolo statoVeicolo, String posizioneGeografica, String targa, int ltCarburante) {
        super(ID, Patenti.PATENTE_C, Caschi.NESSUNO, statoVeicolo, posizioneGeografica);
        this.targa = targa;
        this.ltCarburante = ltCarburante;
    }

    public void setLtCarburante(int km) {
        float ltUsati = (float)km / kmConUnLitro;
        ltCarburante -= (ltUsati);
    }
    @Override
    public String toString() {
        return "\n Furgoncini: " +
                super.toString() +
                "targa='" + targa + '\'' +
                ", ltCarburante=" + ltCarburante + "\n";
    }

    @Override
    public void pieno() {
        Administrator.consumiBenzina(capienzaSerbatoio - ltCarburante);
        ltCarburante = capienzaSerbatoio;
    }

}
