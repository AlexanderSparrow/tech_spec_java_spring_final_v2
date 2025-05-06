package ru.webrise.tech_spec_java_spring_final_v2.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.webrise.tech_spec_java_spring_final_v2.dto.NewUserDto;
import ru.webrise.tech_spec_java_spring_final_v2.dto.ResponseUserDto;
import ru.webrise.tech_spec_java_spring_final_v2.mapper.UserMapper;
import ru.webrise.tech_spec_java_spring_final_v2.model.User;
import ru.webrise.tech_spec_java_spring_final_v2.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public ResponseUserDto createUser(NewUserDto newUserDto) {
        User user = userRepository.save(userMapper.fromDto(newUserDto));
        return userMapper.toDto(user);
    }

    public List<ResponseUserDto> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public ResponseUserDto findById(Long id) {
        return  userMapper.toDto(userRepository.findById(id).orElseThrow());
    }

    public ResponseUserDto updateUser(@Valid User newUserDto) {
        return null; //TODO
    }
}
