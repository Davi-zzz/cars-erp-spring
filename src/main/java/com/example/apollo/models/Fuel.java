package com.example.apollo.models;

public enum Fuel {
    PETROL(0),
    ALCOHOL(1),
    DIESEL(2),
    ELETRIC(3);

    private int value;

    private Fuel(int value) {
        this.value = value;
    }

    public static Fuel fromValue(int value) {
        for (Fuel j : Fuel.values()) {
            if (j.value == value) {
                return j;
            }
        }
        throw new FuelNotFoundError();
    }

}

class FuelNotFoundError extends Error {
    public FuelNotFoundError() {
        super("Not a valid value");
    }
}
