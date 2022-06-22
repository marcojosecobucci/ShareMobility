package Veicoli.SottoClasse;

import Administrator.Administrator;
import Enumerator.*;
import Veicoli.Veicoli;

public class MonopattinoElettrico extends Veicoli {
    private int batteriaRestante;

    private static ListinoPrezziAlMin prezziMonopattino = ListinoPrezziAlMin.MONOPATTINO;
    private static float prezzoAlMinuto = prezziMonopattino.getValue();
    private static ConsumiVeicolo consumiMonopattino = ConsumiVeicolo.MONOPATTINO;
    private static int BatteriaPerOgniKm = consumiMonopattino.getValue();
    private static Batteria batteriaMonopattino = Batteria.MONOPATTINO;
    private static int batteria = batteriaMonopattino.getValue();

    public MonopattinoElettrico(String ID, StatoVeicolo statoVeicolo, String posizioneGeografica, int batteriaRestante) {
        super(ID, Patenti.NESSUNA, Caschi.NESSUNO, statoVeicolo, posizioneGeografica);
        this.batteriaRestante = batteriaRestante;
    }

    public int getBatteriaRestante() {
        return batteriaRestante;
    }


    public void ricaricaCompleta() {
        Administrator.consumiBenzina(batteria - batteriaRestante);
        batteriaRestante = batteria;
    }
}
