package com.example.HourTrackerApi.service;

import com.example.HourTrackerApi.model.UserT;
import com.example.HourTrackerApi.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository repository;
    @Override
    public List<UserT> traerTodos() {
        return repository.findAll();
    }
    @Override
    public UserT encontrarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Usuario No Encontrado"));
    }

    @Override
    public UserT guardarUser(UserT user) {
        return repository.save(user);
    }
    @Override
    public UserT actualizarUser(Long id, UserT userT) {
        UserT existing = encontrarPorId(id);
        existing.setUserName(userT.getUserName());
        existing.setUserPass(userT.getUserPass());
        return repository.save(existing);
    }
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
