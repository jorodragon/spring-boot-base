package com.jorodragon.springbootbase.service;

import com.jorodragon.springbootbase.dto.CreateUserDTO;
import com.jorodragon.springbootbase.dto.UpdateUserDTO;
import com.jorodragon.springbootbase.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserDTO> getListUser();
    UserDTO getUserById(Long id);
    UserDTO createUser(CreateUserDTO createUserDTO);
    UserDTO updateUser(Long id, UpdateUserDTO updateUserDTO);
    void deleteUser(Long id);
}
