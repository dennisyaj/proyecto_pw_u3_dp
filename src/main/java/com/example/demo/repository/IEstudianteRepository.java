package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Estudiante;

import jakarta.transaction.Transactional;


public interface IEstudianteRepository {
	
 public void insertEstudiante(Estudiante estudiante);
 
 public void actualizarEstudiante(Estudiante estudiante);
 
 public Estudiante buscar(Integer id);
 
 public void eliminar(Integer id);
}
