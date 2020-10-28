package com.bigdatalearn.classtest;

public interface CallService extends Package {
    public abstract int getCallDuration();

    public abstract void setCallDuration(int callDuration);

    public abstract int getCountOfTextMessage();

    public abstract void setCountOfTextMessage(int countOfTextMessage);

    public abstract double getMonthCost();

    public abstract void setMonthCost(double monthCost);
}
