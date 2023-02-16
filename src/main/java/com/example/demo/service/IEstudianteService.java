package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.model.Estudiante;
import com.example.demo.service.to.EstudianteTo;

public interface IEstudianteService {

	public void registrarEstudiante(Estudiante estudiante);

	public void actualizarEstudiante(Estudiante estudiante);

	public Estudiante encontrar(Integer id);

	public List<Estudiante> encontrarTodos();

	public List<Estudiante> encontrarTodosPorSalario(BigDecimal salario);

	public void borrar(Integer id);
	
	public List<EstudianteTo> encontrarTodosTo();

}
