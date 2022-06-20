package Enumerator;

public enum Batteria {
    MONOPATTINO(100);

    private int batteria;

    Batteria(int batteria) {
        this.batteria = batteria;
    }

    public int getValue() {
        return batteria;
    }
}
