package com.nathol.hibi.netease.vo;

public enum Period {

    WEEKLY(1),

    ALL(0);

    private final int period;

    Period(int period){
        this.period = period;
    }

    public int getPeriod() {
        return period;
    }

}
