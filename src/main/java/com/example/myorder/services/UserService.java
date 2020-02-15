package com.example.myorder.services;

import com.example.myorder.api.dtos.CreateUserDto;
import com.example.myorder.api.dtos.RestaurantResponseDto;
import com.example.myorder.api.dtos.UserResponseDto;
import com.example.myorder.api.mappers.UserMapper;
import com.example.myorder.entities.Restaurant;
import com.example.myorder.entities.User;
import com.example.myorder.exceptions.AlreadyExistsException;
import com.example.myorder.exceptions.NotFoundException;
import com.example.myorder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponseDto create(CreateUserDto createUserDto) {
        validateUserEmail(createUserDto.getEmail());

        User user = userRepository.save(createUser(createUserDto));

        return UserMapper.toResponseDto(user);
    }

    public UserResponseDto getById(Integer id) {
        return  UserMapper.toResponseDto(findById(id));
    }


    public User findById(Integer id) {
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()){
            throw new NotFoundException("Não existe usuário com o id: " + id);
        }

        return  user.get();
    }


    public List<UserResponseDto> listAll(){
        List<User> users = userRepository.findAll();

        return users.stream().map(user -> UserMapper.toResponseDto(user)).collect(Collectors.toList());
        /*
        List<UserResponseDto> userResponseList = new ArrayList<>();
        for(User user : users){
            userResponseList.add(UserMapper.toResponseDto(user));
        }
        return userResponseList;
         */

        /* return users.stream().map(UserMapper::toResponseDto).collect(Collectors.toList()); */
    }

    private  User createUser(CreateUserDto createUserDto){
        return new User()
                .setName(createUserDto.getName())
                .setEmail(createUserDto.getEmail())
                .setAddress(createUserDto.getAddress())
                .setPassword(createUserDto.getPassword())
                .setPhone(createUserDto.getPhone());
    }

    private void validateUserEmail(String email) {
        User user = userRepository.findByEmail(email);

        if(user != null) {
            throw new AlreadyExistsException("Já existe um usuário cadastrado com este e-mail.");
        }
    }
}
