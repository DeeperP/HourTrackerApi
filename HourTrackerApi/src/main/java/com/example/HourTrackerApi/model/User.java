package com.example.HourTrackerApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long u_id;
    private String userName, userPass;

    @OneToMany
    @JoinTable(
            name = "SesionesPomodoro_Usuario",
            joinColumns = @JoinColumn(name = "SesionesPomodoro_id"),
            inverseJoinColumns = @JoinColumn(name = "Usuario_id")
    )
    List<PomodoroSession> sesionesPomodoro;

    @OneToMany
    @JoinTable(
            name = "ObjetivoSemanal_Usuario",
            joinColumns = @JoinColumn(name = "ObjetivoSemanal_id"),
            inverseJoinColumns = @JoinColumn(name = "Usuario_id")
    )
    List<SemanalGoal> objetivoSemanal;

    public User() {
    }

    public User(Long u_id, String userName, String userPass, List<PomodoroSession> sesionesPomodoro, List<SemanalGoal> objetivoSemanal) {
        this.u_id = u_id;
        this.userName = userName;
        this.userPass = userPass;
        this.sesionesPomodoro = sesionesPomodoro;
        this.objetivoSemanal = objetivoSemanal;
    }
}
