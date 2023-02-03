package com.example.demo.controller;

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
	
	@Autowired
	IEstudianteService iEstudianteService ;

	public void registrarEstudiante(Estudiante estudiante) {
	}

	public void actualizarEstudiante(Estudiante estudiante) {
	}

	@GetMapping(path = "/buscar/{id}")
	public Estudiante encontrar(@PathVariable("id") Integer id) {
		return this.iEstudianteService.encontrar(id);
	}

	public void borrar(Integer id) {
	}
}
