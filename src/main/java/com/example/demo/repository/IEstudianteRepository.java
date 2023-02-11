package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Estudiante;

import jakarta.transaction.Transactional;

public interface IEstudianteRepository {

	public void insertEstudiante(Estudiante estudiante);

	public void actualizarEstudiante(Estudiante estudiante);

	public Estudiante buscar(Integer id);

	public List<Estudiante> buscarTodos();

	public List<Estudiante> buscarTodosPorSalario(BigDecimal salario);

	public void eliminar(Integer id);
	
}
