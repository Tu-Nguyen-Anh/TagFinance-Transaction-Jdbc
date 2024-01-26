package com.example.demo.service;

import com.example.demo.data.dto.Request.TransactionRequestDTO;
import com.example.demo.data.dto.Response.BaseResponse;

public interface TransactionService {
BaseResponse createTransaction(TransactionRequestDTO transactionRequestDTO) throws Exception;
BaseResponse updateTransaction(TransactionRequestDTO transactionRequestDTO, int tagId) throws Exception;
BaseResponse deleteTransaction(TransactionRequestDTO transactionRequestDTO, int tagId) throws Exception;
BaseResponse getTransaction(TransactionRequestDTO transactionRequestDTO) throws Exception;
}
