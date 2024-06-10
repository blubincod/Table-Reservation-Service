package com.zero.tablereservation.store.service;

import com.zero.tablereservation.store.dto.StoreDto;
import com.zero.tablereservation.store.entity.Reservation;
import com.zero.tablereservation.store.entity.Store;
import com.zero.tablereservation.store.model.ReservationInput;
import com.zero.tablereservation.store.model.StoreInput;
import com.zero.tablereservation.store.repository.ReservationRepository;
import com.zero.tablereservation.store.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final ReservationRepository reservationRepository;

    public StoreServiceImpl(StoreRepository storeRepository, ReservationRepository reservationRepository) {
        this.storeRepository = storeRepository;
        this.reservationRepository = reservationRepository;
    }

    /**
     * 매장 등록
     */
    public boolean register(StoreInput parameter) {

        Store store = new Store();
        store.setName(parameter.getName());
        store.setLatitude(parameter.getLatitude());
        store.setLongitude(parameter.getLongitude());
        store.setTableAmount(parameter.getTableAmount());
        store.setDescription(parameter.getDescription());
        storeRepository.save(store);

        return true;
    }

    /**
     * 매장 목록
     */
    @Override
    public List<Store> list() {

        return storeRepository.findAll();
    }

    /**
     * 매장 정보 수정
     */
    @Override
    public boolean set(StoreInput parameter) {

        Optional<Store> optionalStore = storeRepository.findById(parameter.getId());
        // 매장 존재 여부 확인
        if (!optionalStore.isPresent()) {
            return false;
        }

        Store store = optionalStore.get();
        store.setName(parameter.getName());
        store.setLatitude(parameter.getLatitude());
        store.setLongitude(parameter.getLongitude());
        store.setTableAmount(parameter.getTableAmount());
        store.setDescription(parameter.getDescription());
        storeRepository.save(store);

        return true;
    }

    /**
     * 매장 삭제
     */
    @Override
    public boolean del(String idList) {

        if (idList != null && idList.length() > 0) {
            String[] ids = idList.split(",");
            for (String x : ids) {
                long id = 0L;
                try {
                    id = Long.parseLong(x);
                } catch (Exception e) {
                }

                if (id > 0) {
                    storeRepository.deleteById(id);
                }
            }
        }

        return true;
    }

    /**
     * 매장 상세 정보
     */
    @Override
    public StoreDto getById(long id) {

        return storeRepository.findById(id).map(StoreDto::of).orElse(null);
    }

    /**
     * 매장 예약
     */
    @Override
    public boolean reserve(ReservationInput parameter) {

        Optional<Store> optionalStore = storeRepository.findById(parameter.getStoreId());
        if(!optionalStore.isPresent()){
            return false;
        }

        Store store = optionalStore.get();

        Reservation reservation = Reservation.builder()
                .storeId(store.getId())
                .tableId(parameter.getTableId())
                .userId(parameter.getUserId())
                .reservedDt(parameter.getReservedDt())
                .build();
        reservationRepository.save(reservation);

        return true;
    }


}
