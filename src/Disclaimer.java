import DB.Database;
import Utente.Utente;

public class Disclaimer {
    public static void main(String[] args) {
        Database db = new Database();
        Utente utente = new Utente(db);

        utente.login();
        System.out.println("Ciao");
    }
}