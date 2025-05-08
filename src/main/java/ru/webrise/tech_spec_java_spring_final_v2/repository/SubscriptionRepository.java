package ru.webrise.tech_spec_java_spring_final_v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.webrise.tech_spec_java_spring_final_v2.model.Subscription;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findAllByUser_Id(Long userId);

    @Query(value = "SELECT s.platform_id, COUNT(*) AS cnt " +
            "FROM subscriptions s " +
            "WHERE s.platform_id IS NOT NULL " +
            "GROUP BY s.platform_id " +
            "ORDER BY cnt DESC LIMIT 3", nativeQuery = true)
    List<Object[]> findTop3PlatformIdsWithCount();


}
