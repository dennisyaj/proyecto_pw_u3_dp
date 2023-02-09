package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Profesor;
import com.example.demo.service.IProfesorService;

@RestController
@RequestMapping("/profesores")
public class ProfesorControllerRestFul {

	@Autowired
	private IProfesorService iProfesorService;

	@GetMapping(path = "/id/{id}")
	public Profesor buscar(@PathVariable("id") Integer id) {
		return this.iProfesorService.encontrar(id);
	}

	@GetMapping("/cedula/{cedula}")
	public Profesor encontrarPorCedula(@PathVariable("cedula") String cedula) {
		return this.iProfesorService.encontrarPorCedula(cedula);
	}

	@DeleteMapping(path = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		this.iProfesorService.borrar(id);
	}

	@PostMapping
	public void registrarProfesor(@RequestBody Profesor profesor) {
		this.iProfesorService.registrarProfesor(profesor);
	}

	@PutMapping(path = "/{id}")
	public void actualizarProfesor(@PathVariable("id") Integer id, @RequestBody Profesor profesor) {
		profesor.setId(id);
		this.iProfesorService.actualizarProfesor(profesor);
	}

}
