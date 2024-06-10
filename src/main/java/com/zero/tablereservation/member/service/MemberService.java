package com.zero.tablereservation.member.service;

import com.zero.tablereservation.member.model.MemberInput;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {

    boolean signup(MemberInput parameter);

}

