package com.acm.backend.service.services.implementation;

import com.acm.backend.dao.dao.PersonDao;
import com.acm.backend.dao.dao.SerialNumberDao;
import com.acm.backend.dao.dao.UserDao;
import com.acm.backend.dao.entity.Person;
import com.acm.backend.dao.entity.SerialNumber;
import com.acm.backend.dao.entity.User;
import com.acm.backend.resource.SerialNumberResource;
import com.acm.backend.service.mapper.SerialNumberMapper;
import com.acm.backend.service.services.SerialNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SerialNumberServiceImpl implements SerialNumberService {
    @Autowired
    private SerialNumberDao serialNumberdao;
    @Autowired
    private UserDao userDao;

    @Override
    public SerialNumber addSerialNumber(SerialNumberResource serialNumberResource) {
        return this.serialNumberdao.addSerialNumber(SerialNumberMapper.resourceToEntity(serialNumberResource));
    }

    @Override
    public List<SerialNumberResource> getAllSerialNumber() {
        return this.serialNumberdao.getAllSerialNumber()
                .stream()
                .map(SerialNumberMapper::entityToResource)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SerialNumberResource> getSerialNumberById(Long id) {
        return this.serialNumberdao.getSerialNumberById(id)
                .map(SerialNumberMapper::entityToResource);
    }

    @Override
    public SerialNumberResource getSerialNumberByValue(Long value) {
        Optional<SerialNumber> serialNumber = Optional.ofNullable(serialNumberdao.getSerialNumberByValue(value));
        return serialNumber
                .map(SerialNumberMapper::entityToResource)
                .orElse(null);

    }

    @Override
    public List<SerialNumberResource> getSerialNumberByIsActive(Boolean isActive) {
        return this.serialNumberdao.getSerialNumberByIsActive(isActive)
                .stream()
                .map(SerialNumberMapper::entityToResource)
                .collect(Collectors.toList());
    }

    @Override
    public List<SerialNumberResource> getSerialNumberByIsReserved(Boolean isReserved) {
        return this.serialNumberdao.getSerialNumberByIsReserved(isReserved)
                .stream()
                .map(SerialNumberMapper::entityToResource)
                .collect(Collectors.toList());
    }

    @Override
    public void removeSerialNumber(Long id) {
        Optional<SerialNumber> serialNumberOptional = serialNumberdao.getSerialNumberById(id);
        SerialNumber serialNumber = serialNumberOptional.get();
        if(serialNumber.getIsReserved()==true) {
            User user = serialNumber.getUser();
            serialNumber.setUser(null);
            user.setSerialNumber(null);
            serialNumberdao.addSerialNumber(serialNumber);
            userDao.addUser(user);
        }
        this.serialNumberdao.removeSerialNumber(id);

    }

    public SerialNumber getSerialIfNotReserved(Long Value) {

        SerialNumber serialNumber = serialNumberdao.getSerialNumberByValue(Value);


        if(serialNumberdao.IsExistsByValue(Value)) {

            if (!serialNumber.getIsActive()||serialNumber.getIsReserved()) {
                serialNumber = null;

            }

        }
        return serialNumber;


    }

    @Override
    public boolean checkSerialNumber(Long serialNumber) {
        boolean exist = serialNumberdao.IsExistsByValue(serialNumber);
        if(exist){
            SerialNumber serialNumber1 = serialNumberdao.getSerialNumberByValue(serialNumber);
            boolean active = serialNumber1.getIsActive();
            boolean reserved = serialNumber1.getIsReserved();
            if(active && !reserved){
                return true;
            }
        }

        return false;
    }

}

