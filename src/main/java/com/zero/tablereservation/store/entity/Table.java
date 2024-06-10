package com.zero.tablereservation.store.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Table implements TableStatus{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id; //테이블 아이디

    String status; //테이블 가능 여부(예약 가능, 예약 불가능)

}
