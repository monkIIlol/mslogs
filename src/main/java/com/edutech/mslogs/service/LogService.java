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
    
}
