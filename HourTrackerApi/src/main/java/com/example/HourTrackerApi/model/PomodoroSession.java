package com.example.HourTrackerApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pomodoro_sessions")
@Getter
@Setter
public class PomodoroSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private Long id;

    @Column(nullable = false)
    private int horasTrabajadas;

    @Column(name = "hora_inicio", nullable = false)
    private LocalDateTime horaDeInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalDateTime horaDeFinalizacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserT usuario;

    @OneToMany(mappedBy = "pomodoroSession", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<BloquesPomodoro> bloquesPomodoro = new ArrayList<>();

    public PomodoroSession() {
    }

    public PomodoroSession(Long id, int horasTrabajadas, LocalDateTime horaDeInicio, LocalDateTime horaDeFinalizacion, UserT usuario, List<BloquesPomodoro> bloquesPomodoro) {
        this.id = id;
        this.horasTrabajadas = horasTrabajadas;
        this.horaDeInicio = horaDeInicio;
        this.horaDeFinalizacion = horaDeFinalizacion;
        this.usuario = usuario;
        this.bloquesPomodoro = bloquesPomodoro;
    }
}
