package com.sentryc.selleraggregationapi.controller;

import com.sentryc.selleraggregationapi.dto.PageInputDTO;
import com.sentryc.selleraggregationapi.dto.SellerFilterDTO;
import com.sentryc.selleraggregationapi.enam.SellerSortBy;
import com.sentryc.selleraggregationapi.response.SellerPageableResponse;
import com.sentryc.selleraggregationapi.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SellersController {

    private final SellerService sellerService;

    @Autowired
    public SellersController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @QueryMapping("sellers")
    public SellerPageableResponse getSellers(@Argument SellerFilterDTO filter, @Argument PageInputDTO page, @Argument SellerSortBy sortBy) {
        return sellerService.getSellers(filter, page, sortBy);
    }
}