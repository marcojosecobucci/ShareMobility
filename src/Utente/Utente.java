package Utente;

import DB.Database;
import Enumerator.Caschi;
import Enumerator.Patenti;
import Veicoli.Veicoli;

import java.util.List;
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
        String userId = scanner.nextLine();
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
        String nome = scanner.nextLine();
        System.out.println("Inserisci il tuo cognome:");
        String cognome = scanner.nextLine();
        System.out.println("Inserisci la tua data di nascita:");
        String dataDiNascita = scanner.nextLine();
        System.out.println("Inserisci il CF:");
        String CF = scanner.nextLine();
        Patenti patentiUtente = inserisciPatentiUtente();
        Caschi caschiUtente = inserisciCaschiUtente();
        System.out.println("Inserisci il Credito:");
        int credito = scanner.nextInt();

        Utente utente = db.addNewUtente(ID, nome, cognome, dataDiNascita, CF, patentiUtente, caschiUtente, credito);
        return utente;
    }

    private Patenti inserisciPatentiUtente() {
        System.out.println("Patenti: \n  1- PATENTE A \n 2- PATENT B \n 3- PATENTE C " + "\n Inserisci la patente che possiedi con il numero raffigurato \n" + "In caso non hai nessuna patente lascia vuoto");
        String patentiIns = scanner.nextLine();
        return db.addNewPatente(patentiIns);
    }

    private Caschi inserisciCaschiUtente() {
        System.out.println("Caschi: \n  1-- CASCO MOTO" + "\n Digita 1 se possiedi un casco \n" + "In caso non hai nessuna patente lascia vuoto");
        String caschiIns = scanner.nextLine();
        return db.addNewCasco(caschiIns);
    }

    private void menuUtente(Utente utente) {
        String[] arreyScelteMenu = new String[6];

        System.out.println(utente);
        int counterMenu = 1;
        String menu = "";

        menu += counterMenu + "- " + "Affitta Bicicletta \n";

        arreyScelteMenu[counterMenu - 1] = "bicicletta";
        counterMenu++;
        menu += counterMenu + "- " + "Affitta Monopattino \n";
        arreyScelteMenu[counterMenu - 1] = "monopattino";
        counterMenu++;
        if ((utente.patenti.equals(Patenti.PATENTE_A) || utente.patenti.equals(Patenti.PATENTE_B) || utente.patenti.equals(Patenti.PATENTE_C)) && utente.caschi.equals(Caschi.CASCO)) {
            menu += counterMenu + "- " + "Affitta Scooter \n";
            arreyScelteMenu[counterMenu - 1] = "scooter";
            counterMenu++;
        }
        if (utente.patenti.equals(Patenti.PATENTE_B) || utente.patenti.equals(Patenti.PATENTE_C)) {
            menu += counterMenu + "- " + "Affitta Automobile \n";
            arreyScelteMenu[counterMenu - 1] = "automobile";
            counterMenu++;
        }
        if (utente.patenti.equals(Patenti.PATENTE_C)) {
            menu += counterMenu + "- " + "Affitta Furgoncino \n";
            arreyScelteMenu[counterMenu - 1] = "furgoncino";
            counterMenu++;
        }
        menu += counterMenu + "- " + "Aggiungi Credito \n";
        arreyScelteMenu[counterMenu - 1] = "credito";
        counterMenu++;
        menu += counterMenu + "- " + "Chiudi APP \n";
        arreyScelteMenu[counterMenu - 1] = "esci";


        System.out.println(menu);
        System.out.println("\n" + "CREDITO RESIDUO: " + utente.credito + "\n");
        sceltaMenu(arreyScelteMenu);
        System.out.println("Digita l'id del veicolo che ti interessa: ");
        affittaVeicolo(scanner.nextLine());
    }

    private void sceltaMenu(String[] arreyScelteMenu) {
        System.out.println("Inserisci il numero della scelta: ");
        int scelta = scanner.nextInt();
        do {
            switch (arreyScelteMenu[scelta - 1]) {
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
                    // TODO: 22/06/2022   creare il metodo aggiunta credito utente
                    break;
            }

        } while (arreyScelteMenu[scelta - 1] != "esci");
    }

    private void menuAdmin() {
        System.out.println("Ciao Io sono il BOSS!");
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Utente{" + "ID='" + ID + '\'' + ", nome='" + nome + '\'' + ", cognome='" + cognome + '\'' + ", dataDiNascita='" + dataDiNascita + '\'' + ", CF='" + CF + '\'' + ", patenti=" + patenti + ", caschi=" + caschi + ", credito=" + credito + '}';
    }

    public void affittaVeicolo(String s) {

        for (Veicoli veicolo : db.getVeicoliDisponibili()) {
            if (veicolo.getID().equals(s)) {
// TODO: 22/06/2022 dovremmo creare il metodo per l affitto della macchina. 
            }
        }


    }
}
