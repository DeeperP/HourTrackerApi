package com.example.HourTrackerApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter@Setter
public class BloquesPomodoro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bp_id;
    private String nombre_Bloque;
    private LocalDateTime horaDeInicio, horaDeFinalizacion;

    @ManyToOne
    @JoinColumn(name = "Sesiones_Pomodoro")
    private PomodoroSession sesionPomodoro;

    @ManyToOne
    private SemanalGoal obetivoSemanal;

    public BloquesPomodoro() {
    }

    public BloquesPomodoro(Long bp_id, String nombre_Bloque, LocalDateTime horaDeInicio, LocalDateTime horaDeFinalizacion, PomodoroSession sesionPomodoro, SemanalGoal obetivoSemanal) {
        this.bp_id = bp_id;
        this.nombre_Bloque = nombre_Bloque;
        this.horaDeInicio = horaDeInicio;
        this.horaDeFinalizacion = horaDeFinalizacion;
        this.sesionPomodoro = sesionPomodoro;
        this.obetivoSemanal = obetivoSemanal;
    }
}
