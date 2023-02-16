package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Estudiante;
import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.service.to.EstudianteTo;

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

	@Override
	public List<EstudianteTo> encontrarTodosTo() {
		List<Estudiante> estudiantes = this.iEstudianteRepository.buscarTodos();
		return estudiantes.stream().map(e->this.convertir(e)).collect(Collectors.toList());
	}
	private EstudianteTo convertir(Estudiante estudiante) {
		EstudianteTo estu =new EstudianteTo();
		estu.setId(estudiante.getId());
		estu.setFechaNacimiento(estudiante.getFechaNacimiento());
		estu.setNombre(estudiante.getNombre());
		estu.setApellido(estudiante.getApellido());
		return estu;
	}

}
