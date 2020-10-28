package com.bigdatalearn.classtest;

/**
 * 手机卡类
 * 特征：卡类型、卡号、用户名、密码、账户余额、通话时长(分钟)、上网流量
 * 行为：显示（卡号 + 用户名 + 当前余额）
 */
public class PhoneCard {
    private PhoneCardType cardType;         //卡类型
    private CallPackage callPackage;        //通话套餐
    private OnlinePackage onlinePackage;    //上网套餐

    private String cardNumber;              //卡号
    private String username;                //用户名
    private String password;                //密码

    private double accountBalance = 200;          //账户余额
    private int callDuration = 0;               //通话时长（分钟）
    private double networkFlow = 0;             //上网流量(MB)


    public PhoneCard(PhoneCardType phoneCardType, String cardNumber) {
        setCardType(phoneCardType);
        setCallService();
        setOnlineService();

        setCardNumber(cardNumber);
        setUsername("username");
        setPassword("password");
    }

    public PhoneCardType getCardType() {
        return cardType;
    }

    public void setCardType(PhoneCardType phoneCardType) {
        this.cardType = phoneCardType;
    }

    public CallPackage getCallPackage() {
        return callPackage;
    }

    public void setCallService() {
        this.callPackage = new CallPackage(this.cardType);
    }

    public OnlinePackage getOnlinePackage() {
        return onlinePackage;
    }

    public void setOnlineService() {
        this.onlinePackage = new OnlinePackage(this.cardType);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public int getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(int callDuration) {
        this.callDuration = callDuration;
    }

    public double getNetworkFlow() {
        return networkFlow;
    }

    public void setNetworkFlow(double networkFlow) {
        this.networkFlow = networkFlow;
    }

    public void show() {
        System.out.println("卡号：" + getCardNumber() + "，用户名：" + getUsername() + "，当前余额：" + getAccountBalance());
    }
}