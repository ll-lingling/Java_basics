package com.bigdatalearn.classtest;

public class ClassTest {
    public static void main(String[] args) {
        PhoneCard phoneCard = new PhoneCard(PhoneCardType.BIG, "13112341234");
        phoneCard.show();

        System.out.println("------------------------------------------------------");
        phoneCard.getCallPackage().show();
        phoneCard.getCallPackage().call(33);

        System.out.println("------------------------------------------------------");
        phoneCard.getOnlinePackage().show();
        phoneCard.getOnlinePackage().surfTheInternet(66);

        System.out.println("------------------------------------------------------");
        new UserConsumptionInfo(phoneCard).show();
    }
}
