package ru.webrise.tech_spec_java_spring_final_v2.dto;

import lombok.Data;

@Data
public class ResponseUserDto {
    private Long id;
    private String name;
    private String email;
}
