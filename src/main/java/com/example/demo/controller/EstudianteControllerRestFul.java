package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Estudiante;
import com.example.demo.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {

	@Autowired
	IEstudianteService iEstudianteService;

	@PostMapping
	public void registrarEstudiante(@RequestBody Estudiante estudiante) {
		this.iEstudianteService.registrarEstudiante(estudiante);
	}

	@PutMapping(path = "/{id}",consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_XML_VALUE )
	public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable("id") Integer id, @RequestBody Estudiante estudiante,
			@RequestParam("provincia") String provinvia) {
		System.out.println(provinvia);
		estudiante.setId(id);
		this.iEstudianteService.actualizarEstudiante(estudiante);
		return ResponseEntity.status(HttpStatus.OK).body(this.iEstudianteService.encontrar(id));
	
	}

	@PutMapping
	public void actualizartodosEstudiante(Estudiante estudiante) {
		this.iEstudianteService.actualizarEstudiante(estudiante);
	}

	@GetMapping(path = "/{id}",produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Estudiante> encontrar(@PathVariable("id") Integer id) {
		Estudiante estu = this.iEstudianteService.encontrar(id);
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(estu);
	}

	@GetMapping
	public ResponseEntity<List<Estudiante>> encontrarTodos() {
		HttpHeaders cabezeras = new HttpHeaders();
		cabezeras.add("detalleMensaje", "Estudiante encontrado");
		cabezeras.add("valorCalcualdo", "100 ");
		return new ResponseEntity<>(this.iEstudianteService.encontrarTodos(), cabezeras, 230);
	}

	@GetMapping(path = "/salario")
	public List<Estudiante> encontrarTodosPorSalario(@RequestParam("salario") BigDecimal salario) {
		return this.iEstudianteService.encontrarTodosPorSalario(salario);
	}

	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable("id") Integer id) {
		this.iEstudianteService.borrar(id);
	}

	@PostMapping(path = "/borrar/{id}")
	public void borrarTemp(@PathVariable("id") Integer id) {
		this.iEstudianteService.borrar(id);
	}
}
