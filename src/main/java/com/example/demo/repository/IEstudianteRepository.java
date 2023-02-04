package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Estudiante;

import jakarta.transaction.Transactional;

public interface IEstudianteRepository {

	public void insertEstudiante(Estudiante estudiante);

	public void actualizarEstudiante(Estudiante estudiante);

	public Estudiante buscar(Integer id);

	public void eliminar(Integer id);

	public List<Estudiante> buscarNombre(String nombre);

	public List<Estudiante> buscarApe(String apellido);
}
