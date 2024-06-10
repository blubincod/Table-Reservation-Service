package com.zero.tablereservation.store.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Data
@Entity(name = "reservation")
public class Reservation implements TableStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long storeId; //매장 번호
    String userId; //사용자 아이디
    Long tableId; //테이블 아이디
    LocalDateTime reservedDt; //예약 시간

}
