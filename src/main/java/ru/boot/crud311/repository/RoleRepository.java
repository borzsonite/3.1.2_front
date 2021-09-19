package ru.boot.crud311.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.boot.crud311.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
