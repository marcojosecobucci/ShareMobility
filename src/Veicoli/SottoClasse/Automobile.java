package Veicoli.SottoClasse;

import Administrator.Administrator;
import Enumerator.*;
import Interfaces.Rifornimento;
import Veicoli.Veicoli;

public class Automobile extends Veicoli implements Rifornimento {

    private String targa;

    private float ltCarburante;

    private static ListinoPrezziAlMin prezziAutomobile = ListinoPrezziAlMin.AUTOMOBILE;
    public static float prezzoAlMinuto = prezziAutomobile.getValue();

    private static ConsumiVeicolo consumiAutomobile = ConsumiVeicolo.AUTOMOBILE;
    private static int kmConUnLitro = consumiAutomobile.getValue();

    private static Serbatoi serbatoioAutomobile = Serbatoi.AUTOMOBILE;
    private static int capienzaSerbatoio = serbatoioAutomobile.getValue();

    public Automobile(String ID, StatoVeicolo statoVeicolo, String posizioneGeografica, String targa, int ltCarburante) {
        super(ID, Patenti.PATENTE_B, Caschi.NESSUNO, statoVeicolo, posizioneGeografica);
        this.targa = targa;
        this.ltCarburante = ltCarburante;
    }

    public float getLtCarburante() {
        return ltCarburante;
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
