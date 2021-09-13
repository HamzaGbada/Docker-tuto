package com.acm.backend.dao.repository;

import com.acm.backend.dao.entity.Role;
import com.acm.backend.dao.entity.SerialNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}
