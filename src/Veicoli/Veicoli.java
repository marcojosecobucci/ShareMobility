package Veicoli;

import Enumerator.Caschi;
import Enumerator.ListinoPrezziAlMin;
import Enumerator.Patenti;
import Enumerator.StatoVeicolo;

import java.util.List;

public class Veicoli {

    private String ID;

    private List<Patenti> patente;

    private List<Caschi> casco;

    private StatoVeicolo statoVeicolo;

    private String posizioneGeografica;

    public Veicoli(String ID, List<Patenti> patente, List<Caschi> casco, StatoVeicolo statoVeicolo, String posizioneGeografica) {
        this.ID = ID;
        this.patente = patente;
        this.casco = casco;
        this.statoVeicolo = statoVeicolo;
        this.posizioneGeografica = posizioneGeografica;
    }

    @Override
    public String toString() {
        return "ID='" + ID + '\'' +
                ", patente=" + patente +
                ", casco=" + casco +
                ", statoVeicolo=" + statoVeicolo +
                ", posizioneGeografica='" + posizioneGeografica + '\''
                ;
    }

    public StatoVeicolo getStatoVeicolo() {
        return statoVeicolo;
    }

    public String getPosizioneGeografica() {
        return posizioneGeografica;
    }
}
