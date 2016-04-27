package com.bank.shares.generator.exceptions;

/**
 * Created by tomasz on 4/16/16.
 */
public class RandomNumberArgsException extends Exception {
    private int iMin=-1;
    private int iMax=-1;
    private double dMin=-1.0;
    private double dMax=-1.0;

    public RandomNumberArgsException(int min, int max) {
        this.iMin = min;
        this.iMax = max;
    }
    public RandomNumberArgsException(double min, double max) {
        this.dMax = min;
        this.dMax = max;
    }

    @Override
    public String getMessage() {
        return "Not proper argumnets: min should be greater than 0, max should be less than possible type value, max should't be smaller than min: min="+(iMin!=-1 ? iMin: Double.toString(dMin))+", max="+(iMax!=-1 ? iMax: Double.toString(dMax));
    }

//    @Override
//    public String toString() {
//        return "Not proper argumnets: min should be greater than 0, max should be less than possible type value, max should't be smaller than min: min="+min+", max="+max;
//    }
}
