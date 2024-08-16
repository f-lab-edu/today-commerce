package com.example.today_commerce.product.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Getter;

/**
 * 상품 도메인
 */
@Entity
@Getter
public class Product {

    @Id @GeneratedValue
    @Column(name = "product_id")
    private Long id;

    private String name; // 상품명
    private String description; // 상품 설명
    private int price; // 가격
    private int inventory; // 재고
    private LocalDateTime createdAt; // 등록날짜
    private LocalDateTime updateAt; // 수정날짜
}
