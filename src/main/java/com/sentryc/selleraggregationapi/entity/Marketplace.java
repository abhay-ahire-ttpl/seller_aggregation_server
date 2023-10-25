package com.sentryc.selleraggregationapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "marketplaces")
public class Marketplace {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "description")
    private String description;

}
