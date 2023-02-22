package com.nathol.hibi.netease.vo;

public enum SearchType {

    /**
     * 单曲
     */
    SONG(1),

    /**
     * 专辑
     */
    ALBUM(10),

    /**
     * 歌手
     */
    SINGER(100),

    /**
     * 歌单
     */
    PLAYLIST(1000),

    /**
     * 用户
     */
    USER(1002),

    /**
     * MV
     */
    MV(1004),

    /**
     * 歌词
     */
    LYRICS(1006),

    /**
     * 电台
     */
    RADIO(1009),

    /**
     * 视频
     */
    VIDEO(1014);

    private final int parameters;

    /**
     * 构造方法-用于定义一个枚举内维护的一个值
     * @param parameters 枚举内维护的一个值
     */
    SearchType(int parameters) {
        this.parameters = parameters;
    }

    /**
     * 获取到枚举内维护的一个值
     * @return 枚举内维护的一个值
     */
    public int getParameters() {
        return this.parameters;
    }

}