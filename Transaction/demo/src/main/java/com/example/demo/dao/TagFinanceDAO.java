package com.example.demo.dao;

import com.example.demo.data.entity.TagFinance;

import java.util.List;

public interface TagFinanceDAO {
    TagFinance createTagFinance(TagFinance tagFinance) throws Exception;
    void updateTagFinance(TagFinance tagFinance, int id) throws Exception;
    List<TagFinance> getAllTagFinance() throws Exception;
    void deleteTagFinance(int id);
}
