package com.sentryc.selleraggregationapi.entity;

import com.sentryc.selleraggregationapi.enam.SellerState;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "sellers")
public class Seller {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "producer_id", referencedColumnName = "id")
    private Producer producer;

    @ManyToOne
    @JoinColumn(name = "seller_info_id", referencedColumnName = "id")
    private SellerInfo sellerInfo;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private SellerState state;

}
