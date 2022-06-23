package Veicoli.SottoClasse;

import Administrator.Administrator;
import Enumerator.*;
import Interfaces.Rifornimento;
import Veicoli.Veicoli;

public class Automobile extends Veicoli implements Rifornimento {

    private final String targa;

    private float ltCarburante;

    public static float prezzoAlMinuto = ListinoPrezziAlMin.AUTOMOBILE.getValue();

    private static final int kmConUnLitro = ConsumiVeicolo.AUTOMOBILE.getValue();

    private static final int capienzaSerbatoio = Serbatoi.AUTOMOBILE.getValue();

    public Automobile(String ID, StatoVeicolo statoVeicolo, String posizioneGeografica, String targa, int ltCarburante) {
        super(ID, Patenti.PATENTE_B, Caschi.NESSUNO, statoVeicolo, posizioneGeografica);
        this.targa = targa;
        this.ltCarburante = ltCarburante;
    }

    public void setLtCarburante(int km) {
        float ltUsati = (float)km / kmConUnLitro;
        ltCarburante -= (ltUsati);
    }

    @Override
    public String toString() {
        return "\n Automobile: " +
                super.toString() +
                " targa='" + targa + '\'' +
                ", ltCarburante=" + ltCarburante + "\n"
                ;
    }

    @Override
    public void pieno() {
        Administrator.consumiBenzina(capienzaSerbatoio - ltCarburante);
        ltCarburante = capienzaSerbatoio;
    }

}
