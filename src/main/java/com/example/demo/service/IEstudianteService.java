package com.example.demo.service;

import com.example.demo.model.Estudiante;

public interface IEstudianteService {

	public void registrarEstudiante(Estudiante estudiante);

	public void actualizarEstudiante(Estudiante estudiante);

	public Estudiante encontrar(Integer id);

	public void borrar(Integer id);

}
