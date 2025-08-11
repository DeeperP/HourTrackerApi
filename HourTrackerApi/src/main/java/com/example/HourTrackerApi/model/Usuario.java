package com.example.HourTrackerApi.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
@Getter@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Email(message = "El correo debe tener un formato válido")
    @NotBlank(message = "El correo es obligatorio")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    private String password;
    @NotBlank(message = "El Usuario es obligatorio")
    private String nickname;

    @OneToMany
    private List<PomodoroSession> pomodoro;
    @OneToOne
    private ObjetivoSemana objetive;
    @OneToMany
    private List<Calendario> studyDays;

    public Usuario() {
    }

    public Usuario(Long id, String email, String password, String nickname, List<PomodoroSession> pomodoro, ObjetivoSemana objetive, List<Calendario> studyDays) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.pomodoro = pomodoro;
        this.objetive = objetive;
        this.studyDays = studyDays;
    }
}
