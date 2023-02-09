package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Estudiante;
import com.example.demo.repository.IEstudianteRepository;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository iEstudianteRepository;

	@Override
	public void registrarEstudiante(Estudiante estudiante) {
		this.iEstudianteRepository.actualizarEstudiante(estudiante);
	}

	@Override
	public void actualizarEstudiante(Estudiante estudiante) {
		this.iEstudianteRepository.actualizarEstudiante(estudiante);
	}

	@Override
	public Estudiante encontrar(Integer id) {
		return this.iEstudianteRepository.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		this.iEstudianteRepository.eliminar(id);
	}

	@Override
	public List<Estudiante> encontrarTodos() {
		return this.iEstudianteRepository.buscarTodos();
	}

	@Override
	public List<Estudiante> encontrarTodosPorSalario(BigDecimal salario) {
		return this.iEstudianteRepository.buscarTodosPorSalario(salario);
	}

}
