package com.example.HourTrackerApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter@Setter
public class SemanalGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sg_id;
    private int horas_trabajadas;
    private String nombre_Objetivo;
    private Boolean objetivoLogrado;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<BloquesPomodoro> sesionesPomodoro;

    public SemanalGoal() {
    }

    public SemanalGoal(Long sg_id, int horas_trabajadas, String nombre_Objetivo, Boolean objetivoLogrado, User user, List<BloquesPomodoro> sesionesPomodoro) {
        this.sg_id = sg_id;
        this.horas_trabajadas = horas_trabajadas;
        this.nombre_Objetivo = nombre_Objetivo;
        this.objetivoLogrado = objetivoLogrado;
        this.user = user;
        this.sesionesPomodoro = sesionesPomodoro;
    }
}
