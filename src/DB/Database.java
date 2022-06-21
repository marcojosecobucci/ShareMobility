package DB;

import Enumerator.Caschi;
import Enumerator.Patenti;
import Enumerator.StatoVeicolo;
import Utente.Utente;
import Veicoli.SottoClasse.*;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private List<Furgoncini> furgonciniList;
    private List<Automobile> automobileList;
    private List<Scooter> scooterList;
    private List<MonopattinoElettrico> monopattinoElettricoList;
    private List<Bicicletta> biciclettaList;
    private List<Utente> utenteList;


    public Database() {
        furgonciniList = new ArrayList<>();
        automobileList = new ArrayList<>();
        scooterList = new ArrayList<>();
        monopattinoElettricoList = new ArrayList<>();
        biciclettaList = new ArrayList<>();
        utenteList = new ArrayList<>();
        //Accensione DB (Simulato)
        furgonciniList();
        automobileList();
        scooterList();
        monopattinoElettricoList();
        biciclettaList();
        //utenteList();
        alphaUser();
        betaUser();
    }

    public void furgonciniList() {
        furgonciniList.add(new Furgoncini("F1", Patenti.PATENTE_C, Caschi.NESSUNO, StatoVeicolo.DISPONIBILE, "120,33", "AF224BC", 25));
        furgonciniList.add(new Furgoncini("F2", Patenti.PATENTE_C, Caschi.NESSUNO, StatoVeicolo.DISPONIBILE, "100,67", "AF354F", 80));
    }

    private void automobileList() {
        automobileList.add(new Automobile("A1", Patenti.PATENTE_B, Caschi.NESSUNO, StatoVeicolo.DISPONIBILE, "100,33", "AB123CF", 80));
        automobileList.add(new Automobile("A2", Patenti.PATENTE_B, Caschi.NESSUNO, StatoVeicolo.DISPONIBILE, "100,67", "AC244CF", 40));
    }

    private void scooterList() {
        scooterList.add(new Scooter("S1", Patenti.PATENTE_A, Caschi.CASCO, StatoVeicolo.DISPONIBILE, "120,33", "AA12345", 20));
        scooterList.add(new Scooter("S2", Patenti.PATENTE_A, Caschi.CASCO, StatoVeicolo.DISPONIBILE, "100,67", "AB56786", 20));
    }

    private void monopattinoElettricoList() {
        monopattinoElettricoList.add(new MonopattinoElettrico("M1", Patenti.NESSUNA, Caschi.NESSUNO, StatoVeicolo.DISPONIBILE, "120,33", 100));
        monopattinoElettricoList.add(new MonopattinoElettrico("M2", Patenti.NESSUNA, Caschi.NESSUNO, StatoVeicolo.DISPONIBILE, "100,67", 50));
    }

    private void biciclettaList() {
        biciclettaList.add(new Bicicletta("B1", Patenti.NESSUNA, Caschi.NESSUNO, StatoVeicolo.DISPONIBILE, "120,33"));
        biciclettaList.add(new Bicicletta("B2", Patenti.NESSUNA, Caschi.NESSUNO, StatoVeicolo.DISPONIBILE, "100,67"));
    }

    private void alphaUser() {
        utenteList.add(new Utente("alphaUser", "Alpha", "User", "02-07-1995", "LPSR", Patenti.PATENTE_C, Caschi.NESSUNO, 100));
    }

    private void betaUser() {
        utenteList.add(new Utente("betaUser", "Beta", "User", "02-07-1995", "BTSR", Patenti.PATENTE_B, Caschi.CASCO, 100));
    }

    public Utente getByIdUser(String ID) {
        for (Utente utente : utenteList) {
            if (utente.getID().equals(ID)) {
                return utente;
            }
        }
        return null;
    }

    public Patenti addNewPatente(String scelta) {
        scelta = scelta.trim();
        if (!scelta.isEmpty()) {
            for (int i = 0; i < 1; i++) {
                switch (scelta.charAt(i)) {
                    case '1':
                        return Patenti.PATENTE_A;
                    case '2':
                        return Patenti.PATENTE_B;
                    case '3':
                        return Patenti.PATENTE_C;
                    default:
                        break;
                }
            }
        }
        return Patenti.NESSUNA;
    }

    public Caschi addNewCasco(String scelte) {
        scelte = scelte.trim();
        if (!scelte.isEmpty()) {
            for (int i = 0; i < 1; i++) {
                if (scelte.charAt(i) == '1') {
                    return Caschi.CASCO;
                }
            }
        }
        return Caschi.NESSUNO;
    }

    public Utente addNewUtente(String ID, String nome, String cognome, String dataDiNascita, String CF, Patenti patente, Caschi casco, int credito) {
        utenteList.add(new Utente(ID, nome, cognome, dataDiNascita, CF, patente, casco, credito));
        return utenteList.get(utenteList.size() - 1);
    }


}
