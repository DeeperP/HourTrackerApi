package com.example.HourTrackerApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "semanal_goals")
@Getter
@Setter
public class SemanalGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private Long id;

    @Column(name = "horas_trabajadas", nullable = false)
    private int horasTrabajadas;

    @Column(name = "nombre_objetivo", nullable = false, length = 100)
    private String nombreObjetivo;

    @Column(name = "objetivo_logrado", nullable = false)
    private Boolean objetivoLogrado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserT userT;

    // Relación 1:N con BloquesPomodoro
    @OneToMany(mappedBy = "objetivoSemanal", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<BloquesPomodoro> bloquesPomodoro = new ArrayList<>();

    public SemanalGoal() {
    }

    public SemanalGoal(Long id, int horasTrabajadas, String nombreObjetivo, Boolean objetivoLogrado, UserT userT, List<BloquesPomodoro> bloquesPomodoro) {
        this.id = id;
        this.horasTrabajadas = horasTrabajadas;
        this.nombreObjetivo = nombreObjetivo;
        this.objetivoLogrado = objetivoLogrado;
        this.userT = userT;
        this.bloquesPomodoro = bloquesPomodoro;
    }
}
