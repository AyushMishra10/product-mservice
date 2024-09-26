package com.prj.ms.product.dto;

import java.math.BigDecimal;

/**
 * record class to serve as data carriers
 */
public record ProductRequest(String id, String name, String description, BigDecimal price) {
}
