package com.acm.backend.service.services.implementation;

import com.acm.backend.dao.dao.RoleDao;
import com.acm.backend.dao.entity.Role;
import com.acm.backend.service.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public Role findRole(String roleName) {
        return roleDao.findByRole(roleName);
    }
}
