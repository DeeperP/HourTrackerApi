package com.example.HourTrackerApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "bloques_pomodoro")
@Getter
@Setter
public class BloquesPomodoro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "block_id")
    private Long id;

    @Column(name = "nombre_bloque", nullable = false, length = 100)
    private String nombreBloque;

    @Column(name = "hora_inicio", nullable = false)
    private LocalDateTime horaDeInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalDateTime horaDeFinalizacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id", nullable = false)
    private PomodoroSession sesionPomodoro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goal_id")
    private SemanalGoal objetivoSemanal;

    public BloquesPomodoro() {
    }

    public BloquesPomodoro(Long id, String nombreBloque, LocalDateTime horaDeInicio, LocalDateTime horaDeFinalizacion, PomodoroSession sesionPomodoro, SemanalGoal objetivoSemanal) {
        this.id = id;
        this.nombreBloque = nombreBloque;
        this.horaDeInicio = horaDeInicio;
        this.horaDeFinalizacion = horaDeFinalizacion;
        this.sesionPomodoro = sesionPomodoro;
        this.objetivoSemanal = objetivoSemanal;
    }
}
