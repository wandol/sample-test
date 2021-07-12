package com.example.sampletest.vo;

import lombok.Builder;
import lombok.Data;

@Data
public class SearchVO{

    private String query;

    private String orderBy;

    private String limit;

    private String volume;

    private String select;

    @Builder
    public SearchVO(String query, String orderBy, String limit, String volume, String select) {
        this.query = query;
        this.orderBy = orderBy;
        this.limit = limit;
        this.volume = volume;
        this.select = select;
    }
}
