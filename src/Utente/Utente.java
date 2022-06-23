package Utente;

import Administrator.Administrator;
import DB.Database;
import Enumerator.Caschi;
import Enumerator.Patenti;
import Veicoli.SottoClasse.Automobile;
import Veicoli.SottoClasse.Furgoncini;
import Veicoli.SottoClasse.MonopattinoElettrico;
import Veicoli.SottoClasse.Scooter;
import Veicoli.Veicoli;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Utente {
    private String ID;
    private String nome;
    private String cognome;
    private String dataDiNascita;
    private String CF;
    private Patenti patenti;
    private Caschi caschi;
    private int credito;

    static Scanner scanner = new Scanner(System.in);
    Database db;

    public Utente(Database db) {
        this.db = db;
    }

    public Utente(String ID, String nome, String cognome, String dataDiNascita, String CF, Patenti patenti, Caschi caschi, int credito) {
        this.ID = ID;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.CF = CF;
        this.patenti = patenti;
        this.caschi = caschi;
        this.credito = credito;
    }

    public void login() {
        System.out.print("Inserisci il tuo ID in caso non lo troviamo andrai direttamente nella registrazione: ");
        String userId = scanner.next();

        if (!userId.trim().equals("admin")) {
            Utente utente = db.getByIdUser(userId.trim());
            if (utente != null) {
                System.out.println();
                menuUtente(utente);
            } else {
                utente = registrazioneUtente(userId);
                menuUtente(utente);
            }
        } else {
            menuAdmin();
        }
    }

    private Utente registrazioneUtente(String ID) {
        System.out.println("Registrazione:");
        System.out.println("Inserisci il tuo nome:");
        String nome = scanner.next();

        System.out.println("Inserisci il tuo cognome:");
        String cognome = scanner.next();

        System.out.println("Inserisci la tua data di nascita:");
        String dataDiNascita = scanner.next();

        System.out.println("Inserisci il CF:");
        String CF = scanner.next();

        Patenti patentiUtente = inserisciPatentiUtente();
        Caschi caschiUtente = inserisciCaschiUtente();
        System.out.println("Inserisci il Credito:");
        int credito = Integer.parseInt(scanner.next());

        Utente utente = db.addNewUtente(ID, nome, cognome, dataDiNascita, CF, patentiUtente, caschiUtente, credito);
        return utente;
    }

    private Patenti inserisciPatentiUtente() {
        System.out.println("Patenti: \n  1- PATENTE A \n 2- PATENT B \n 3- PATENTE C " + "\n Inserisci la patente che possiedi con il numero raffigurato \n" + "In caso non hai nessuna patente lascia vuoto");
        String patentiIns = scanner.next();

        return db.addNewPatente(patentiIns);
    }

    private Caschi inserisciCaschiUtente() {
        System.out.println("Caschi: \n  1-- CASCO MOTO" + "\n Digita 1 se possiedi un casco \n" + "In caso non hai nessuna patente lascia vuoto");
        String caschiIns = scanner.next();

        return db.addNewCasco(caschiIns);
    }

    private void menuUtente(Utente utente) {
        String[] arrayScelteMenu = new String[6];

        System.out.println(utente);
        int counterMenu = 1;
        String menu = "";

        menu += counterMenu + "- " + "Affitta Bicicletta \n";

        arrayScelteMenu[counterMenu - 1] = "bicicletta";
        counterMenu++;
        menu += counterMenu + "- " + "Affitta Monopattino \n";
        arrayScelteMenu[counterMenu - 1] = "monopattino";
        counterMenu++;
        if ((utente.patenti.equals(Patenti.PATENTE_A) || utente.patenti.equals(Patenti.PATENTE_B) || utente.patenti.equals(Patenti.PATENTE_C)) && utente.caschi.equals(Caschi.CASCO)) {
            menu += counterMenu + "- " + "Affitta Scooter \n";
            arrayScelteMenu[counterMenu - 1] = "scooter";
            counterMenu++;
        }
        if (utente.patenti.equals(Patenti.PATENTE_B) || utente.patenti.equals(Patenti.PATENTE_C)) {
            menu += counterMenu + "- " + "Affitta Automobile \n";
            arrayScelteMenu[counterMenu - 1] = "automobile";
            counterMenu++;
        }
        if (utente.patenti.equals(Patenti.PATENTE_C)) {
            menu += counterMenu + "- " + "Affitta Furgoncino \n";
            arrayScelteMenu[counterMenu - 1] = "furgoncino";
            counterMenu++;
        }
        menu += counterMenu + "- " + "Aggiungi Credito \n";
        arrayScelteMenu[counterMenu - 1] = "credito";
        counterMenu++;
        menu += counterMenu + "- " + "Chiudi APP \n";
        arrayScelteMenu[counterMenu - 1] = "esci";


        System.out.println(menu);
        System.out.println("\n" + "CREDITO RESIDUO: " + utente.credito + "\n");
        sceltaMenu(arrayScelteMenu, utente);
    }

    private void sceltaMenu(String[] arrayScelteMenu, Utente utente) {
        System.out.println("Inserisci il numero della scelta: ");
        int scelta = scanner.nextInt();
        if (scelta <= arrayScelteMenu.length) {
            switch (arrayScelteMenu[scelta - 1]) {
                case "automobile":
                    db.veicoloDisponibile('A');
                    break;
                case "bicicletta":
                    db.veicoloDisponibile('B');
                    break;
                case "furgoncino":
                    db.veicoloDisponibile('F');
                    break;
                case "monopattino":
                    db.veicoloDisponibile('M');
                    break;
                case "scooter":
                    db.veicoloDisponibile('S');
                    break;
                case "credito":
                    addCredito(utente);
                    sceltaMenu(arrayScelteMenu, utente);
                    break;
                case "esci":
                    System.out.println("Hai chiuso L'APP!");
                    break;
            }
            System.out.println("Digita l'id del veicolo che ti interessa: ");
            String veicolo = scanner.next();

            affittaVeicolo(veicolo, utente);
        } else {
            sceltaMenu(arrayScelteMenu, utente);
        }
    }

    private void addCredito(Utente utente) {
        System.out.println("Quanto credito vuoi aggiungere:");
        utente.credito += scanner.nextInt();

        System.out.println("Nuovo credito: " + utente.credito);
    }

    public void setCredito(int km, Veicoli veicoli) {
        float prezzo = 0;
        switch (veicoli.getID().charAt(0)) {
            case 'M':
                prezzo = MonopattinoElettrico.prezzoAlMinuto;
                break;
            case 'A':
                prezzo = Automobile.prezzoAlMinuto;
                break;
            case 'S':
                prezzo = Scooter.prezzoAlMinuto;
                break;
            case 'F':
                prezzo = Furgoncini.prezzoAlMinuto;
                break;
        }
        credito -= km * prezzo;
        int guadagno = km * (int) prezzo;
        Administrator.guadagnoDaAffitto(guadagno);
    }

    private void menuAdmin() {
        System.out.println(Administrator.guadagnoSocieta);
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Utente{" + "ID='" + ID + '\'' + ", nome='" + nome + '\'' + ", cognome='" + cognome + '\'' + ", dataDiNascita='" + dataDiNascita + '\'' + ", CF='" + CF + '\'' + ", patenti=" + patenti + ", caschi=" + caschi + ", credito=" + credito + '}';
    }

    public void affittaVeicolo(String s, Utente utente) {
        for (Veicoli veicolo : db.getVeicoliDisponibili()) {
            if (veicolo.getID().equals(s)) {
                System.out.println("Dove vuoi andare: ");
                String puntoGeografico = scanner.next();

                System.out.println("Quanti km farai: ");
                String km = scanner.next();

                Veicoli.veicoloAffittato(veicolo, puntoGeografico, Integer.parseInt(km));
                utente.setCredito(Integer.parseInt(km), veicolo);
                login();
            }
        }
    }
}
