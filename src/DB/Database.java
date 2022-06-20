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
    private List<Patenti> patentiList;
    private List<Caschi> caschiList;
    private List<Utente> utenteList;

    public Database() {
        patentiList = new ArrayList<>();
        caschiList = new ArrayList<>();
        furgonciniList = new ArrayList<>();
        automobileList = new ArrayList<>();
        scooterList = new ArrayList<>();
        monopattinoElettricoList = new ArrayList<>();
        biciclettaList = new ArrayList<>();
        utenteList = new ArrayList<>();
    }

    public List<Furgoncini> furgonciniList() {
        patentiList.clear();
        patentiList.add(Patenti.PATENTE_C);
        caschiList.clear();
        caschiList.add(Caschi.NESSUNO);
        furgonciniList.add(new Furgoncini("F1", patentiList, caschiList, StatoVeicolo.DISPONIBILE, "120,33", "AF224BC", 25));
        furgonciniList.add(new Furgoncini("F2", patentiList, caschiList, StatoVeicolo.DISPONIBILE, "100,67", "AF354F", 80));
        return furgonciniList;
    }

    public List<Automobile> automobileList() {
        patentiList.clear();
        patentiList.add(Patenti.PATENTE_C);
        patentiList.add(Patenti.PATENTE_B);
        caschiList.clear();
        caschiList.add(Caschi.NESSUNO);
        automobileList.add(new Automobile("A1", patentiList, caschiList, StatoVeicolo.DISPONIBILE, "100,33", "AB123CF", 80));
        automobileList.add(new Automobile("A2", patentiList, caschiList, StatoVeicolo.DISPONIBILE, "100,67", "AC244CF", 40));
        return automobileList;
    }

    public List<Scooter> scooterList() {
        patentiList.clear();
        patentiList.add(Patenti.PATENTE_C);
        patentiList.add(Patenti.PATENTE_B);
        patentiList.add(Patenti.PATENTE_A);
        caschiList.clear();

        caschiList.add(Caschi.CASCO_MOTO);
        scooterList.add(new Scooter("S1", patentiList, caschiList, StatoVeicolo.DISPONIBILE, "120,33", "AA12345", 20));
        scooterList.add(new Scooter("S2", patentiList, caschiList, StatoVeicolo.DISPONIBILE, "100,67", "AB56786", 20));
        return scooterList;
    }

    public List<MonopattinoElettrico> monopattinoElettricoList() {
        patentiList.clear();
        patentiList.add(Patenti.NESSUNA);
        caschiList.clear();
        caschiList.add(Caschi.CASCO_MOTO);
        caschiList.add(Caschi.CASCO_BICI);
        monopattinoElettricoList.add(new MonopattinoElettrico("M1", patentiList, caschiList, StatoVeicolo.DISPONIBILE, "120,33", 100));
        monopattinoElettricoList.add(new MonopattinoElettrico("M2", patentiList, caschiList, StatoVeicolo.DISPONIBILE, "100,67", 50));
        return monopattinoElettricoList;
    }

    public List<Bicicletta> biciclettaList() {
        patentiList.clear();
        patentiList.add(Patenti.NESSUNA);
        caschiList.clear();
        caschiList.add(Caschi.NESSUNO);
        biciclettaList.add(new Bicicletta("B1", patentiList, caschiList, StatoVeicolo.DISPONIBILE, "120,33"));
        biciclettaList.add(new Bicicletta("B2", patentiList, caschiList, StatoVeicolo.DISPONIBILE, "100,67"));
        return biciclettaList;
    }

    public List<Utente> utenteList() {
        patentiList.clear();
        patentiList.add(Patenti.PATENTE_C);
        caschiList.clear();
        caschiList.add(Caschi.NESSUNO);
        utenteList.add(new Utente("User1", "User1", "Uno", "02-07-1995", "USERUNO1", patentiList, caschiList, 100));
        patentiList.clear();
        patentiList.add(Patenti.PATENTE_B);
        caschiList.clear();
        caschiList.add(Caschi.NESSUNO);
        utenteList.add(new Utente("User2", "User2", "Due", "02-07-1995", "USERDUE2", patentiList, caschiList, 100));
        patentiList.clear();
        patentiList.add(Patenti.PATENTE_A);
        caschiList.clear();
        caschiList.add(Caschi.CASCO_MOTO);
        utenteList.add(new Utente("User3", "User3", "Tre", "02-07-1995", "USERTRE3", patentiList, caschiList, 24));
        patentiList.clear();
        patentiList.add(Patenti.PATENTE_B);
        caschiList.clear();
        caschiList.add(Caschi.CASCO_BICI);
        utenteList.add(new Utente("User4", "User4", "Quattro", "02-07-1995", "USERQUATTRO4", patentiList, caschiList, 13));
        patentiList.clear();
        patentiList.add(Patenti.NESSUNA);
        caschiList.clear();
        caschiList.add(Caschi.NESSUNO);
        utenteList.add(new Utente("User5", "User5", "Cinque", "02-07-1995", "USERCINQUE5", patentiList, caschiList, 10));
        return utenteList;
    }
}
