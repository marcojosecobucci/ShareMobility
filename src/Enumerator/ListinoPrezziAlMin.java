package Enumerator;

public enum ListinoPrezziAlMin {
    BICICLETTA(0.1f), MONOPATTINO(0.5f), SCOOTER(1), AUTOMOBILE(1.5f), FURGONCINO(2);

    private float prezzoAlMin;

    ListinoPrezziAlMin(float prezzoAlMin) {
        this.prezzoAlMin = prezzoAlMin;
    }

    public float getValue() {
        return prezzoAlMin;
    }
}

