package Administrator;

public class Administrator {

    public static float COSTO_BENZINA = 2;

    public static float guadagnoSocieta;

    public Administrator() {
        guadagnoSocieta = 0;
    }

    public static void consumiBenzina(float lt) {
        guadagnoSocieta -= lt * COSTO_BENZINA;
        System.out.println("Il guadagno attuale della socetà è: " + guadagnoSocieta);
    }

    public static void guadagnoDaAffitto(int guadagno) {
        guadagnoSocieta += guadagno;
        System.out.println("Il guadagno attuale della socetà è: " + guadagnoSocieta);
    }
}
