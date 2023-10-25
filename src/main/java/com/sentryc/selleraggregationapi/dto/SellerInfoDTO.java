package com.sentryc.selleraggregationapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class SellerInfoDTO {
    private String sellerName;
    private String externalId;
    private String marketplaceId;
    private List<ProducerSellerStateDTO> producerSellerStates;

}
