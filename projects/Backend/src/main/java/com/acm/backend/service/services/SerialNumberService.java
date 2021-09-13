package com.acm.backend.service.services;

import com.acm.backend.dao.entity.SerialNumber;
import com.acm.backend.resource.SerialNumberResource;

import java.util.List;
import java.util.Optional;

public interface SerialNumberService {
    SerialNumber addSerialNumber(SerialNumberResource serialNumberResource);
    public List<SerialNumberResource> getAllSerialNumber();
    public Optional<SerialNumberResource> getSerialNumberById(Long id);
    public SerialNumberResource getSerialNumberByValue(Long value);
    public List<SerialNumberResource> getSerialNumberByIsActive(Boolean isActive);
    public List<SerialNumberResource> getSerialNumberByIsReserved(Boolean isReserved);
    public void removeSerialNumber(Long id);
    public SerialNumber getSerialIfNotReserved(Long Value);
    boolean checkSerialNumber(Long serialNumber);




}
