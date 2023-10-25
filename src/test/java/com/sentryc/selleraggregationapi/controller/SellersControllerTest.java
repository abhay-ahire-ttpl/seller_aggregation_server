package com.sentryc.selleraggregationapi.controller;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.sentryc.selleraggregationapi.dto.PageInputDTO;
import com.sentryc.selleraggregationapi.dto.PageMetaDTO;
import com.sentryc.selleraggregationapi.dto.SellerFilterDTO;
import com.sentryc.selleraggregationapi.enam.SellerSortBy;
import com.sentryc.selleraggregationapi.response.SellerPageableResponse;
import com.sentryc.selleraggregationapi.service.SellerService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SellersController.class})
@ExtendWith(SpringExtension.class)
class SellersControllerTest {
    @MockBean
    private SellerService sellerService;

    @Autowired
    private SellersController sellersController;

    /**
     * Method under test: {@link SellersController#getSellers(SellerFilterDTO, PageInputDTO, SellerSortBy)}
     */
    @Test
    void testGetSellers() {
        SellerPageableResponse sellerPageableResponse = new SellerPageableResponse();
        sellerPageableResponse.setData(new ArrayList<>());
        sellerPageableResponse.setPageMeta(new PageMetaDTO(1, 3, 1L));
        when(sellerService.getSellers(Mockito.<SellerFilterDTO>any(), Mockito.<PageInputDTO>any(),
                Mockito.<SellerSortBy>any())).thenReturn(sellerPageableResponse);

        SellerFilterDTO filter = new SellerFilterDTO();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");

        PageInputDTO page = new PageInputDTO();
        page.setPage(1);
        page.setSize(3);
        assertSame(sellerPageableResponse,
                sellersController.getSellers(filter, page, SellerSortBy.SELLER_INFO_EXTERNAL_ID_ASC));
        verify(sellerService).getSellers(Mockito.<SellerFilterDTO>any(), Mockito.<PageInputDTO>any(),
                Mockito.<SellerSortBy>any());
    }

    /**
     * Method under test: {@link SellersController#getSellers(SellerFilterDTO, PageInputDTO, SellerSortBy)}
     */
    @Test
    void testGetSellers2() {
        SellerPageableResponse sellerPageableResponse = new SellerPageableResponse();
        sellerPageableResponse.setData(new ArrayList<>());
        sellerPageableResponse.setPageMeta(new PageMetaDTO(1, 3, 1L));
        when(sellerService.getSellers(Mockito.<SellerFilterDTO>any(), Mockito.<PageInputDTO>any(),
                Mockito.<SellerSortBy>any())).thenReturn(sellerPageableResponse);

        SellerFilterDTO filter = new SellerFilterDTO();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");

        PageInputDTO page = new PageInputDTO();
        page.setPage(1);
        page.setSize(3);
        assertSame(sellerPageableResponse,
                sellersController.getSellers(filter, page, SellerSortBy.SELLER_INFO_EXTERNAL_ID_DESC));
        verify(sellerService).getSellers(Mockito.<SellerFilterDTO>any(), Mockito.<PageInputDTO>any(),
                Mockito.<SellerSortBy>any());
    }

    /**
     * Method under test: {@link SellersController#getSellers(SellerFilterDTO, PageInputDTO, SellerSortBy)}
     */
    @Test
    void testGetSellers3() {
        SellerPageableResponse sellerPageableResponse = new SellerPageableResponse();
        sellerPageableResponse.setData(new ArrayList<>());
        sellerPageableResponse.setPageMeta(new PageMetaDTO(1, 3, 1L));
        when(sellerService.getSellers(Mockito.<SellerFilterDTO>any(), Mockito.<PageInputDTO>any(),
                Mockito.<SellerSortBy>any())).thenReturn(sellerPageableResponse);

        SellerFilterDTO filter = new SellerFilterDTO();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");

        PageInputDTO page = new PageInputDTO();
        page.setPage(1);
        page.setSize(3);
        assertSame(sellerPageableResponse, sellersController.getSellers(filter, page, SellerSortBy.NAME_ASC));
        verify(sellerService).getSellers(Mockito.<SellerFilterDTO>any(), Mockito.<PageInputDTO>any(),
                Mockito.<SellerSortBy>any());
    }

    /**
     * Method under test: {@link SellersController#getSellers(SellerFilterDTO, PageInputDTO, SellerSortBy)}
     */
    @Test
    void testGetSellers4() {
        SellerPageableResponse sellerPageableResponse = new SellerPageableResponse();
        sellerPageableResponse.setData(new ArrayList<>());
        sellerPageableResponse.setPageMeta(new PageMetaDTO(1, 3, 1L));
        when(sellerService.getSellers(Mockito.<SellerFilterDTO>any(), Mockito.<PageInputDTO>any(),
                Mockito.<SellerSortBy>any())).thenReturn(sellerPageableResponse);

        SellerFilterDTO filter = new SellerFilterDTO();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");

        PageInputDTO page = new PageInputDTO();
        page.setPage(1);
        page.setSize(3);
        assertSame(sellerPageableResponse, sellersController.getSellers(filter, page, SellerSortBy.NAME_DESC));
        verify(sellerService).getSellers(Mockito.<SellerFilterDTO>any(), Mockito.<PageInputDTO>any(),
                Mockito.<SellerSortBy>any());
    }

    /**
     * Method under test: {@link SellersController#getSellers(SellerFilterDTO, PageInputDTO, SellerSortBy)}
     */
    @Test
    void testGetSellers5() {
        SellerPageableResponse sellerPageableResponse = new SellerPageableResponse();
        sellerPageableResponse.setData(new ArrayList<>());
        sellerPageableResponse.setPageMeta(new PageMetaDTO(1, 3, 1L));
        when(sellerService.getSellers(Mockito.<SellerFilterDTO>any(), Mockito.<PageInputDTO>any(),
                Mockito.<SellerSortBy>any())).thenReturn(sellerPageableResponse);

        SellerFilterDTO filter = new SellerFilterDTO();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");

        PageInputDTO page = new PageInputDTO();
        page.setPage(1);
        page.setSize(3);
        assertSame(sellerPageableResponse, sellersController.getSellers(filter, page, SellerSortBy.MARKETPLACE_ID_ASC));
        verify(sellerService).getSellers(Mockito.<SellerFilterDTO>any(), Mockito.<PageInputDTO>any(),
                Mockito.<SellerSortBy>any());
    }

    /**
     * Method under test: {@link SellersController#getSellers(SellerFilterDTO, PageInputDTO, SellerSortBy)}
     */
    @Test
    void testGetSellers6() {
        SellerPageableResponse sellerPageableResponse = new SellerPageableResponse();
        sellerPageableResponse.setData(new ArrayList<>());
        sellerPageableResponse.setPageMeta(new PageMetaDTO(1, 3, 1L));
        when(sellerService.getSellers(Mockito.<SellerFilterDTO>any(), Mockito.<PageInputDTO>any(),
                Mockito.<SellerSortBy>any())).thenReturn(sellerPageableResponse);

        SellerFilterDTO filter = new SellerFilterDTO();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");

        PageInputDTO page = new PageInputDTO();
        page.setPage(1);
        page.setSize(3);
        assertSame(sellerPageableResponse, sellersController.getSellers(filter, page, SellerSortBy.MARKETPLACE_ID_DESC));
        verify(sellerService).getSellers(Mockito.<SellerFilterDTO>any(), Mockito.<PageInputDTO>any(),
                Mockito.<SellerSortBy>any());
    }
}

