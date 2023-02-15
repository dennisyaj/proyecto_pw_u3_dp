package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Profesor;

public interface IProfesorService {

	public void registrarProfesor(Profesor profesor);

	public void actualizarProfesor(Profesor profesor);

	public Profesor encontrar(Integer id);

	public void borrar(Integer id);

	public Profesor encontrarPorCedula(String cedula);

	public List<Profesor> encontrarTodos();

	
}
