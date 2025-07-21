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
    private Long id;

    private int horasTrabajadas;
    private LocalDateTime horaDeInicio;
    private  LocalDateTime horaDeFinalizacion;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn (name = "study_days_id")
    private List<Calendario> diasDeEstudio;

    public PomodoroSession() {
    }

    public PomodoroSession(Long id, int horasTrabajadas, LocalDateTime horaDeInicio, LocalDateTime horaDeFinalizacion, Usuario usuario, List<Calendario> diasDeEstudio) {
        this.id = id;
        this.horasTrabajadas = horasTrabajadas;
        this.horaDeInicio = horaDeInicio;
        this.horaDeFinalizacion = horaDeFinalizacion;
        this.usuario = usuario;
        this.diasDeEstudio = diasDeEstudio;
    }
}
