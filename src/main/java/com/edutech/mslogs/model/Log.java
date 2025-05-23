package com.edutech.mslogs.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "log")

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int idLog;

    @Column(nullable = false)
    private LocalDate fechaCreacionLog;

    @Column(length = 20, nullable = false)
    private String origenServicio;

    @Column(nullable = false)
    private int idUsuario;

    @Column(length = 500, nullable = false)
    private String descripcionLog;

    @Column(length = 500, nullable = false)
    private String mensajeLog;

}
