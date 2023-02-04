package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Estudiante;
import com.example.demo.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {
	//http://localhost:8080/API/Matricula/V1/estudiantes/

	@Autowired
	IEstudianteService iEstudianteService;

	public void registrarEstudiante(Estudiante estudiante) {
	}

	public void actualizarEstudiante(Estudiante estudiante) {
	}

	@GetMapping(path = "/buscar/{id}")
	public Estudiante encontrar(@PathVariable("id") Integer id) {
		return this.iEstudianteService.encontrar(id);
	}

	@GetMapping("/buscarPorNombre/{nombre}")
	public List<Estudiante> buscarPorNombre(@PathVariable("nombre") String nombre) {
		return this.iEstudianteService.buscarPorNombre(nombre);
	}

	@GetMapping("/buscarPorApellido/{apellido}")
	public List<Estudiante> buscarPorApellido(@PathVariable("apellido") String apellido) {
		return this.iEstudianteService.buscarPorApellido(apellido);
	}
}
