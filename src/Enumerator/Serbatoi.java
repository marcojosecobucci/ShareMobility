package Enumerator;

public enum Serbatoi {

    SCOOTER(25), AUTOMOBILE(80), FURGONCINO(100);

    private int serbatoi;

    Serbatoi(int serbatoi) {
        this.serbatoi = serbatoi;
    }

    public int getValue() {
        return serbatoi;
    }
}
