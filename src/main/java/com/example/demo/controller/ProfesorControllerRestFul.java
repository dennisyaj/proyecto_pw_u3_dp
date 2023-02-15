package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

//	@GetMapping(path = "/id/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
//	public Profesor buscar(@PathVariable("id") Integer id) {
//		return this.iProfesorService.encontrar(id);
//	}
//
//	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
//	public List<Profesor> buscarTodos() {
//		return this.iProfesorService.encontrarTodos();
//	}

	@GetMapping(path = "/id/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Profesor buscar(@PathVariable("id") Integer id) {
		return this.iProfesorService.encontrar(id);
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Profesor> buscarTodos() {
		return this.iProfesorService.encontrarTodos();
	}

	@GetMapping("/cedula/{cedula}")
	public Profesor encontrarPorCedula(@PathVariable("cedula") String cedula) {
		return this.iProfesorService.encontrarPorCedula(cedula);
	}

	@DeleteMapping(path = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		this.iProfesorService.borrar(id);
	}

//	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
//	public void registrarProfesor(@RequestBody Profesor profesor) {
//		this.iProfesorService.registrarProfesor(profesor);
//	}
//
//	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
//	public void actualizarProfesor(@PathVariable("id") Integer id, @RequestBody Profesor profesor) {
//		profesor.setId(id);
//		this.iProfesorService.actualizarProfesor(profesor);
//	}

//	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE })
//	public void registrarProfesor(@RequestBody Profesor profesor) {
//		this.iProfesorService.registrarProfesor(profesor);
//	}
//
//	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE })
//	public void actualizarProfesor(@PathVariable("id") Integer id, @RequestBody Profesor profesor) {
//		profesor.setId(id);
//		this.iProfesorService.actualizarProfesor(profesor);
//	}

//	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE })
//	public ResponseEntity<Profesor> registrarProfesor(@RequestBody Profesor profesor) {
//		this.iProfesorService.registrarProfesor(profesor);
//		return ResponseEntity.status(HttpStatus.OK).body(profesor);
//	}
//
//	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE }, produces = {
//			MediaType.APPLICATION_XML_VALUE })
//	public ResponseEntity<Profesor> actualizarProfesor(@PathVariable("id") Integer id, @RequestBody Profesor profesor) {
//		profesor.setId(id);
//		this.iProfesorService.actualizarProfesor(profesor);
//		return ResponseEntity.status(HttpStatus.OK).body(this.iProfesorService.encontrar(id));
//
//	}
	
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Profesor> registrarProfesor(@RequestBody Profesor profesor) {
		this.iProfesorService.registrarProfesor(profesor);
		return ResponseEntity.status(HttpStatus.OK).body(profesor);
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Profesor> actualizarProfesor(@PathVariable("id") Integer id, @RequestBody Profesor profesor) {
		profesor.setId(id);
		this.iProfesorService.actualizarProfesor(profesor);
		return ResponseEntity.status(HttpStatus.OK).body(this.iProfesorService.encontrar(id));

	}
}
