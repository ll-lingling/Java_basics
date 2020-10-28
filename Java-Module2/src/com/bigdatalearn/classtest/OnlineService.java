package com.bigdatalearn.classtest;

public interface OnlineService extends Package{
    public abstract double getNetworkFlow();

    public abstract void setNetworkFlow(long networkFlow);

    public abstract double getMonthCost();

    public abstract void setMonthCost(double monthCost);

}
