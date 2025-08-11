package com.example.HourTrackerApi.repository;

import com.example.HourTrackerApi.model.UserT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserT, Long> {}
