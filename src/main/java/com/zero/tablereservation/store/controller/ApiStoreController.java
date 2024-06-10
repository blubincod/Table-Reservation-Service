package com.zero.tablereservation.store.controller;

import com.zero.tablereservation.store.model.ReservationInput;
import com.zero.tablereservation.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RequiredArgsConstructor
@RestController
public class ApiStoreController {

    private final StoreService storeService;

    /**
     * 예약 요청
     */
    @PostMapping("/api/store/reservation")
    public ResponseEntity<?> storeReservation(
            @RequestBody ReservationInput parameter,
            Principal principal) {

        // 현재 로그인 된 아이디 등록
        parameter.setUserId(principal.getName());

        // 예약 테이블에 예약 정보 저장
        boolean result = storeService.reserve(parameter);

        if (!result) {
            return ResponseEntity.badRequest().body("예약을 실패하였습니다.");
        }

        //예약 요청을 받은 후 JSON 형태로 응답
        return ResponseEntity.ok().body(parameter);
    }

    /**
     * 예약자 도착 확인
     */

}
