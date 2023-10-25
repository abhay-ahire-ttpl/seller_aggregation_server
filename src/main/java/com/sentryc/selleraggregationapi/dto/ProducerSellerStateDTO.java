package com.sentryc.selleraggregationapi.dto;


import lombok.Data;

@Data
public class ProducerSellerStateDTO {

    private String producerId;
    private String producerName;
    private String sellerState;
    private String sellerId;

}