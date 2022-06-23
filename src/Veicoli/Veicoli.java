package Veicoli;

import Enumerator.Caschi;
import Enumerator.ListinoPrezziAlMin;
import Enumerator.Patenti;
import Enumerator.StatoVeicolo;
import Veicoli.SottoClasse.Automobile;
import Veicoli.SottoClasse.Furgoncini;
import Veicoli.SottoClasse.MonopattinoElettrico;
import Veicoli.SottoClasse.Scooter;

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

    public static void veicoloAffittato(Veicoli veicoli, String posizioneGeografica, int km){
        veicoli.setPosizioneGeografica(posizioneGeografica);
        switch (veicoli.getID().charAt(0)){
            case 'M':
            ((MonopattinoElettrico) veicoli).setBatteriaRestante(km);
            break;
            case 'A':
                ((Automobile) veicoli).setLtCarburante(km);
                break;
            case 'S':
                ((Scooter) veicoli).setLtCarburante(km);
                break;
            case 'F':
                ((Furgoncini) veicoli).setLtCarburante(km);
                break;
        }
        System.out.println("Sei arrivato a destinazione");
        System.out.println(veicoli);
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

    public void setPosizioneGeografica(String posizioneGeografica) {
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
}
