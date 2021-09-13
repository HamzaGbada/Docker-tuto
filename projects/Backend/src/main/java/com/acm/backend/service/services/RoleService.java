package com.acm.backend.service.services;

import com.acm.backend.dao.entity.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {

    public Role findRole(String roleName) ;

}
