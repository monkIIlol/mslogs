package com.edutech.mslogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.mslogs.model.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {

    List<Log> findAll();

    Log getIdLog(int idLog);

    @SuppressWarnings("unchecked")
    Log save(Log log);
    
}
