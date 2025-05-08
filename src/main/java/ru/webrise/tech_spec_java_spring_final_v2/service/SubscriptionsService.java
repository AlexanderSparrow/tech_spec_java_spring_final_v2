package ru.webrise.tech_spec_java_spring_final_v2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import ru.webrise.tech_spec_java_spring_final_v2.dto.SubscriptionDto;
import ru.webrise.tech_spec_java_spring_final_v2.dto.TopPlatformDto;
import ru.webrise.tech_spec_java_spring_final_v2.model.StreamingPlatform;
import ru.webrise.tech_spec_java_spring_final_v2.model.Subscription;
import ru.webrise.tech_spec_java_spring_final_v2.model.User;
import ru.webrise.tech_spec_java_spring_final_v2.repository.StreamingPlatformRepository;
import ru.webrise.tech_spec_java_spring_final_v2.repository.SubscriptionRepository;
import ru.webrise.tech_spec_java_spring_final_v2.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionsService {
    private final SubscriptionRepository subscriptionsRepository;
    private final UserRepository userRepository;
    private final StreamingPlatformRepository streamingPlatformRepository;

    public Subscription setSubscription(Long id, SubscriptionDto subscriptionDto) {
        User user = userRepository.findById(id).orElseThrow();
        StreamingPlatform platform = streamingPlatformRepository.findById(subscriptionDto.getPlatformId()).orElseThrow();

        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setPlatform(platform);

        return subscriptionsRepository.save(subscription);
    }

    public List<Subscription> getUserSubscription(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return subscriptionsRepository.findAllByUser_Id(id);
    }

    public void deleteUserSubscription(Long id, Long subId) {
        Subscription subscription = subscriptionsRepository.findById(id).orElseThrow();
        if (!subscription.getUser().getId().equals(subId)) {
            throw new IllegalArgumentException("Подписка не принадлежит пользователю");
        }
        subscriptionsRepository.deleteById(subId);
    }

    public List<TopPlatformDto> getTop3Platforms() {
        List<Object[]> results = subscriptionsRepository.findTop3PlatformIdsWithCount();

        return results.stream()
                .map(row -> {
                    Long platformId = ((Number) row[0]).longValue();
                    Long count = ((Number) row[1]).longValue();
                    StreamingPlatform platform = null;
                    try {
                        platform = streamingPlatformRepository.findById(platformId)
                                .orElseThrow(ChangeSetPersister.NotFoundException::new);
                    } catch (ChangeSetPersister.NotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    return new TopPlatformDto(platform.getServiceName(), count);
                })
                .toList();
    }

}
