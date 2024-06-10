package com.zero.tablereservation.member.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "member")
public class Member {

    @Id
    private String userId; // 사용자 아이디

    private String username; // 사용자 이름

    private String password; //비밀번호

    private String phone; // 전화번호

    private boolean isManager; // 매니저/점장 여부 (default: false)

    private LocalDateTime regDt; 
}
