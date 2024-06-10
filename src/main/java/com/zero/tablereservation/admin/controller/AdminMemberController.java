package com.zero.tablereservation.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminMemberController {

    /**
     * 회원 관리
     */
    @GetMapping("/admin/member/list.do")
    public String member(){

        return "admin/member/list";
    }

}
