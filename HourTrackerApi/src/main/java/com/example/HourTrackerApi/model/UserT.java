package com.example.HourTrackerApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class UserT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String userName;

    @Column(nullable = false)
    private String userPass;

    // Relación 1:N con PomodoroSession
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PomodoroSession> sesionesPomodoro = new ArrayList<>();

    // Relación 1:N con SemanalGoal
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<SemanalGoal> objetivosSemanales = new ArrayList<>();

    public UserT() {
    }

    public UserT(Long u_id, String userName, String userPass, List<PomodoroSession> sesionesPomodoro, List<SemanalGoal> objetivoSemanal) {
        this.id = u_id;
        this.userName = userName;
        this.userPass = userPass;
        this.sesionesPomodoro = sesionesPomodoro;
        this.objetivosSemanales = objetivoSemanal;
    }
}
