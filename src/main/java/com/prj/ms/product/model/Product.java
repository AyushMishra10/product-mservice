package com.prj.ms.product.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;


import java.math.BigDecimal;
import java.util.UUID;


@Entity
@NoArgsConstructor @AllArgsConstructor
@Builder @Data
public class Product {

    @Id @Column(nullable = false, unique = true)
    private String id;
    private String name;
    private String description;
    private BigDecimal price;

    /* Used the below declared method to fix
      Identifier of entity  must be manually assigned before calling 'persist()'
     */

    @PrePersist
    public void generateId() {
        this.id = UUID.randomUUID().toString();
    }
}
