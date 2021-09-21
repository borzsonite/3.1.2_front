package ru.boot.crud311.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.boot.crud311.model.Role;
import ru.boot.crud311.model.User;
import ru.boot.crud311.repository.RoleRepository;
import ru.boot.crud311.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;

@Component
public class PopulateDB {
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private UserService userService;

    public PopulateDB(RoleRepository roleRepository, UserRepository userRepository, UserService userService) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostConstruct
    public void populateDB() {
        Role roleAdmin = new Role(1L, "ROLE_ADMIN");
        Role roleUser = new Role(2L, "ROLE_USER");
        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);

        Collection<Role> adminRoles = new HashSet<>();
        Collection<Role> userRoles = new HashSet<>();
        adminRoles.add(roleAdmin);
        adminRoles.add(roleUser);
        userRoles.add(roleUser);

        User admin = new User(
                "Jhon",
                "Smith",
                35,
                "jhon@mail.com",
                "$2a$12$IcHjkIO/5K5dIcAkOownQ.hqF6lym34lGPWcD8XS4UhSAWQ7iPif2",
                adminRoles);

        User user = new User(
                "Bob",
                "Smith",
                25,
                "bob@mail.com",
                "$2a$12$IcHjkIO/5K5dIcAkOownQ.hqF6lym34lGPWcD8XS4UhSAWQ7iPif2",
                userRoles);

        if (userService.findByUsername(user.getUsername()) == null ||
                userService.findByUsername(admin.getUsername()) == null) {
            userService.save(user);
            userService.save(admin);
        }
    }
}
