package com.acm.backend.dao.repository;

import com.acm.backend.dao.entity.Person;
import com.acm.backend.dao.entity.SerialNumber;
import com.acm.backend.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerialNumberRepository extends JpaRepository<SerialNumber, Long> {
    SerialNumber findByValue(Long value);
    List<SerialNumber> findByIsActive(Boolean isActive) ;
    List<SerialNumber> findByIsReserved(Boolean isReserved) ;
    boolean existsByValue(Long value);
    SerialNumber findByUser(User user);

}
