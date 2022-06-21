package Veicoli.SottoClasse;

import Enumerator.*;
import Veicoli.Veicoli;

import java.util.List;

public class MonopattinoElettrico extends Veicoli {
    private int batteriaRestante;

    private static ListinoPrezziAlMin prezziMonopattino = ListinoPrezziAlMin.MONOPATTINO;
    private static float prezzoAlMinuto = prezziMonopattino.getValue();
    private static ConsumiVeicolo consumiMonopattino = ConsumiVeicolo.MONOPATTINO;
    private static int BatteriaPerOgniKm = consumiMonopattino.getValue();
    private static Batteria batteriaMonopattino = Batteria.MONOPATTINO;
    private static int batteria = batteriaMonopattino.getValue();

    public MonopattinoElettrico(String ID, List<Patenti> patente, List<Caschi> casco, StatoVeicolo statoVeicolo, String posizioneGeografica, int batteriaRestante) {
        super(ID, patente, casco, statoVeicolo, posizioneGeografica);
        this.batteriaRestante = batteriaRestante;
    }

    public int getBatteriaRestante() {
        return batteriaRestante;
    }
}
