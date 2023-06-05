package com.paulina.pojo;

public enum Coin {

    QUARTER (25),
    DIME (10),
    NICKEL (5),
    PENNY (1);

    private int pennies;

    Coin(int pennies) {
        this.pennies = pennies;
    }

    public int getPennies() {
        return pennies;
    }
}