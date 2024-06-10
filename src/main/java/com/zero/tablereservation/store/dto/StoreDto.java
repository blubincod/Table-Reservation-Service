package com.zero.tablereservation.store.dto;

import com.zero.tablereservation.store.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StoreDto {

    Long id;
    String name; //매장 이름
    Double latitude; //위도
    Double longitude; //경도
    Integer tableAmount; //테이블 수
    String description; //매장 설명

    public static StoreDto of(Store store) {
        return StoreDto.builder()
                .id(store.getId())
                .name(store.getName())
                .latitude(store.getLatitude())
                .longitude(store.getLongitude())
                .tableAmount(store.getTableAmount())
                .description(store.getDescription())
                .build();

    }
}
