package com.acm.backend.service.services.implementation;

import com.acm.backend.dao.dao.SerialNumberDao;
import com.acm.backend.dao.dao.UserDao;
import com.acm.backend.dao.entity.Person;
import com.acm.backend.dao.entity.Role;
import com.acm.backend.dao.entity.SerialNumber;
import com.acm.backend.dao.entity.User;
import com.acm.backend.dao.model.SignUpForm;
import com.acm.backend.dao.repository.SerialNumberRepository;
import com.acm.backend.dao.repository.UserRepository;
import com.acm.backend.service.services.RoleService;
import com.acm.backend.service.services.SerialNumberService;
import com.acm.backend.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SerialNumberDao serialNumberDao;
    @Autowired
    private SerialNumberService serialNumberService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SerialNumberRepository serialNumberRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private RoleService roleService;

    @Override
    @Transactional
    public Person createUser(SignUpForm signUpForm) {
        Long Value=signUpForm.getKey();
        if(serialNumberService.getSerialIfNotReserved(Value)!=null) {
            SerialNumber key = serialNumberDao.getSerialNumberByValue(Value);
            key.setIsReserved(true);
            List<Role> roles=new ArrayList<Role>();
            roles.add(roleService.findRole("user"));
            User user = User.builder()
                    .name(signUpForm.getName())
                    .userName(signUpForm.getUsername())
                    .password(encoder.encode(signUpForm.getPassword()))
                    .email(signUpForm.getEmail())
                    .roles(roles)
                    .build();

            user.setSerialNumber(key);
            if(userDao.IsExistsByUserName(user.getUserName())){
                return null;}
            else {
                userRepository.save(user);
                key.setUser(user);
                serialNumberRepository.save(key);
                return user;}

        }

        return null;
    }
}
