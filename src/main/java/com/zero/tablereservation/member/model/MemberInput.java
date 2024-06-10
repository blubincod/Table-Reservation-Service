package com.zero.tablereservation.member.model;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Data
public class MemberInput {
    private String userId;
    private String username;
    private String password;
    private String rePassword;
    private String phone;
    private LocalDateTime loginDate;
}
