package com.epam.service;

import com.epam.dao.UserDao;
import com.epam.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(long userId) {
        return userDao.get(userId);
    }

    public User getUserByEmail(String email) {
        return userDao.values().stream()
                      .filter(user -> user.getEmail().equals(email))
                      .findFirst()
                      .orElseThrow(() -> new IllegalStateException("User does not exist with " +
                              "email: " + email));
    }

    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        int skipCount = (pageNum - 1) * pageSize;

        return userDao.values().stream()
                      .filter(user -> user.getName().equals(name))
                      .skip(skipCount)
                      .limit(pageSize)
                      .collect(Collectors.toList());
    }

    public User createUser(User user) {
        return userDao.put(user.getId(), user);
    }

    public User updateUser(User user) {
        return userDao.replace(user.getId(), user);

    }

    public boolean deleteUser(long userId) {
        return userDao.remove(userId);
    }
}
