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

    public Bicicletta(String ID, StatoVeicolo statoVeicolo, String posizioneGeografica) {
        super(ID, Patenti.NESSUNA, Caschi.NESSUNO, statoVeicolo, posizioneGeografica);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
