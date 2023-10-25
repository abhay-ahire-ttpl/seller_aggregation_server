package com.sentryc.selleraggregationapi.service;

import com.sentryc.selleraggregationapi.dto.*;
import com.sentryc.selleraggregationapi.enam.SellerSortBy;
import com.sentryc.selleraggregationapi.entity.Seller;
import com.sentryc.selleraggregationapi.repository.SellerRepository;
import com.sentryc.selleraggregationapi.response.SellerPageableResponse;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SellerService {

    private final SellerRepository sellerRepository;


    @Autowired
    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public SellerPageableResponse getSellers(SellerFilterDTO filter, PageInputDTO page, SellerSortBy sortBy) {

        Specification<Seller> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.isNotBlank(filter.getSearchByName())) {
                predicates.add(criteriaBuilder.like(root.get("sellerInfo").get("name"), "%" + filter.getSearchByName() + "%"));
            }
            if (filter.getProducerIds() != null && !filter.getProducerIds().isEmpty()) {
                predicates.add(root.get("producer").get("id").in(filter.getProducerIds()));
            }
            if (filter.getMarketplaceIds() != null && !filter.getMarketplaceIds().isEmpty()) {
                predicates.add(root.get("sellerInfo").get("marketplace").get("id").in(filter.getMarketplaceIds()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        List<Seller> sellers = sellerRepository.findAll(specification);
        List<SellerInfoDTO> sellerRecordList = groupSellers(sellers);
        int start = page.getPage() * page.getSize();
        int end = Math.min(start + page.getSize(), sellerRecordList.size());
        List<SellerInfoDTO> sellerInfoResponseDTOListPageable = sellerRecordList.subList(start, end);
        List<SellerInfoDTO> sellerInfoSortedListPageable = getSortedList(sellerInfoResponseDTOListPageable,sortBy);
        PageImpl<SellerInfoDTO> pageable =
                new PageImpl<>(sellerInfoSortedListPageable, PageRequest.of(page.getPage(), page.getSize()), sellerRecordList.size());
        SellerPageableResponse sellerPageableResponse = new SellerPageableResponse();
        PageMetaDTO pageMetaDTO = new PageMetaDTO(page.getPage(), pageable.getSize(), pageable.getTotalElements());
        sellerPageableResponse.setData(pageable.getContent());
        sellerPageableResponse.setMeta(pageMetaDTO);
        return sellerPageableResponse;
    }

    private List<SellerInfoDTO> getSortedList (List<SellerInfoDTO> sellerInfoResponseDTOListPageable, SellerSortBy sortBy) {
        switch (sortBy) {
            case SELLER_INFO_EXTERNAL_ID_ASC -> sellerInfoResponseDTOListPageable.sort(Comparator.comparing(SellerInfoDTO::getExternalId));
            case SELLER_INFO_EXTERNAL_ID_DESC -> sellerInfoResponseDTOListPageable.sort(Comparator.comparing(SellerInfoDTO::getExternalId).reversed());
            case NAME_ASC -> sellerInfoResponseDTOListPageable.sort(Comparator.comparing(SellerInfoDTO::getSellerName));
            case NAME_DESC -> sellerInfoResponseDTOListPageable.sort(Comparator.comparing(SellerInfoDTO::getSellerName).reversed());
            case MARKETPLACE_ID_ASC -> sellerInfoResponseDTOListPageable.sort(Comparator.comparing(SellerInfoDTO::getMarketplaceId));
            case MARKETPLACE_ID_DESC -> sellerInfoResponseDTOListPageable.sort(Comparator.comparing(SellerInfoDTO::getMarketplaceId).reversed());
        }
        return sellerInfoResponseDTOListPageable;
    }

    public List<SellerInfoDTO> groupSellers(List<Seller> sellers) {
        List<SellerInfoDTO> sellerInfoResponseDTOList = new ArrayList<>();

        Map<SellerAndMarketPlaceDTO, List<Seller>> sellerInfoListMap = sellers.stream()
                .collect(Collectors.groupingBy(sellerInfo -> new SellerAndMarketPlaceDTO(sellerInfo.getSellerInfo()
                        .getExternalId(), sellerInfo.getSellerInfo()
                        .getMarketplace().getId(), sellerInfo.getSellerInfo().getName())));
        sellerInfoListMap.forEach((sellerAndMarketPlace, sellersList) -> {
            SellerInfoDTO sellerInfoResponseDTO = new SellerInfoDTO();
            sellerInfoResponseDTO.setSellerName(sellerAndMarketPlace.getName());
            sellerInfoResponseDTO.setExternalId(sellerAndMarketPlace.getExternalId());
            sellerInfoResponseDTO.setMarketplaceId(sellerAndMarketPlace.getMarketPlaceId());

            List<ProducerSellerStateDTO> producerSellerStateDTOList = new ArrayList<>();
            sellersList.forEach(seller -> {
                ProducerSellerStateDTO producerSellerStateDTO = new ProducerSellerStateDTO();
                producerSellerStateDTO.setSellerId(seller.getSellerInfo().getId().toString());
                producerSellerStateDTO.setSellerState(seller.getState().name());
                producerSellerStateDTO.setProducerName(seller.getProducer().getName());
                producerSellerStateDTO.setProducerId(seller.getProducer().getId().toString());
                producerSellerStateDTOList.add(producerSellerStateDTO);
            });
            sellerInfoResponseDTO.setProducerSellerStates(producerSellerStateDTOList);
            sellerInfoResponseDTOList.add(sellerInfoResponseDTO);
        });

        return sellerInfoResponseDTOList;
    }

}