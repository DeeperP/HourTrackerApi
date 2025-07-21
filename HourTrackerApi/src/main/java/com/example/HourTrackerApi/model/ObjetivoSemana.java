package com.example.HourTrackerApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter@Setter
public class ObjetivoSemana {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_Objetivo;

    @Column (name = "Logrado")
    private boolean objetivoConseguido;

    @Column (name = "Objetivo")
    private int objetivoDeHoras;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Usuario user;

    @OneToMany
    private List<PomodoroSession> pomodoroSessions;

    public ObjetivoSemana() {
    }

    public ObjetivoSemana(Long id_Objetivo, boolean objetivoConseguido, Usuario user, List<PomodoroSession> pomodoroSessions) {
        this.id_Objetivo = id_Objetivo;
        this.objetivoConseguido = objetivoConseguido;
        this.user = user;
        this.pomodoroSessions = pomodoroSessions;
    }
}
