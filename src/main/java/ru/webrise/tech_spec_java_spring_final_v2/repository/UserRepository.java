package ru.webrise.tech_spec_java_spring_final_v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.webrise.tech_spec_java_spring_final_v2.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
