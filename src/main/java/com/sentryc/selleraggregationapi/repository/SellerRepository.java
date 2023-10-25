package com.sentryc.selleraggregationapi.repository;

import com.sentryc.selleraggregationapi.entity.Seller;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SellerRepository extends JpaRepository<Seller, UUID> {
    List<Seller> findAll(Specification<Seller> spec);

}
