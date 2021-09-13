package com.acm.backend.dao.dao.implementation;

import com.acm.backend.dao.dao.RoleDao;
import com.acm.backend.dao.entity.Role;
import com.acm.backend.dao.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role findByRole(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
