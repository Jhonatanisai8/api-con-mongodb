package com.isai.api_mongodb.service;

import java.util.Collection;
import java.util.List;

public interface CrudService<T> {
    void saveUser(T user);

    void updateUser(String userId, T user);

    void deleteUserById(String userId);

    Collection<T> getAllUsers();

    List<T> findAllUsers();
}