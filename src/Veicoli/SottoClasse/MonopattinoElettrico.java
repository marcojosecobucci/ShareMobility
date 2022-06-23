package Veicoli.SottoClasse;

import Enumerator.*;
import Veicoli.Veicoli;

public class MonopattinoElettrico extends Veicoli {
    private int batteriaRestante;

    public static float prezzoAlMinuto = ListinoPrezziAlMin.MONOPATTINO.getValue();
    private static final int BatteriaPerOgniKm = ConsumiVeicolo.MONOPATTINO.getValue();
    private static final int batteria = Batteria.MONOPATTINO.getValue();

    public MonopattinoElettrico(String ID, StatoVeicolo statoVeicolo, String posizioneGeografica, int batteriaRestante) {
        super(ID, Patenti.NESSUNA, Caschi.NESSUNO, statoVeicolo, posizioneGeografica);
        this.batteriaRestante = batteriaRestante;
    }

    public void setBatteriaRestante(int km) {
        batteriaRestante -= (km * BatteriaPerOgniKm);
    }

}
