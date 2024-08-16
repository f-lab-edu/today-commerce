package com.example.today_commerce.user.domain;

import com.example.today_commerce.order.domain.Order;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String email;       // 이메일
    private String name;        // 이름
    private String phone;       // 전화번호
    private String password;    // 비밀번호
    private String userType;    // 사용자 유형(일반 사용자, 판매자)

    // 읽기전용
    @OneToMany(mappedBy="user")
    private List<Order> orders = new ArrayList<>();

}
