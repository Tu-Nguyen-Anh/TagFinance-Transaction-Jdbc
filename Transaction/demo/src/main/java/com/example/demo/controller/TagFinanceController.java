package com.example.demo.controller;

import com.example.demo.data.dto.Request.TagfinanceRequestDTO;
import com.example.demo.data.dto.Response.BaseResponse;
import com.example.demo.service.TagFinanceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/TagFinance/controller")
public class TagFinanceController {
    private final TagFinanceService tagFinanceService;

    public TagFinanceController(TagFinanceService tagFinanceService) {
        this.tagFinanceService = tagFinanceService;
    }

    @PostMapping("/create")
    public BaseResponse createTagFinance(@RequestBody TagfinanceRequestDTO tagFinanceRequestDTO) throws Exception {
        return tagFinanceService.createTag(tagFinanceRequestDTO);
    }


}
