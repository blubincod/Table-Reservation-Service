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
    private String userId;

    private String username;

    private String password;

    private String phone;

    private boolean isManager;

    private LocalDateTime regDt;
}
