package com.example.HourTrackerApi.service;

import com.example.HourTrackerApi.model.UserT;

import java.util.List;

public interface IUserService {

    List<UserT> traerTodos();

    UserT encontrarPorId(Long id);

    UserT guardarUser(UserT user);

    UserT actualizarUser(Long id, UserT user);
}
