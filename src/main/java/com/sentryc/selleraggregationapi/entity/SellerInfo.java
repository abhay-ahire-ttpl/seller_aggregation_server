package com.sentryc.selleraggregationapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "seller_info")
public class SellerInfo {

    @Id
    private UUID id;

    private String name;

    private String url;

    private String country;

    @ManyToOne
    @JoinColumn(name = "marketplace_id", referencedColumnName = "id")
    private Marketplace marketplace;

    @Column(name = "external_id")
    private String externalId;
}
