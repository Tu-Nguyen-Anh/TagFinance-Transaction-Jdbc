package com.example.demo.service;

import com.example.demo.data.dto.Request.TagfinanceRequestDTO;
import com.example.demo.data.dto.Response.BaseResponse;

public interface TagFinanceService {
BaseResponse createTag(TagfinanceRequestDTO tagfinanceRequestDTO) throws Exception;
BaseResponse updateTag(TagfinanceRequestDTO tagfinanceRequestDTO, int Id) throws Exception;
BaseResponse deleteTag(TagfinanceRequestDTO tagfinanceRequestDTO, int Id) throws Exception;
BaseResponse getTag(TagfinanceRequestDTO tagfinanceRequestDTO) throws Exception;
}
