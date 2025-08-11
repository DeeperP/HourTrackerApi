package com.example.HourTrackerApi.repository;

import com.example.HourTrackerApi.model.BloquesPomodoro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloquesPomodoroRepository extends JpaRepository<BloquesPomodoro, Long> {}

