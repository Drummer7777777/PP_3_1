package ru.ponomarev.SpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.ponomarev.SpringBoot.models.User;
import ru.ponomarev.SpringBoot.service.UserService;

import java.util.ArrayList;
import java.util.List;


@Controller
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping (value = "/users")
    public String printUsers(ModelMap model) { //, @RequestParam(defaultValue = "5", name = "count") int count) {
        List<User> usersResponse = new ArrayList<>(userService.listUsers());
        model.addAttribute("users" , usersResponse);
        return "users";
    }

    @GetMapping(value = "/users/create")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping(value = "/users")
    public String createUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @DeleteMapping(value = "/delete")
    public String deleteUser(@RequestParam(name = "id") int id) {
        userService.remove(id);
        return "redirect:/users";
    }

    @GetMapping(value = "/edit")
    public String editUser(Model model, @RequestParam(name = "id") int id) {
        model.addAttribute("user", userService.getById(id));
        return "edit";
    }

    @PatchMapping(value = "/users")
    public String applyEditUser(@ModelAttribute("user") User user, @RequestParam(name = "id") int id) {
        user.setId(id);
        userService.edit(user);
        return "redirect:/users";
    }
}
