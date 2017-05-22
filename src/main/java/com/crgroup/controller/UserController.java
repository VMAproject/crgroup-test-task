package com.crgroup.controller;

import com.crgroup.model.User;
import com.crgroup.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public List<User> list() {
        return userRepository.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "users", method = RequestMethod.POST)
    public User create(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.saveAndFlush(user);
    }

    //@PreAuthorize("'admin' == authentication.name")
    @PreAuthorize("hasRole('ROLE_ADMIN') or #id == principal.id")
    @RequestMapping(value = "users/{id}", method = RequestMethod.GET)
    public User get(@PathVariable Long id) {
        return userRepository.findOne(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or #user.id == principal.id")
    @RequestMapping(value = "users/{id}", method = RequestMethod.PUT)
    public User update(@PathVariable Long id, @RequestBody User user) {
        User existingUser = userRepository.findOne(id);
        BeanUtils.copyProperties(user, existingUser, "password");
        if (user.getPassword() != null)
            existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.saveAndFlush(existingUser);

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
    public User delete(@PathVariable Long id) {
        User existingUser = userRepository.findOne(id);
        userRepository.delete(existingUser);
        return existingUser;
    }
}
