package com.cpe.wongnai_server.Controller;
import org.springframework.web.bind.annotation.*;
import com.cpe.wongnai_server.Repository.*;
import com.cpe.wongnai_server.entity.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
class PeriodController{
    @Autowired
    private PeriodRepository periodRepository;
    
    @GetMapping("/Period")
    public List<Period> Period(){
        return periodRepository.findAll().stream().collect(Collectors.toList());
    }

    
}