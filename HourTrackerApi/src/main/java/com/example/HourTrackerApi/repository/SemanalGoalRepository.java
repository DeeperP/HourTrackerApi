package com.example.HourTrackerApi.repository;

import com.example.HourTrackerApi.model.SemanalGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemanalGoalRepository extends JpaRepository<SemanalGoal, Long> {}


