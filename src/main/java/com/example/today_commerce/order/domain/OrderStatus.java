package com.example.today_commerce.order.domain;

/**
 * 주문 상태
 */
public enum OrderStatus {
    ORDER_COMPLETED, // 주문완료
    ORDER_CANCELED, // 주문취소
    SHIPPING, // 배송중
    DELIVERED, // 배송완료
    RETURN_REQUESTED, // 반품요청
    RETURN_COMPLETED // 반품완료
}
