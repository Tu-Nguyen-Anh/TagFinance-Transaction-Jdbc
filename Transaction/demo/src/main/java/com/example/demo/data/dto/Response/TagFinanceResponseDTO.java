package com.example.demo.data.dto.Response;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.demo.data.entity.TagFinance;
@Data
@NoArgsConstructor
public class TagFinanceResponseDTO {
    private String name;
    private String description;

    public TagFinanceResponseDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public TagFinanceResponseDTO(TagFinance tagfinance ){
        this.name = tagfinance.getName();
        this.description = tagfinance.getDescription();
    }
}
