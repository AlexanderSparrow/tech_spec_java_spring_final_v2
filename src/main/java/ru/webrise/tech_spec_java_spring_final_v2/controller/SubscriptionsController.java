package ru.webrise.tech_spec_java_spring_final_v2.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.webrise.tech_spec_java_spring_final_v2.dto.SubscriptionDto;
import ru.webrise.tech_spec_java_spring_final_v2.model.Subscription;
import ru.webrise.tech_spec_java_spring_final_v2.service.SubscriptionsService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users/{id}/subscriptions")
public class SubscriptionsController {
    private final SubscriptionsService  subscriptionsService;

    @PostMapping
    public Subscription setSubscription (@PathVariable Long id,
            @Valid @RequestBody SubscriptionDto subscription) {
        log.info("Получен запрос на создание подписки пользователя с id: {} на сервис c id: {} ", id, subscription.getPlatformId());
        return subscriptionsService.setSubscription(id, subscription);
    }

    @GetMapping
    public List<Subscription> getSubscriptions (@PathVariable Long id) {
        log.info("Получен запрос на получение подписок пользователя с id {}", id);
        return subscriptionsService.getUserSubscription(id);
    }


    @DeleteMapping("/{subId}")
    public void deleteSubscriptions (@PathVariable Long id,
                                     @PathVariable Long subId) {
        log.info("Получен запрос на удаление подписки с id: {} у пользователя с id {}", id, subId);
        subscriptionsService.deleteUserSubscription(id, subId);
    }
}
