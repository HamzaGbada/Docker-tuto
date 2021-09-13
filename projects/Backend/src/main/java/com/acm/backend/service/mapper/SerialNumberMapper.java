package com.acm.backend.service.mapper;

import com.acm.backend.dao.entity.SerialNumber;
import com.acm.backend.resource.SerialNumberResource;

public class SerialNumberMapper {
    public static SerialNumber resourceToEntity(SerialNumberResource serialNumberResource){
        return SerialNumber.builder()
                .value(serialNumberResource.getValue())
                .isReserved(serialNumberResource.getIsReserved())
                .isActive(serialNumberResource.getIsActive())
                .build();
    }
    public static SerialNumberResource entityToResource(SerialNumber serialNumber){
        return SerialNumberResource.builder()
                .value(serialNumber.getValue())
                .isReserved(serialNumber.getIsReserved())
                .isActive(serialNumber.getIsActive())
                .build();
    }
}
