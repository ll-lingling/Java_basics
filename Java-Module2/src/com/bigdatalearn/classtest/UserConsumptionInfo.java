package com.bigdatalearn.classtest;

/**
 * 用户消费信息类
 * 特征：统计通话时长、统计上网流量、每月消费金额
 */
public class UserConsumptionInfo {
    private int callDuration;       //通话时长（分钟）
    private double networkFlow;     //上网流量
    private double mouthCost;       //每月资费

    public UserConsumptionInfo(PhoneCard phoneCard) {
        setCallDuration(phoneCard);
        setNetworkFlow(phoneCard);
        setMouthCost(phoneCard);
    }

    public int getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(PhoneCard phoneCard) {
        this.callDuration = phoneCard.getCallPackage().getUsedCallDuration();
    }

    public double getNetworkFlow() {
        return networkFlow;
    }

    public void setNetworkFlow(PhoneCard phoneCard) {
        this.networkFlow = phoneCard.getOnlinePackage().getUsedNetworkFlow();
    }

    public double getMouthCost() {
        return mouthCost;
    }

    public void setMouthCost(PhoneCard phoneCard) {
        this.mouthCost = phoneCard.getCallPackage().getMonthCost() + phoneCard.getOnlinePackage().getMonthCost();
    }

    public void show() {
        System.out.println("当前用户通话总时长为：" + getCallDuration() + "，总消耗流量为：" + getNetworkFlow() + "MB，每月总资费为：" + getMouthCost() + "元");
    }

}