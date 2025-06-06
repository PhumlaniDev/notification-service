package com.phumlanidev.notificationservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {
  private String name;
  private String description;
  private BigDecimal price;
  private String imageUrl;
}