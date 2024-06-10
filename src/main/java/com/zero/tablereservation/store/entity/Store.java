package com.zero.tablereservation.store.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; //매장 이름

    private Double latitude; //위도
    private Double longitude; //경도

//    private Double rating; // 별점

    private Integer tableAmount; //매장 테이블 수
    private String description; //매장 설명

}
