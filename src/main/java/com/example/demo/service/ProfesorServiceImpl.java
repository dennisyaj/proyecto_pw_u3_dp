package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Profesor;
import com.example.demo.repository.IProfesorRepository;

@Service
public class ProfesorServiceImpl implements IProfesorService {
	
	@Autowired
	private IProfesorRepository iProfesorRepository;

	@Override
	public void registrarProfesor(Profesor profesor) {
		this.iProfesorRepository.insertProfesor(profesor);
	}

	@Override
	public void actualizarProfesor(Profesor profesor) {
		this.iProfesorRepository.actualizarProfesor(profesor);
	}

	@Override
	public Profesor encontrar(Integer id) {
		return this.iProfesorRepository.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		this.iProfesorRepository.eliminar(id);
	}

	@Override
	public Profesor encontrarPorCedula(String cedula) {
		return this.iProfesorRepository.buscarPorCedula(cedula);
	}

}
