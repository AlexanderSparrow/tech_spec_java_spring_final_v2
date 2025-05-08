package ru.webrise.tech_spec_java_spring_final_v2.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SubscriptionDto {

    @NotNull
    private Long platformId;
}
