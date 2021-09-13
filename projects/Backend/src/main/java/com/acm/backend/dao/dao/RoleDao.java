package com.acm.backend.dao.dao;

import com.acm.backend.dao.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleDao{
    Role findByRole(String roleName);

}
