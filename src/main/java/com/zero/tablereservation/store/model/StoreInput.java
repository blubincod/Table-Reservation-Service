package com.zero.tablereservation.store.model;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class StoreInput {
    private Long id;
    private String name; //매장 이름
    private Double latitude; //위도
    private Double longitude; //경도
    private Integer tableAmount; //테이블 수
    private String description; //매장 설명
}
