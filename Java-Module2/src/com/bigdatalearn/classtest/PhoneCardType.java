package com.bigdatalearn.classtest;

public enum PhoneCardType {
    BIG("大"), SMALL("小"), MINI("微型");

    private final String cardType;

    private PhoneCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardType() {
        return cardType;
    }
}
