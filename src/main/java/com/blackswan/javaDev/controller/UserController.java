package com.blackswan.javaDev.controller;

import com.blackswan.javaDev.model.User;
import com.blackswan.javaDev.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    User getInfo(@PathVariable Long id) {
        return userService.get(id);
    }

    @GetMapping()
    List<User> all() {
        return userService.all();
    }

    @PostMapping()
    User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping({"/{id}"})
    User update(@RequestBody User user, @PathVariable Long id) {
        user.setId(id);
        return userService.save(user);
    }

}
