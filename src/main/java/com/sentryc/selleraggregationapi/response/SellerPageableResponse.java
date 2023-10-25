package com.sentryc.selleraggregationapi.response;

import com.sentryc.selleraggregationapi.dto.PageMetaDTO;
import com.sentryc.selleraggregationapi.dto.SellerInfoDTO;
import lombok.Data;

import java.util.List;

@Data
public class SellerPageableResponse {

    private PageMetaDTO meta;

    private List<SellerInfoDTO> data;
}
