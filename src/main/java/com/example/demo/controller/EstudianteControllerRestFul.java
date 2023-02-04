package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Estudiante;
import com.example.demo.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {

	@Autowired
	IEstudianteService iEstudianteService;

	@PostMapping("")
	public void registrarEstudiante(Estudiante estudiante) {
	}

	@PutMapping(path = "/{id}")
	public void actualizarEstudiante(@PathVariable("id") Integer id, Estudiante estudiante) {
	this.iEstudianteService.actualizarEstudiante(estudiante);
	}

	@PutMapping
	public void actualizartodosEstudiante(Estudiante estudiante) {
	}

	@GetMapping(path = "/{id}")
	public Estudiante encontrar(@PathVariable("id") Integer id) {
		return this.iEstudianteService.encontrar(id);
	}

	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable("id") Integer id) {
		this.iEstudianteService.borrar(id);
	}
}
