package com.example.clustered_data_warehouse.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clustered_data_warehouse", uniqueConstraints = {@UniqueConstraint(name = "UniqueIsoCodeAndDealTimeStampAndAmount", columnNames = {"isoCode","dealTimestamp","amount"})})
public class Warehouse {
    @Id
    @SequenceGenerator(
            name = "clustered_data_warehouse_sequence",
            sequenceName = "clustered_data_warehouse_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "clustered_data_warehouse_sequence"
    )
    private Long id;
    private String dealUniqueId;
    private String orderingCurrency;
    private String isoCode;
    private String dealTimestamp;
    private BigDecimal amount;
}
