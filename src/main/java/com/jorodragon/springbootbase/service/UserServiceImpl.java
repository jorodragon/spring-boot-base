package com.jorodragon.springbootbase.service;

import com.jorodragon.springbootbase.model.User;
import com.jorodragon.springbootbase.exception.DuplicateRecordException;
import com.jorodragon.springbootbase.exception.NotFoundException;
import com.jorodragon.springbootbase.dto.CreateUserDTO;
import com.jorodragon.springbootbase.dto.UpdateUserDTO;
import com.jorodragon.springbootbase.dto.UserDTO;
import com.jorodragon.springbootbase.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDTO> getListUser() {
        List<User> users = userRepository.findAll();

        return modelMapper.map(users, new TypeToken<List<UserDTO>>() {}.getType());
    }

    @Override
    public UserDTO getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
            throw new NotFoundException("User isn't exist");

        return modelMapper.map(user.get(), UserDTO.class);
    }

    @Override
    public UserDTO createUser(CreateUserDTO createUserDTO) {
        User user = userRepository.findByEmail(createUserDTO.getEmail());

        if(user != null)
            throw new DuplicateRecordException("This email has already registered");


        user = modelMapper.map(createUserDTO, User.class);
        user.setPassword(createUserDTO.getPassword());
        userRepository.save(user);

        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO updateUser(Long id, UpdateUserDTO updateUserDTO) {
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty())
            throw new NotFoundException("User isn't exist");

        // Merge updateUserDTO to user;
        User updateUser = user.get();
        modelMapper.map(updateUserDTO, updateUser);

        userRepository.save(updateUser);

        return getUserById(id);
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty())
            throw new NotFoundException("User isn't exist");

        userRepository.deleteById(id);
    }
}
