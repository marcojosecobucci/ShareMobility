import DB.Database;

public class Disclaimer {
    public static void main(String[] args) {
        Database db = new Database();

        System.out.println(db.automobileList().get(0));

    }
}