package com.zero.tablereservation.member.controller;


import com.zero.tablereservation.member.model.MemberInput;
import com.zero.tablereservation.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    /**
     * 로그인
     */
    @RequestMapping("/member/login")
    public String login() {
        return "member/login";
    }

    /**
     * 회원가입
     */
    @GetMapping("/member/signup")
    public String signup() {

        return "member/signup";
    }

    @PostMapping("/member/signup")
    public String signupSubmit(Model model, HttpServletRequest request
            , MemberInput memberInput) {

        boolean result = memberService.signup(memberInput);
        model.addAttribute("result", result);

        return "member/signup_complete";
    }


    /**
     * 회원탈퇴
     */
    @GetMapping("/member/withdraw")
    public String memberWithdraw(Model model) {

        return "member/withdraw";
    }

}
