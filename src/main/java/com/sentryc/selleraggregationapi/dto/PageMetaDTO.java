package com.sentryc.selleraggregationapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageMetaDTO {

    private int page;
    private int size;
    private long totalRecords;

}
