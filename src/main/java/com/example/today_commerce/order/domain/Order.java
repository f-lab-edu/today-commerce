package com.example.today_commerce.order.domain;

import com.example.today_commerce.user.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 * 주문 도메인
 */
@Entity
@Getter
@Table(name ="orders")
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // 주문 회원

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>(); // 주문 아이템

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // 주문 상태

    private LocalDateTime createdAt; // 주문시간
    private LocalDateTime updateAt; // 주문상태 변경시간
}
