package com.acm.backend.api;

import com.acm.backend.dao.entity.SerialNumber;
import com.acm.backend.resource.SerialNumberResource;
import com.acm.backend.service.services.SerialNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class AdminController {
    @Autowired
    private SerialNumberService serialNumberService;
    /*
    CRUD SERIAL NUMBER
     */
    @PostMapping("/addSerialNumber")
    public ResponseEntity<?> addSerialNumber(@RequestBody SerialNumberResource serialNumberResource){
        if(serialNumberService.getSerialNumberByValue(serialNumberResource.getValue()) != null){
            return ResponseEntity.ok("Serial Number already exist");
        }
        SerialNumber serialNumber = serialNumberService.addSerialNumber(serialNumberResource);
        if(serialNumber == null){
            return ResponseEntity.ok("Addition failed");
        }
        return ResponseEntity.ok("Serial Number added successfully");
    }
    @GetMapping("/getAllSerialNumber")
    public ResponseEntity<?> getAllSerialNumber(){
        List<SerialNumberResource> serialNumberList = serialNumberService.getAllSerialNumber();
        return ResponseEntity.ok(serialNumberList);
    }
    @GetMapping("/getSerialNumberById/{id}")
    public ResponseEntity<?> getSerialNumberById(@PathVariable Long id){
        Optional<SerialNumberResource> serialNumberResource =serialNumberService.getSerialNumberById(id);
        return ResponseEntity.ok(serialNumberResource);
    }
    @GetMapping("/getSerialNumberByValue/{value}")
    public ResponseEntity<?> getSerialNumberByValue(@PathVariable Long value){
        SerialNumberResource serialNumberResource =serialNumberService.getSerialNumberByValue(value);
        return ResponseEntity.ok(serialNumberResource);
    }
    @GetMapping("/getSerialNumberByIsActive/{isActive}")
    public ResponseEntity<?> getSerialNumberByIsActive(@PathVariable Boolean isActive){
        List<SerialNumberResource> serialNumberResource =serialNumberService.getSerialNumberByIsActive(isActive);
        return ResponseEntity.ok(serialNumberResource);
    }

    @GetMapping("/getSerialNumberByIsReserved/{isReserved}")
    public ResponseEntity<?> getSerialNumberByIsReserved(@PathVariable Boolean isReserved){
        List<SerialNumberResource> serialNumberResource =serialNumberService.getSerialNumberByIsReserved(isReserved);
        return ResponseEntity.ok(serialNumberResource);
    }

    @DeleteMapping("/removeSerialNumber/{id}")
    public ResponseEntity<?> removeSerialNumber(@PathVariable Long id){
        this.serialNumberService.removeSerialNumber(id);
        return ResponseEntity.ok("Serial Number Removed Successfully");
    }
///////////////////////////////////////////////



}
