package com.example.demo.data.dto.Request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class TagfinanceRequestDTO {
    @NotEmpty(message = "Tag Finance name not blank")
    private String name;
    @NotEmpty(message = "Tag Finance description not blank")
    private String description;
}
