package ru.webrise.tech_spec_java_spring_final_v2.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.webrise.tech_spec_java_spring_final_v2.dto.TopPlatformDto;
import ru.webrise.tech_spec_java_spring_final_v2.service.SubscriptionsService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/subscriptions")
public class PublicSubscriptionController {
    private final SubscriptionsService subscriptionsService;

    @GetMapping("/top")
    public List<TopPlatformDto> getTop3 () {
        log.info("Получение Top 3 подписок на сервисы");
        return subscriptionsService.getTop3Platforms();
    }



}
