package com.example.demo.data.dto.Response;

import com.example.demo.data.entity.Transaction;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransactionResponseDTO {
    private String title;
    private String description;
    private double amount;
    private int tagId;

    public TransactionResponseDTO(String title, String description, double amount, int tagId) {
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.tagId = tagId;
    }
    public TransactionResponseDTO(Transaction transaction){
        this.title = transaction.getTitle();
        this.description = transaction.getDescription();
        this.amount = transaction.getAmount();
        this.tagId = transaction.getTagId();
    }
}
