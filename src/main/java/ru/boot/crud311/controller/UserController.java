package ru.boot.crud311.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.boot.crud311.model.Role;
import ru.boot.crud311.model.User;
import ru.boot.crud311.service.RoleService;
import ru.boot.crud311.service.UserService;
import java.security.Principal;
import java.util.Collection;
import java.util.HashSet;

@Controller
public class UserController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    @ResponseBody
    public String index() {
        return "hello";
    }

    @GetMapping("/admin")
    public String showUsers(Model model, Principal principal) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("title", "Add user");
        return "show";
    }

    @PostMapping("/admin/user")
    public String addUser(@ModelAttribute(value = "user") User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        System.out.println("Inside controller");
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("title", "Edit user");
        return "/show";
    }

    @GetMapping("/admin/remove/{id}")
    public String removeUser(@PathVariable(value = "id") Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }

    @GetMapping("/user")
    public String showUserPage2(Principal principal, Model model) {
        model.addAttribute("user", userService.findByUsername(principal.getName()));
        return "userpage";
    }
}
