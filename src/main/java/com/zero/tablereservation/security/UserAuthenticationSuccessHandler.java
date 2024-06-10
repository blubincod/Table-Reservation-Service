package com.zero.tablereservation.security;

import com.zero.tablereservation.member.repository.MemberRepository;
import com.zero.tablereservation.member.service.MemberService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class UserAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    public UserAuthenticationSuccessHandler(MemberRepository memberRepository, MemberService memberService) {
        this.memberRepository = memberRepository;
        this.memberService = memberService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails) principal;


        System.out.println("로그인에 성공하였습니다.");

        String userId = userDetails.getUsername();
//        String clientIp = RequestUtils.getClientIp(request);
//        String userAgent = RequestUtils.getUserAgent(request);
        LocalDateTime currentTime = LocalDateTime.now();

//        LoginHistory loginHistory = LoginHistory.builder()
//                .userId(userId)
//                .loginDate(currentTime)
//                .clientIp(clientIp)
//                .userAgent(userAgent)
//                .build();
//        loginHistoryRepository.save(loginHistory);
//
//        memberService.updateLastLogin(userId, currentTime);

        super.onAuthenticationSuccess(request, response, authentication);
    }
}

