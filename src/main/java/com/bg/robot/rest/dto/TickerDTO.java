package com.bg.robot.rest.dto;

/**
 * Created by wangpeng on 15/09/2017.
 */
public class TickerDTO {


    private TickerDataDTO ticker;

    private Long date;

    public TickerDataDTO getTicker() {
        return ticker;
    }

    public void setTicker(TickerDataDTO ticker) {
        this.ticker = ticker;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}
