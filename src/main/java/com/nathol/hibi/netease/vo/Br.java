package com.nathol.hibi.netease.vo;

public enum Br {

    LOW(64000),

    MEDIUM(128000),

    STANDARD(198000),

    HIGH(320000);

    private final int bitRate;

    Br(int bitRate) {
        this.bitRate = bitRate;
    }

    public int getBr() {
        return bitRate;
    }

}
