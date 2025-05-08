package ru.webrise.tech_spec_java_spring_final_v2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TopPlatformDto {
    private String platformName;
    private Long subscriptionCount;
}

