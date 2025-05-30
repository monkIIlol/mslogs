package com.edutech.mslogs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.mslogs.model.Log;
import com.edutech.mslogs.service.LogService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



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

    @GetMapping("/{idLog}")
    public ResponseEntity<Log> readLog(@PathVariable int idLog) {
        Log buscar = logService.findById(idLog);
        if(buscar != null) {
            return new ResponseEntity<>(buscar, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("usuario/log/{idUsuario}")
    public ResponseEntity<List<Log>> getListLog(@PathVariable int idUsuario) {
        List<Log> buscar = logService.findAll(); 
            List<Log>  listaLog = new ArrayList<>();
            for (Log log : buscar) {
                if(log.getIdUsuario() == idUsuario) {
                    listaLog.add(log);
                }
            
            }
            return new ResponseEntity<>(listaLog, HttpStatus.OK);
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
    
    @PutMapping("/{idLog}")
    public ResponseEntity<Log> updateClase(@PathVariable int idLog, @RequestBody Log log) {
        if(logService.update(idLog, log)) {
            return new ResponseEntity<>(log, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idLog}")
    public ResponseEntity<?> deleteLog(@PathVariable int idLog) {
        Log buscar = logService.findById(idLog);
        if(buscar != null) {
            logService.deleteById(idLog);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
