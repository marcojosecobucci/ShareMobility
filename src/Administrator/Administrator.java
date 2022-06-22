package Administrator;

public class Administrator {

    public static float COSTO_BENZINA = 2;

    public static float guadagnoSocieta;

    public Administrator() {
        guadagnoSocieta = 0;
    }

    public static void consumiBenzina(int lt) {
        guadagnoSocieta -= lt * 2;
        System.out.println("Il guadagno attuale della socetà è: " + guadagnoSocieta);
    }
}
