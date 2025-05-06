package ru.webrise.tech_spec_java_spring_final_v2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.webrise.tech_spec_java_spring_final_v2.dto.NewUserDto;
import ru.webrise.tech_spec_java_spring_final_v2.dto.ResponseUserDto;
import ru.webrise.tech_spec_java_spring_final_v2.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    ResponseUserDto toDto(User user);

    @Mapping(target = "id", ignore = true)
    User fromDto(NewUserDto dto);

}
