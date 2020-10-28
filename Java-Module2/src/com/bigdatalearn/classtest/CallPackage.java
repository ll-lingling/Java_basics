package com.bigdatalearn.classtest;


/**
 * 通话套餐类
 * 特征：通话时长、短信条数、每月资费
 * 行为: 显示所有套餐信息
 */
public class CallPackage implements CallService {
    private int callDuration;       //通话时长（分钟）
    private int countOfTextMessage; //短信条数
    private double monthCost;       //每月资费
    private int usedCallDuration = 0;   //已消耗的通话时长
    private int usedCountOfTextMessage = 0; //已消耗的短信条数

    public CallPackage(PhoneCardType phoneCardType) {
        if ("大".equals(phoneCardType.getCardType())) {
            setCallDuration(500);
            setCountOfTextMessage(200);
            setMonthCost(20);
        } else if ("小".equals(phoneCardType.getCardType())) {
            setCallDuration(200);
            setCountOfTextMessage(100);
            setMonthCost(10);
        } else if ("微型".equals(phoneCardType.getCardType())) {
            setCallDuration(100);
            setCountOfTextMessage(50);
            setMonthCost(5);
        } else {
            System.out.println("error");
        }
    }

    public int getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(int callDuration) {
        this.callDuration = callDuration;
    }

    public int getCountOfTextMessage() {
        return countOfTextMessage;
    }

    public void setCountOfTextMessage(int countOfTextMessage) {
        this.countOfTextMessage = countOfTextMessage;
    }

    public double getMonthCost() {
        return monthCost;
    }

    public void setMonthCost(double monthCost) {
        this.monthCost = monthCost;
    }

    public int getUsedCallDuration() {
        return usedCallDuration;
    }

    public void setUsedCallDuration(int usedCallDuration) {
        this.usedCallDuration = this.usedCallDuration + usedCallDuration;
    }

    public int getUsedCountOfTextMessage() {
        return usedCountOfTextMessage;
    }

    public void setUsedCountOfTextMessage(int usedCountOfTextMessage) {
        this.usedCountOfTextMessage = this.usedCountOfTextMessage + usedCountOfTextMessage;
    }

    public void show() {
        System.out.println("本套餐包含通话时长：" + getCallDuration() + "分钟，短信：" + getCountOfTextMessage() + "条，每月资费：" + getMonthCost() + "元");
    }

    public int call(int callDuration) {
        setUsedCallDuration(callDuration);
        System.out.println("本次通话时长为：" + callDuration + "分钟");
        return callDuration;
    }
}
