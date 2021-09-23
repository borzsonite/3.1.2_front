package ru.boot.crud311.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.boot.crud311.model.Role;
import ru.boot.crud311.repository.RoleRepository;

import java.util.Collection;

@Service
public class RoleService {
    private RoleRepository repository;

    @Autowired
    public void setRepository(RoleRepository repository) {
        this.repository = repository;
    }

    public Collection<Role> findAllRoles() {
        return repository.findAll();
    }
}
