package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Profesor;

public interface IProfesorRepository {

	public void insertProfesor(Profesor profesor);

	public void actualizarProfesor(Profesor profesor);

	public Profesor buscar(Integer id);

	public void eliminar(Integer id);

	public Profesor buscarPorCedula(String cedula);

	public List<Profesor> buscarTodos();
}
