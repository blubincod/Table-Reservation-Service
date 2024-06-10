package com.zero.tablereservation.store.service;

import com.zero.tablereservation.store.dto.StoreDto;
import com.zero.tablereservation.store.entity.Store;
import com.zero.tablereservation.store.model.ReservationInput;
import com.zero.tablereservation.store.model.StoreInput;

import java.util.List;

public interface StoreService {

    /**
     * 매장 등록
     */
    boolean register(StoreInput parameter);

    /**
     *매장 목록
     */
    List<Store> list();

    /**
     * 매장 정보 수정
     */
    boolean set(StoreInput parameter);

    /**
     * 매장 정보 삭제
     */
    boolean del(long id);

    /**
     * 매장 상세 정보
     */
    StoreDto getById(long id);

    /**
     * 테이블 예약
     */
    boolean reserve(ReservationInput parameter);

}
