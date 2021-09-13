package com.acm.backend.dao.dao.implementation;

import com.acm.backend.dao.dao.SerialNumberDao;
import com.acm.backend.dao.entity.Person;
import com.acm.backend.dao.entity.SerialNumber;
import com.acm.backend.dao.entity.User;
import com.acm.backend.dao.repository.SerialNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SerialNumberDaoImpl implements SerialNumberDao {
    @Autowired
    private SerialNumberRepository serialNumberRepository;

    @Override
    public SerialNumber addSerialNumber(SerialNumber serialNumber) {
        return this.serialNumberRepository.save(serialNumber);
    }

    @Override
    public List<SerialNumber> getAllSerialNumber() {
        return this.serialNumberRepository.findAll();
    }

    @Override
    public Optional<SerialNumber> getSerialNumberById(Long id) {
        return this.serialNumberRepository.findById(id);
    }

    @Override
    public SerialNumber getSerialNumberByValue(Long value) {
        SerialNumber serialNumber = serialNumberRepository.findByValue(value);
        List<SerialNumber> serialNumber1 =serialNumberRepository.findAll();
        return serialNumber;
    }
    @Override
    public List<SerialNumber> getSerialNumberByIsActive(Boolean isActive) {
        return this.serialNumberRepository.findByIsActive(isActive);
    }

    @Override
    public List<SerialNumber> getSerialNumberByIsReserved(Boolean isReserved) {
        return this.serialNumberRepository.findByIsReserved(isReserved);
    }

    @Override
    public void removeSerialNumber(Long id) {
        this.serialNumberRepository.deleteById(id);
    }
    @Override
    public boolean IsExistsByValue(Long value){return this.serialNumberRepository.existsByValue(value);}

    @Override
    public SerialNumber getSerialNumberByUser(User user) {
        return this.serialNumberRepository.findByUser(user);
    }

}

