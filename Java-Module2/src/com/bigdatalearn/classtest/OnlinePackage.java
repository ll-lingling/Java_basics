package com.bigdatalearn.classtest;

/**
 * 上网套餐类
 * 特征：上网流量、每月资费
 * 行为：显示所有套餐信息
 */
public class OnlinePackage implements OnlineService {
    private double networkFlow;     //上网流量
    private double monthCost;       //每月资费
    private double usedNetworkFlow; //已消耗的上网流量

    public OnlinePackage(PhoneCardType phoneCardType) {
        if ("大".equals(phoneCardType.getCardType())) {
            setNetworkFlow(1000);
            setMonthCost(20);
        } else if ("小".equals(phoneCardType.getCardType())) {
            setNetworkFlow(500);
            setMonthCost(10);
        } else if ("微型".equals(phoneCardType.getCardType())) {
            setNetworkFlow(200);
            setMonthCost(5);
        } else {
            System.out.println("error");
        }

    }

    public double getNetworkFlow() {
        return networkFlow;
    }

    public void setNetworkFlow(long networkFlow) {
        this.networkFlow = this.usedNetworkFlow + networkFlow;
    }

    public double getMonthCost() {
        return monthCost;
    }

    public void setMonthCost(double monthCost) {
        this.monthCost = monthCost;
    }

    public double getUsedNetworkFlow() {
        return usedNetworkFlow;
    }

    public void setUsedNetworkFlow(double usedNetworkFlow) {
        this.usedNetworkFlow = usedNetworkFlow;
    }

    public void show() {
        System.out.println("本套餐包含上网流量：" + getNetworkFlow() + "MB，每月资费为：" + getMonthCost() + "元");
    }

    public long surfTheInternet(long networkFlow) {
        setUsedNetworkFlow(networkFlow);
        System.out.println("本次消耗流量为：" + networkFlow + "MB");
        return networkFlow;
    }
}
