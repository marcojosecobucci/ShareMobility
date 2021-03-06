package Enumerator;

public enum ConsumiVeicolo {
    MONOPATTINO(1), SCOOTER(15), AUTOMOBILE(10), FURGONCINO(5);

    private int ConsumiVeicoloKmPerLitro;

    ConsumiVeicolo(int ConsumiVeicoloKmPerLitro) {
        this.ConsumiVeicoloKmPerLitro = ConsumiVeicoloKmPerLitro;
    }

    public int getValue() {
        return ConsumiVeicoloKmPerLitro;
    }
}
