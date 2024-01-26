package com.example.demo.service.implement;

import com.example.demo.constant.MessageResponse;
import com.example.demo.dao.TagFinanceDAO;
import com.example.demo.data.dto.Request.TagfinanceRequestDTO;
import com.example.demo.data.dto.Response.BaseResponse;
import com.example.demo.data.dto.Response.TagFinanceResponseDTO;
import com.example.demo.data.entity.TagFinance;
import com.example.demo.service.TagFinanceService;
import org.springframework.stereotype.Service;

@Service
public class TagFinanceServiceImpl implements TagFinanceService {
    private final TagFinanceDAO tagFinanceDAO;

    public TagFinanceServiceImpl(TagFinanceDAO tagFinanceDAO) {
        this.tagFinanceDAO = tagFinanceDAO;
    }

    @Override
    public BaseResponse createTag(TagfinanceRequestDTO tagfinanceRequestDTO) throws Exception {
        TagFinance tagReqest = new TagFinance(tagfinanceRequestDTO);
        return new BaseResponse(MessageResponse.Tag_Information, new TagFinanceResponseDTO(tagFinanceDAO.createTagFinance(tagReqest)));
    }

    @Override
    public BaseResponse updateTag(TagfinanceRequestDTO tagfinanceRequestD, int Id) throws Exception {
        return null;
    }

    @Override
    public BaseResponse deleteTag(TagfinanceRequestDTO tagfinanceRequest, int Id) throws Exception {
        return null;
    }

    @Override
    public BaseResponse getTag(TagfinanceRequestDTO tagfinanceRequest) throws Exception {
        return null;
    }
}
