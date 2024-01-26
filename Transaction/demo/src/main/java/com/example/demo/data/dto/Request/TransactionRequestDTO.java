package com.example.demo.data.dto.Request;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
public class TransactionRequestDTO {
    @NotEmpty(message="transaction title not blank ")
    private String title;
    @NotEmpty(message="transaction description not blank ")
    private String description;
    @NotEmpty(message="transaction amount not blank ")
    private String amount;
    @NotEmpty(message="transaction tagId not blank ")
    private int tagId;
}
