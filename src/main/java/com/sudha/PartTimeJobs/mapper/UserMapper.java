package com.sudha.PartTimeJobs.mapper;

import com.sudha.PartTimeJobs.dto.UserDTO;
import com.sudha.PartTimeJobs.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static UserDTO toDto(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        return dto;
    }

    public static  User toEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        return user;
    }
}
