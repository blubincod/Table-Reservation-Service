package com.zero.tablereservation.store.repository;

import com.zero.tablereservation.store.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<Table, Long> {

}
