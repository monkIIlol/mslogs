package com.edutech.mslogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.mslogs.model.Log;
import com.edutech.mslogs.service.LogService;

@RestController
@RequestMapping("api/v1/logs")
public class LogController {
    @Autowired
    private LogService logService;

    @GetMapping
    public ResponseEntity<List<Log>> getAll() {
        List<Log> logs = logService.findAll();
        if (!logs.isEmpty()) {
            return new ResponseEntity<>(logs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity<Log> postPaciente(@RequestBody Log log) {
        Log buscado = logService.findById(log.getIdLog());
        if (buscado == null) {
            return new ResponseEntity<>(logService.save(log), HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
}
