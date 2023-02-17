package com.example.demo.service;

import java.util.List;

import com.example.demo.service.to.MateriaNuevaTo;
import com.example.demo.service.to.MateriaTo;

public interface IMateriaService {
	List<MateriaTo> buscarPorEstudiante(Integer id);

	MateriaNuevaTo buscarMateria(Integer id);
}
