package ru.webrise.tech_spec_java_spring_final_v2.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.webrise.tech_spec_java_spring_final_v2.dto.NewUserDto;
import ru.webrise.tech_spec_java_spring_final_v2.dto.ResponseUserDto;
import ru.webrise.tech_spec_java_spring_final_v2.dto.UpdateUserDto;
import ru.webrise.tech_spec_java_spring_final_v2.service.UserService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseUserDto createUser(@Valid @RequestBody NewUserDto newUserDto) {
        log.info("Получен запрос на создание пользователя: {}", newUserDto);
        return userService.createUser(newUserDto);
    }

    @GetMapping
    public List<ResponseUserDto> getUsers() {
        log.info("Получен запрос на получение всех пользователей");
        return userService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseUserDto updateUser(@Valid @RequestBody UpdateUserDto updateUserDto,
                                      @PathVariable Long id) {
        log.info("Получен запрос на обновление пользователя: c id {}", id);
        return userService.updateUser(id, updateUserDto);
    }

    @GetMapping("/{id}")
    public ResponseUserDto getUser(@PathVariable Long id) {
        log.info("Получен запрос вывод пользователя с id {}", id);
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        log.info("Получен запрос на удаление пользователя {}", id);
        userService.deleteUser(id);
    }
}
