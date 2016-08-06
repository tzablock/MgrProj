package com.bank.shares.hadoop.job.InsideClientIncomeCalculation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tomasz on 5/10/16.
 */
public class IdToNameCache {
    Map<Long,String> idToNames =  new HashMap<Long, String>();;

    public Map<Long, String> getIdToNames() {
        return idToNames;
    }

    public void setIdToNames(Map<Long, String> idToNames) {
        this.idToNames = idToNames;
    }
}
