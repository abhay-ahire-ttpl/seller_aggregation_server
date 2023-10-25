package com.sentryc.selleraggregationapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.sentryc.selleraggregationapi.dto.PageInputDTO;
import com.sentryc.selleraggregationapi.dto.PageMetaDTO;
import com.sentryc.selleraggregationapi.dto.ProducerSellerStateDTO;
import com.sentryc.selleraggregationapi.dto.SellerFilterDTO;
import com.sentryc.selleraggregationapi.dto.SellerInfoDTO;
import com.sentryc.selleraggregationapi.enam.SellerSortBy;
import com.sentryc.selleraggregationapi.enam.SellerState;
import com.sentryc.selleraggregationapi.entity.Marketplace;
import com.sentryc.selleraggregationapi.entity.Producer;
import com.sentryc.selleraggregationapi.entity.Seller;
import com.sentryc.selleraggregationapi.entity.SellerInfo;
import com.sentryc.selleraggregationapi.repository.SellerRepository;
import com.sentryc.selleraggregationapi.response.SellerPageableResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SellerService.class})
@ExtendWith(SpringExtension.class)
class SellerServiceTest {
    @MockBean
    private SellerRepository sellerRepository;

    @Autowired
    private SellerService sellerService;

    /**
     * Method under test: {@link SellerService#getSellers(SellerFilterDTO, PageInputDTO, SellerSortBy)}
     */
    @Test
    void testGetSellers() {
        ArrayList<Seller> sellerList = new ArrayList<>();
        when(sellerRepository.findAll(Mockito.<Specification<Seller>>any())).thenReturn(sellerList);

        SellerFilterDTO filter = new SellerFilterDTO();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");
        PageInputDTO page = mock(PageInputDTO.class);
        when(page.getPage()).thenReturn(0);
        when(page.getSize()).thenReturn(3);
        doNothing().when(page).setPage(anyInt());
        doNothing().when(page).setSize(anyInt());
        page.setPage(1);
        page.setSize(3);
        SellerPageableResponse actualSellers = sellerService.getSellers(filter, page,
                SellerSortBy.SELLER_INFO_EXTERNAL_ID_ASC);
        List<SellerInfoDTO> data = actualSellers.getData();
        assertEquals(sellerList, data);
        assertTrue(data.isEmpty());
        PageMetaDTO pageMeta = actualSellers.getPageMeta();
        assertEquals(3, pageMeta.getPageSize());
        assertEquals(0, pageMeta.getTotalPages());
        assertEquals(0L, pageMeta.getTotalElements());
        verify(sellerRepository).findAll(Mockito.<Specification<Seller>>any());
        verify(page, atLeast(1)).getPage();
        verify(page, atLeast(1)).getSize();
        verify(page).setPage(anyInt());
        verify(page).setSize(anyInt());
    }

    /**
     * Method under test: {@link SellerService#getSellers(SellerFilterDTO, PageInputDTO, SellerSortBy)}
     */
    @Test
    void testGetSellers2() {
        ArrayList<Seller> sellerList = new ArrayList<>();
        when(sellerRepository.findAll(Mockito.<Specification<Seller>>any())).thenReturn(sellerList);

        SellerFilterDTO filter = new SellerFilterDTO();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");
        PageInputDTO page = mock(PageInputDTO.class);
        when(page.getPage()).thenReturn(0);
        when(page.getSize()).thenReturn(3);
        doNothing().when(page).setPage(anyInt());
        doNothing().when(page).setSize(anyInt());
        page.setPage(1);
        page.setSize(3);
        SellerPageableResponse actualSellers = sellerService.getSellers(filter, page,
                SellerSortBy.SELLER_INFO_EXTERNAL_ID_DESC);
        List<SellerInfoDTO> data = actualSellers.getData();
        assertEquals(sellerList, data);
        assertTrue(data.isEmpty());
        PageMetaDTO pageMeta = actualSellers.getPageMeta();
        assertEquals(3, pageMeta.getPageSize());
        assertEquals(0, pageMeta.getTotalPages());
        assertEquals(0L, pageMeta.getTotalElements());
        verify(sellerRepository).findAll(Mockito.<Specification<Seller>>any());
        verify(page, atLeast(1)).getPage();
        verify(page, atLeast(1)).getSize();
        verify(page).setPage(anyInt());
        verify(page).setSize(anyInt());
    }

    /**
     * Method under test: {@link SellerService#getSellers(SellerFilterDTO, PageInputDTO, SellerSortBy)}
     */
    @Test
    void testGetSellers3() {
        ArrayList<Seller> sellerList = new ArrayList<>();
        when(sellerRepository.findAll(Mockito.<Specification<Seller>>any())).thenReturn(sellerList);

        SellerFilterDTO filter = new SellerFilterDTO();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");
        PageInputDTO page = mock(PageInputDTO.class);
        when(page.getPage()).thenReturn(0);
        when(page.getSize()).thenReturn(3);
        doNothing().when(page).setPage(anyInt());
        doNothing().when(page).setSize(anyInt());
        page.setPage(1);
        page.setSize(3);
        SellerPageableResponse actualSellers = sellerService.getSellers(filter, page, SellerSortBy.NAME_ASC);
        List<SellerInfoDTO> data = actualSellers.getData();
        assertEquals(sellerList, data);
        assertTrue(data.isEmpty());
        PageMetaDTO pageMeta = actualSellers.getPageMeta();
        assertEquals(3, pageMeta.getPageSize());
        assertEquals(0, pageMeta.getTotalPages());
        assertEquals(0L, pageMeta.getTotalElements());
        verify(sellerRepository).findAll(Mockito.<Specification<Seller>>any());
        verify(page, atLeast(1)).getPage();
        verify(page, atLeast(1)).getSize();
        verify(page).setPage(anyInt());
        verify(page).setSize(anyInt());
    }

    /**
     * Method under test: {@link SellerService#getSellers(SellerFilterDTO, PageInputDTO, SellerSortBy)}
     */
    @Test
    void testGetSellers4() {
        ArrayList<Seller> sellerList = new ArrayList<>();
        when(sellerRepository.findAll(Mockito.<Specification<Seller>>any())).thenReturn(sellerList);

        SellerFilterDTO filter = new SellerFilterDTO();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");
        PageInputDTO page = mock(PageInputDTO.class);
        when(page.getPage()).thenReturn(0);
        when(page.getSize()).thenReturn(3);
        doNothing().when(page).setPage(anyInt());
        doNothing().when(page).setSize(anyInt());
        page.setPage(1);
        page.setSize(3);
        SellerPageableResponse actualSellers = sellerService.getSellers(filter, page, SellerSortBy.NAME_DESC);
        List<SellerInfoDTO> data = actualSellers.getData();
        assertEquals(sellerList, data);
        assertTrue(data.isEmpty());
        PageMetaDTO pageMeta = actualSellers.getPageMeta();
        assertEquals(3, pageMeta.getPageSize());
        assertEquals(0, pageMeta.getTotalPages());
        assertEquals(0L, pageMeta.getTotalElements());
        verify(sellerRepository).findAll(Mockito.<Specification<Seller>>any());
        verify(page, atLeast(1)).getPage();
        verify(page, atLeast(1)).getSize();
        verify(page).setPage(anyInt());
        verify(page).setSize(anyInt());
    }

    /**
     * Method under test: {@link SellerService#groupSellers(List)}
     */
    @Test
    void testGroupSellers() {
        assertTrue(sellerService.groupSellers(new ArrayList<>()).isEmpty());
    }

    /**
     * Method under test: {@link SellerService#groupSellers(List)}
     */
    @Test
    void testGroupSellers2() {
        Producer producer = new Producer();
        producer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        producer.setId(UUID.randomUUID());
        producer.setName("Name");

        Marketplace marketplace = new Marketplace();
        marketplace.setDescription("The characteristics of someone or something");
        marketplace.setId("42");

        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setCountry("GB");
        sellerInfo.setExternalId("42");
        sellerInfo.setId(UUID.randomUUID());
        sellerInfo.setMarketplace(marketplace);
        sellerInfo.setName("Name");
        sellerInfo.setUrl("https://example.org/example");

        Seller seller = new Seller();
        seller.setId(UUID.randomUUID());
        seller.setProducer(producer);
        seller.setSellerInfo(sellerInfo);
        seller.setState(SellerState.GREYLIST);

        ArrayList<Seller> sellers = new ArrayList<>();
        sellers.add(seller);
        List<SellerInfoDTO> actualGroupSellersResult = sellerService.groupSellers(sellers);
        assertEquals(1, actualGroupSellersResult.size());
        SellerInfoDTO getResult = actualGroupSellersResult.get(0);
        assertEquals("42", getResult.getExternalId());
        assertEquals("Name", getResult.getSellerName());
        List<ProducerSellerStateDTO> producerSellerStates = getResult.getProducerSellerStates();
        assertEquals(1, producerSellerStates.size());
        assertEquals("42", getResult.getMarketplaceId());
        ProducerSellerStateDTO getResult2 = producerSellerStates.get(0);
        assertEquals("GREYLIST", getResult2.getSellerState());
        assertEquals("Name", getResult2.getProducerName());
    }

    /**
     * Method under test: {@link SellerService#groupSellers(List)}
     */
    @Test
    void testGroupSellers3() {
        Producer producer = new Producer();
        producer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        producer.setId(UUID.randomUUID());
        producer.setName("Name");

        Marketplace marketplace = new Marketplace();
        marketplace.setDescription("The characteristics of someone or something");
        marketplace.setId("42");

        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setCountry("GB");
        sellerInfo.setExternalId("42");
        sellerInfo.setId(UUID.randomUUID());
        sellerInfo.setMarketplace(marketplace);
        sellerInfo.setName("Name");
        sellerInfo.setUrl("https://example.org/example");

        Seller seller = new Seller();
        seller.setId(UUID.randomUUID());
        seller.setProducer(producer);
        seller.setSellerInfo(sellerInfo);
        seller.setState(SellerState.GREYLIST);

        Producer producer2 = new Producer();
        producer2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        producer2.setId(UUID.randomUUID());
        producer2.setName("com.sentryc.selleraggregationapi.entity.Producer");

        Marketplace marketplace2 = new Marketplace();
        marketplace2.setDescription("Description");
        marketplace2.setId("Id");

        SellerInfo sellerInfo2 = new SellerInfo();
        sellerInfo2.setCountry("GBR");
        sellerInfo2.setExternalId("External Id");
        sellerInfo2.setId(UUID.randomUUID());
        sellerInfo2.setMarketplace(marketplace2);
        sellerInfo2.setName("com.sentryc.selleraggregationapi.entity.SellerInfo");
        sellerInfo2.setUrl("Url");

        Seller seller2 = new Seller();
        seller2.setId(UUID.randomUUID());
        seller2.setProducer(producer2);
        seller2.setSellerInfo(sellerInfo2);
        seller2.setState(SellerState.BLOCKLISTED);

        ArrayList<Seller> sellers = new ArrayList<>();
        sellers.add(seller2);
        sellers.add(seller);
        List<SellerInfoDTO> actualGroupSellersResult = sellerService.groupSellers(sellers);
        assertEquals(2, actualGroupSellersResult.size());
        SellerInfoDTO getResult = actualGroupSellersResult.get(0);
        assertEquals("Name", getResult.getSellerName());
        SellerInfoDTO getResult2 = actualGroupSellersResult.get(1);
        assertEquals("com.sentryc.selleraggregationapi.entity.SellerInfo", getResult2.getSellerName());
        List<ProducerSellerStateDTO> producerSellerStates = getResult2.getProducerSellerStates();
        assertEquals(1, producerSellerStates.size());
        assertEquals("Id", getResult2.getMarketplaceId());
        assertEquals("42", getResult.getExternalId());
        assertEquals("External Id", getResult2.getExternalId());
        List<ProducerSellerStateDTO> producerSellerStates2 = getResult.getProducerSellerStates();
        assertEquals(1, producerSellerStates2.size());
        assertEquals("42", getResult.getMarketplaceId());
        ProducerSellerStateDTO getResult3 = producerSellerStates2.get(0);
        assertEquals("GREYLIST", getResult3.getSellerState());
        ProducerSellerStateDTO getResult4 = producerSellerStates.get(0);
        assertEquals("BLOCKLISTED", getResult4.getSellerState());
        assertEquals("com.sentryc.selleraggregationapi.entity.Producer", getResult4.getProducerName());
        assertEquals("Name", getResult3.getProducerName());
    }

    /**
     * Method under test: {@link SellerService#groupSellers(List)}
     */
    @Test
    void testGroupSellers4() {
        Producer producer = new Producer();
        producer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        producer.setId(UUID.randomUUID());
        producer.setName("Name");

        Marketplace marketplace = new Marketplace();
        marketplace.setDescription("The characteristics of someone or something");
        marketplace.setId("42");

        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setCountry("GB");
        sellerInfo.setExternalId("42");
        sellerInfo.setId(UUID.randomUUID());
        sellerInfo.setMarketplace(marketplace);
        sellerInfo.setName("Name");
        sellerInfo.setUrl("https://example.org/example");

        Marketplace marketplace2 = new Marketplace();
        marketplace2.setDescription("The characteristics of someone or something");
        marketplace2.setId("42");

        SellerInfo sellerInfo2 = new SellerInfo();
        sellerInfo2.setCountry("GB");
        sellerInfo2.setExternalId("42");
        sellerInfo2.setId(UUID.randomUUID());
        sellerInfo2.setMarketplace(marketplace2);
        sellerInfo2.setName("Name");
        sellerInfo2.setUrl("https://example.org/example");

        Producer producer2 = new Producer();
        producer2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        producer2.setId(UUID.randomUUID());
        producer2.setName("Name");
        Seller seller = mock(Seller.class);
        when(seller.getProducer()).thenReturn(producer2);
        when(seller.getState()).thenReturn(SellerState.GREYLIST);
        when(seller.getSellerInfo()).thenReturn(sellerInfo2);
        doNothing().when(seller).setId(Mockito.<UUID>any());
        doNothing().when(seller).setProducer(Mockito.<Producer>any());
        doNothing().when(seller).setSellerInfo(Mockito.<SellerInfo>any());
        doNothing().when(seller).setState(Mockito.<SellerState>any());
        seller.setId(UUID.randomUUID());
        seller.setProducer(producer);
        seller.setSellerInfo(sellerInfo);
        seller.setState(SellerState.GREYLIST);

        ArrayList<Seller> sellers = new ArrayList<>();
        sellers.add(seller);
        List<SellerInfoDTO> actualGroupSellersResult = sellerService.groupSellers(sellers);
        assertEquals(1, actualGroupSellersResult.size());
        SellerInfoDTO getResult = actualGroupSellersResult.get(0);
        assertEquals("42", getResult.getExternalId());
        assertEquals("Name", getResult.getSellerName());
        List<ProducerSellerStateDTO> producerSellerStates = getResult.getProducerSellerStates();
        assertEquals(1, producerSellerStates.size());
        assertEquals("42", getResult.getMarketplaceId());
        ProducerSellerStateDTO getResult2 = producerSellerStates.get(0);
        assertEquals("GREYLIST", getResult2.getSellerState());
        assertEquals("Name", getResult2.getProducerName());
        verify(seller).getState();
        verify(seller, atLeast(1)).getProducer();
        verify(seller, atLeast(1)).getSellerInfo();
        verify(seller).setId(Mockito.<UUID>any());
        verify(seller).setProducer(Mockito.<Producer>any());
        verify(seller).setSellerInfo(Mockito.<SellerInfo>any());
        verify(seller).setState(Mockito.<SellerState>any());
    }

    /**
     * Method under test: {@link SellerService#groupSellers(List)}
     */
    @Test
    void testGroupSellers5() {
        Producer producer = new Producer();
        producer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        producer.setId(UUID.randomUUID());
        producer.setName("Name");

        Marketplace marketplace = new Marketplace();
        marketplace.setDescription("The characteristics of someone or something");
        marketplace.setId("42");

        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setCountry("GB");
        sellerInfo.setExternalId("42");
        sellerInfo.setId(UUID.randomUUID());
        sellerInfo.setMarketplace(marketplace);
        sellerInfo.setName("Name");
        sellerInfo.setUrl("https://example.org/example");

        Marketplace marketplace2 = new Marketplace();
        marketplace2.setDescription("The characteristics of someone or something");
        marketplace2.setId("42");

        SellerInfo sellerInfo2 = new SellerInfo();
        sellerInfo2.setCountry("GB");
        sellerInfo2.setExternalId("42");
        sellerInfo2.setId(UUID.randomUUID());
        sellerInfo2.setMarketplace(marketplace2);
        sellerInfo2.setName("Name");
        sellerInfo2.setUrl("https://example.org/example");
        Seller seller = mock(Seller.class);
        when(seller.getProducer()).thenThrow(new IllegalArgumentException("foo"));
        when(seller.getState()).thenReturn(SellerState.GREYLIST);
        when(seller.getSellerInfo()).thenReturn(sellerInfo2);
        doNothing().when(seller).setId(Mockito.<UUID>any());
        doNothing().when(seller).setProducer(Mockito.<Producer>any());
        doNothing().when(seller).setSellerInfo(Mockito.<SellerInfo>any());
        doNothing().when(seller).setState(Mockito.<SellerState>any());
        seller.setId(UUID.randomUUID());
        seller.setProducer(producer);
        seller.setSellerInfo(sellerInfo);
        seller.setState(SellerState.GREYLIST);

        ArrayList<Seller> sellers = new ArrayList<>();
        sellers.add(seller);
        assertThrows(IllegalArgumentException.class, () -> sellerService.groupSellers(sellers));
        verify(seller).getState();
        verify(seller).getProducer();
        verify(seller, atLeast(1)).getSellerInfo();
        verify(seller).setId(Mockito.<UUID>any());
        verify(seller).setProducer(Mockito.<Producer>any());
        verify(seller).setSellerInfo(Mockito.<SellerInfo>any());
        verify(seller).setState(Mockito.<SellerState>any());
    }

    /**
     * Method under test: {@link SellerService#groupSellers(List)}
     */
    @Test
    void testGroupSellers6() {
        Producer producer = new Producer();
        producer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        producer.setId(UUID.randomUUID());
        producer.setName("Name");

        Marketplace marketplace = new Marketplace();
        marketplace.setDescription("The characteristics of someone or something");
        marketplace.setId("42");

        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setCountry("GB");
        sellerInfo.setExternalId("42");
        sellerInfo.setId(UUID.randomUUID());
        sellerInfo.setMarketplace(marketplace);
        sellerInfo.setName("Name");
        sellerInfo.setUrl("https://example.org/example");

        Marketplace marketplace2 = new Marketplace();
        marketplace2.setDescription("The characteristics of someone or something");
        marketplace2.setId("42");

        SellerInfo sellerInfo2 = new SellerInfo();
        sellerInfo2.setCountry("GB");
        sellerInfo2.setExternalId("42");
        sellerInfo2.setId(UUID.randomUUID());
        sellerInfo2.setMarketplace(marketplace2);
        sellerInfo2.setName("Name");
        sellerInfo2.setUrl("https://example.org/example");

        Producer producer2 = new Producer();
        producer2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        producer2.setId(UUID.randomUUID());
        producer2.setName("Name");
        Seller seller = mock(Seller.class);
        when(seller.getProducer()).thenReturn(producer2);
        when(seller.getState()).thenReturn(SellerState.GREYLIST);
        when(seller.getSellerInfo()).thenReturn(sellerInfo2);
        doNothing().when(seller).setId(Mockito.<UUID>any());
        doNothing().when(seller).setProducer(Mockito.<Producer>any());
        doNothing().when(seller).setSellerInfo(Mockito.<SellerInfo>any());
        doNothing().when(seller).setState(Mockito.<SellerState>any());
        seller.setId(UUID.randomUUID());
        seller.setProducer(producer);
        seller.setSellerInfo(sellerInfo);
        seller.setState(SellerState.GREYLIST);

        Producer producer3 = new Producer();
        producer3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        producer3.setId(UUID.randomUUID());
        producer3.setName("Name");

        Marketplace marketplace3 = new Marketplace();
        marketplace3.setDescription("The characteristics of someone or something");
        marketplace3.setId("42");

        SellerInfo sellerInfo3 = new SellerInfo();
        sellerInfo3.setCountry("GB");
        sellerInfo3.setExternalId("42");
        sellerInfo3.setId(UUID.randomUUID());
        sellerInfo3.setMarketplace(marketplace3);
        sellerInfo3.setName("Name");
        sellerInfo3.setUrl("https://example.org/example");

        Seller seller2 = new Seller();
        seller2.setId(UUID.randomUUID());
        seller2.setProducer(producer3);
        seller2.setSellerInfo(sellerInfo3);
        seller2.setState(SellerState.GREYLIST);

        ArrayList<Seller> sellers = new ArrayList<>();
        sellers.add(seller2);
        sellers.add(seller);
        List<SellerInfoDTO> actualGroupSellersResult = sellerService.groupSellers(sellers);
        assertEquals(1, actualGroupSellersResult.size());
        SellerInfoDTO getResult = actualGroupSellersResult.get(0);
        assertEquals("42", getResult.getExternalId());
        assertEquals("Name", getResult.getSellerName());
        List<ProducerSellerStateDTO> producerSellerStates = getResult.getProducerSellerStates();
        assertEquals(2, producerSellerStates.size());
        assertEquals("42", getResult.getMarketplaceId());
        ProducerSellerStateDTO getResult2 = producerSellerStates.get(1);
        assertEquals("GREYLIST", getResult2.getSellerState());
        ProducerSellerStateDTO getResult3 = producerSellerStates.get(0);
        assertEquals("GREYLIST", getResult3.getSellerState());
        assertEquals("Name", getResult3.getProducerName());
        assertEquals("Name", getResult2.getProducerName());
        verify(seller).getState();
        verify(seller, atLeast(1)).getProducer();
        verify(seller, atLeast(1)).getSellerInfo();
        verify(seller).setId(Mockito.<UUID>any());
        verify(seller).setProducer(Mockito.<Producer>any());
        verify(seller).setSellerInfo(Mockito.<SellerInfo>any());
        verify(seller).setState(Mockito.<SellerState>any());
    }

    /**
     * Method under test: {@link SellerService#groupSellers(List)}
     */
    @Test
    void testGroupSellers7() {
        Producer producer = new Producer();
        producer.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        producer.setId(UUID.randomUUID());
        producer.setName("Name");

        Marketplace marketplace = new Marketplace();
        marketplace.setDescription("The characteristics of someone or something");
        marketplace.setId("42");

        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setCountry("GB");
        sellerInfo.setExternalId("42");
        sellerInfo.setId(UUID.randomUUID());
        sellerInfo.setMarketplace(marketplace);
        sellerInfo.setName("Name");
        sellerInfo.setUrl("https://example.org/example");

        Marketplace marketplace2 = new Marketplace();
        marketplace2.setDescription("The characteristics of someone or something");
        marketplace2.setId("42");

        Marketplace marketplace3 = new Marketplace();
        marketplace3.setDescription("The characteristics of someone or something");
        marketplace3.setId("42");
        SellerInfo sellerInfo2 = mock(SellerInfo.class);
        when(sellerInfo2.getName()).thenThrow(new IllegalArgumentException("foo"));
        when(sellerInfo2.getMarketplace()).thenReturn(marketplace3);
        when(sellerInfo2.getExternalId()).thenReturn("42");
        doNothing().when(sellerInfo2).setCountry(Mockito.<String>any());
        doNothing().when(sellerInfo2).setExternalId(Mockito.<String>any());
        doNothing().when(sellerInfo2).setId(Mockito.<UUID>any());
        doNothing().when(sellerInfo2).setMarketplace(Mockito.<Marketplace>any());
        doNothing().when(sellerInfo2).setName(Mockito.<String>any());
        doNothing().when(sellerInfo2).setUrl(Mockito.<String>any());
        sellerInfo2.setCountry("GB");
        sellerInfo2.setExternalId("42");
        sellerInfo2.setId(UUID.randomUUID());
        sellerInfo2.setMarketplace(marketplace2);
        sellerInfo2.setName("Name");
        sellerInfo2.setUrl("https://example.org/example");
        Seller seller = mock(Seller.class);
        when(seller.getSellerInfo()).thenReturn(sellerInfo2);
        doNothing().when(seller).setId(Mockito.<UUID>any());
        doNothing().when(seller).setProducer(Mockito.<Producer>any());
        doNothing().when(seller).setSellerInfo(Mockito.<SellerInfo>any());
        doNothing().when(seller).setState(Mockito.<SellerState>any());
        seller.setId(UUID.randomUUID());
        seller.setProducer(producer);
        seller.setSellerInfo(sellerInfo);
        seller.setState(SellerState.GREYLIST);

        ArrayList<Seller> sellers = new ArrayList<>();
        sellers.add(seller);
        Producer producer2 = mock(Producer.class);
        doNothing().when(producer2).setCreatedAt(Mockito.<LocalDateTime>any());
        doNothing().when(producer2).setId(Mockito.<UUID>any());
        doNothing().when(producer2).setName(Mockito.<String>any());
        producer2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        producer2.setId(UUID.randomUUID());
        producer2.setName("Name");
        assertThrows(IllegalArgumentException.class, () -> sellerService.groupSellers(sellers));
        verify(seller, atLeast(1)).getSellerInfo();
        verify(seller).setId(Mockito.<UUID>any());
        verify(seller).setProducer(Mockito.<Producer>any());
        verify(seller).setSellerInfo(Mockito.<SellerInfo>any());
        verify(seller).setState(Mockito.<SellerState>any());
        verify(producer2).setCreatedAt(Mockito.<LocalDateTime>any());
        verify(producer2).setId(Mockito.<UUID>any());
        verify(producer2).setName(Mockito.<String>any());
        verify(sellerInfo2).getMarketplace();
        verify(sellerInfo2).getExternalId();
        verify(sellerInfo2).getName();
        verify(sellerInfo2).setCountry(Mockito.<String>any());
        verify(sellerInfo2).setExternalId(Mockito.<String>any());
        verify(sellerInfo2).setId(Mockito.<UUID>any());
        verify(sellerInfo2).setMarketplace(Mockito.<Marketplace>any());
        verify(sellerInfo2).setName(Mockito.<String>any());
        verify(sellerInfo2).setUrl(Mockito.<String>any());
    }
}

