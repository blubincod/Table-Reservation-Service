package com.zero.tablereservation.store.model;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Data
public class ReservationInput {
    Long storeId; //매장 아이디
    Long tableId; //테이블 아이디
    String userId; //사용자 아이디
    LocalDateTime reservedDt; //예약 시간
}
