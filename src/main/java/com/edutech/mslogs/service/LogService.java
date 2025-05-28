package com.edutech.mslogs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.mslogs.model.Log;
import com.edutech.mslogs.repository.LogRepository;

@Service
public class LogService {
    @Autowired
    private LogRepository logRepository;

    public List<Log> findAll() {
        return logRepository.findAll();
    }

    public Log findById(int idLog) {
        return logRepository.findById(idLog);
    }

    public Log save(Log log) {
        return logRepository.save(log);
    }

    public void deleteById(int idLog) {
        logRepository.deleteById(idLog);
    }

    public boolean update(int idLog, Log log) {
        Log lo = logRepository.findById(idLog);
        if(lo != null) {
            lo.setFechaCreacionLog(log.getFechaCreacionLog());
            lo.setOrigenServicio(log.getOrigenServicio());
            lo.setIdUsuario(log.getIdUsuario());
            lo.setDescripcionLog(log.getDescripcionLog());
            lo.setMensajeLog(log.getMensajeLog());

            logRepository.save(lo);
            return true;
        }else{
            return false;
        }
    }
    
}
