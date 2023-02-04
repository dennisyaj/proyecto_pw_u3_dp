package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Estudiante;

public interface IEstudianteService {

	public void registrarEstudiante(Estudiante estudiante);

	public void actualizarEstudiante(Estudiante estudiante);

	public Estudiante encontrar(Integer id);

	public void borrar(Integer id);
	
	public List<Estudiante> buscarPorNombre(String nombre);

	public List<Estudiante> buscarPorApellido(String apellido);

}
