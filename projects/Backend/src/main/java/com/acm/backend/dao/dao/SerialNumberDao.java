package com.acm.backend.dao.dao;

import com.acm.backend.dao.entity.Person;
import com.acm.backend.dao.entity.SerialNumber;
import com.acm.backend.dao.entity.User;

import java.util.List;
import java.util.Optional;

public interface SerialNumberDao {
    public SerialNumber addSerialNumber(SerialNumber serialNumber);
    public List<SerialNumber> getAllSerialNumber() ;
    public Optional<SerialNumber> getSerialNumberById(Long id) ;
    public SerialNumber getSerialNumberByValue(Long value) ;
    public List<SerialNumber> getSerialNumberByIsActive(Boolean isActive) ;
    public List<SerialNumber> getSerialNumberByIsReserved(Boolean isReserved) ;
    public void removeSerialNumber(Long id) ;
    public boolean IsExistsByValue(Long value);
    SerialNumber getSerialNumberByUser(User user);



}
