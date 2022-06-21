package Veicoli;

import Enumerator.Caschi;
import Enumerator.ListinoPrezziAlMin;
import Enumerator.Patenti;
import Enumerator.StatoVeicolo;

import java.util.List;

public abstract class Veicoli {

    private String ID;

    private Patenti patente;

    private Caschi casco;

    private StatoVeicolo statoVeicolo;

    private String posizioneGeografica;

    public Veicoli(String ID, Patenti patente, Caschi casco, StatoVeicolo statoVeicolo, String posizioneGeografica) {
        this.ID = ID;
        this.patente = patente;
        this.casco = casco;
        this.statoVeicolo = statoVeicolo;
        this.posizioneGeografica = posizioneGeografica;
    }

    public String getID() {
        return ID;
    }

    public StatoVeicolo getStatoVeicolo() {
        return statoVeicolo;
    }

    public String getPosizioneGeografica() {
        return posizioneGeografica;
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
}
