package Veicoli.SottoClasse;

import Enumerator.Caschi;
import Enumerator.ListinoPrezziAlMin;
import Enumerator.Patenti;
import Enumerator.StatoVeicolo;
import Veicoli.Veicoli;

import java.util.List;

public class Bicicletta extends Veicoli {
    private static ListinoPrezziAlMin prezziBici = ListinoPrezziAlMin.BICICLETTA;
    private static float prezzoAlMinuto = prezziBici.getValue();

    public Bicicletta(String ID, List<Patenti> patente, List<Caschi> casco, StatoVeicolo statoVeicolo, String posizioneGeografica) {
        super(ID, patente, casco, statoVeicolo, posizioneGeografica);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
