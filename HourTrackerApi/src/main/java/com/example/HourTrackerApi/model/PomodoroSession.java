package com.example.HourTrackerApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter@Setter
public class PomodoroSession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ps_id;

    private int horasTrabajadas;
    private LocalDateTime horaDeInicio, horaDeFinalizacion;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User usuario;

    @OneToMany
    @JoinColumn(name = "BloquesDeTrabajo")
    List<BloquesPomodoro> bloquesPomodoro;

    public PomodoroSession() {
    }

    public PomodoroSession(Long ps_id, int horasTrabajadas, LocalDateTime horaDeInicio, LocalDateTime horaDeFinalizacion, User usuario, List<BloquesPomodoro> bloquesPomodoro) {
        this.ps_id = ps_id;
        this.horasTrabajadas = horasTrabajadas;
        this.horaDeInicio = horaDeInicio;
        this.horaDeFinalizacion = horaDeFinalizacion;
        this.usuario = usuario;
        this.bloquesPomodoro = bloquesPomodoro;
    }
}
