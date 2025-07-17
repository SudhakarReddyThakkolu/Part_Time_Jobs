package com.sudha.PartTimeJobs.service.impl;

import com.sudha.PartTimeJobs.dto.UserDTO;
import com.sudha.PartTimeJobs.entity.User;
import com.sudha.PartTimeJobs.mapper.UserMapper;
import com.sudha.PartTimeJobs.repository.UserRepository;
import com.sudha.PartTimeJobs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return UserMapper.toDto(savedUser);
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(UserMapper::toDto)
                .orElse(null);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        return userRepository.findById(id).map(existing -> {
            existing.setFullName(userDTO.getFullName());
            existing.setEmail(userDTO.getEmail());
            existing.setPhone(userDTO.getPhone());
            return UserMapper.toDto(userRepository.save(existing));
        }).orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
