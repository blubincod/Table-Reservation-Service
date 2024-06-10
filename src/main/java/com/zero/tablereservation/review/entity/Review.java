package com.zero.tablereservation.review.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    String content; // 내용
    LocalDateTime createdAt; // 작성 일자

    long storeId; // 매장 아이디
    String userId; // 사용자 아이디

}
