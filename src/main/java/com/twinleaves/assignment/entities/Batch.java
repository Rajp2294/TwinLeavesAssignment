package com.twinleaves.assignment.entities;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name ="batch")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int batchId;
    
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
    
    @Column(precision = 10, scale = 2)
    private BigDecimal mrp;

    @Column(precision = 10, scale = 2)
    private BigDecimal sp;

    @Column(precision = 10, scale = 2)
    private BigDecimal purchasePrice;

    private int availableQuantity;

    private ZonedDateTime inwardedOn;
}
