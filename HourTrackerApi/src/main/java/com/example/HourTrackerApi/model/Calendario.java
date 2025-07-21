package com.example.HourTrackerApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter@Setter
public class Calendario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_calendar;

    @Column (name = "Logrado")
    private boolean diaEstudiado;

    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Usuario user;

    @OneToMany
    private List<PomodoroSession> pomodoroSessions;

    public Calendario() {
    }

    public Calendario(Long id_calendar, boolean diaEstudiado, LocalDate date, Usuario user, List<PomodoroSession> pomodoroSessions) {
        this.id_calendar = id_calendar;
        this.diaEstudiado = diaEstudiado;
        this.date = date;
        this.user = user;
        this.pomodoroSessions = pomodoroSessions;
    }
}
