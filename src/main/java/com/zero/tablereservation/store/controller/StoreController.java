package com.zero.tablereservation.store.controller;

import com.zero.tablereservation.store.dto.StoreDto;
import com.zero.tablereservation.store.entity.Store;
import com.zero.tablereservation.store.model.StoreInput;
import com.zero.tablereservation.store.model.StoreParam;
import com.zero.tablereservation.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class StoreController {

    private final StoreService storeService;

    /**
     * 매장 목록
     */
    @GetMapping("/store/list")
    public String storeList(Model model) {

        List<Store> storeList = storeService.list();

        // template에 storeList 전달
        model.addAttribute("list", storeList);

        return "store/list";
    }

    /**
     * 매장 상세 페이지
     */
    @GetMapping("/store/{id}")
    public String storeDetail(Model model, StoreParam parameter) {

        StringBuilder sb = new StringBuilder();

        StoreDto detail = storeService.getById(parameter.getId());
        model.addAttribute("detail", detail);

        return "store/detail";
    }

    /**
     * 매장 등록 및 수정
     * GET
     */
    @GetMapping(value = {"/store/register", "/store/edit"})
    public String register(Model model, HttpServletRequest request, StoreInput parameter) {

        boolean editMode = request.getRequestURI().contains("/edit");
        StoreDto detail = new StoreDto();

        // 매장 정보 수정
        if (editMode) {
            long id = parameter.getId();
            StoreDto existStore = storeService.getById(id);

            // 매장 정보 없을 경우 에러처리
            if (existStore == null) {
                model.addAttribute("message", "매장정보가 존재하지 않습니다.");
                return "error/notFound";
            }
            detail = existStore;
        }

        model.addAttribute("editMode", editMode);
        model.addAttribute("detail", detail);

        return "store/register";
    }


    /**
     * 매장 등록 및 수정
     * POST
     */
    @PostMapping(value = {"/store/register", "/store/edit"})
    public String registerSubmit(Model model, HttpServletRequest request, StoreInput parameter) {

        boolean editMode = request.getRequestURI().contains("/edit");

        if (editMode) {
            long id = parameter.getId();
            StoreDto existStore = storeService.getById(id);

            // 매장 정보 없을 경우 에러처리
            if (existStore == null) {
                model.addAttribute("message", "매장정보가 존재하지 않습니다.");
                return "error/notFound";
            }
            boolean result = storeService.set(parameter);

        } else {
            boolean result = storeService.register(parameter);
        }

        return "redirect:/store/list";
    }

    /**
     * 매장 삭제
     */
    @PostMapping("/store/delete")
    public String del(StoreInput parameter) {

        System.out.println(parameter.getId());
        boolean result = storeService.del(parameter.getId());

        return "redirect:/store/list";
    }
}
