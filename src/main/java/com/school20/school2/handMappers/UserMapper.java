package com.school20.school2.handMappers;

import com.school20.school2.Entitys.User;
import com.school20.school2.dto.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    User toUser(UserDto teacherDt);

    List<UserDto> toUserDtoList(List<User> users);
    }
