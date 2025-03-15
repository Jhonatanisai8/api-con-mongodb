package com.isai.api_mongodb.service.serviceImpl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.isai.api_mongodb.models.User;
import com.isai.api_mongodb.models.dto.UserDto;
import com.isai.api_mongodb.repository.UserRepository;
import com.isai.api_mongodb.service.CrudService;

public class UserServiceImple
        implements CrudService<UserDto> {

    @Autowired
    private UserRepository repository;

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setImagePath(userDto.getImagePath());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setDepartamento(userDto.getDepartamento());
        repository.save(user);
    }

    @Override
    public void updateUser(String userId, UserDto userDtop) {
        Optional<User> userOptional = repository.findById(Integer.parseInt(userId));
        if (userOptional.isPresent()) {
            User userToUpdate = userOptional.get();
            userToUpdate.setUserId(userDtop.getUserId());
            userToUpdate.setImagePath(userDtop.getImagePath());
            userToUpdate.setFirstName(userDtop.getFirstName());
            userToUpdate.setLastName(userDtop.getLastName());
            userToUpdate.setDepartamento(userDtop.getDepartamento());
            repository.save(userToUpdate);
        } else {
            throw new RuntimeException("User not found for id: " + userId);
        }
    }

    @Override
    public void deleteUserById(String userId) {
        Optional<User> user = repository.findById(Integer.parseInt(userId));
        if (user.isPresent()) {
            repository.delete(user.get());
        } else {
            throw new RuntimeException("User not found for id: " + userId);
        }
    }

    @Override
    public Collection<UserDto> getAllUsers() {
        return repository.findAll()
                .stream()
                .map(user -> new UserDto(user.getUserId(), user.getImagePath(), user.getFirstName(), user.getLastName(),
                        user.getDepartamento()))
                .toList();
    }

    @Override
    public List<UserDto> findAllUsers() {
        return repository.findAll()
                .stream()
                .map(user -> new UserDto(user.getUserId(), user.getImagePath(), user.getFirstName(), user.getLastName(),
                        user.getDepartamento()))
                .toList();
    }

}
