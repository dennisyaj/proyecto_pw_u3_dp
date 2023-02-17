package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.model.Materia;
import com.example.demo.repository.IMateriaRepository;
import com.example.demo.service.to.EstudiantenuevoTo;
import com.example.demo.service.to.MateriaNuevaTo;
import com.example.demo.service.to.MateriaTo;

@Service
public class MateriaServiceImpl implements IMateriaService {
	@Autowired
	private IMateriaRepository iMateriaRepository;

	@Override
	public List<MateriaTo> buscarPorEstudiante(Integer id) {
		List<Materia> lista = this.iMateriaRepository.buscarPorEstudiante(id);
		return lista.stream().map(m -> this.convertir(m)).collect(Collectors.toList());
	}

	private MateriaTo convertir(Materia materia) {
		MateriaTo materiaTo = new MateriaTo();
		materiaTo.setCreditos(materia.getCreditos());
		materiaTo.setId(materia.getId());
		materiaTo.setNombre(materia.getNombre());
		return materiaTo;
	}

	private MateriaNuevaTo convertir2(Materia materia) {
		MateriaNuevaTo materiaTo = new MateriaNuevaTo();
		materiaTo.setCreditos(materia.getCreditos());
		materiaTo.setNombre(materia.getNombre());
		return materiaTo;
	}

	@Override
	public MateriaNuevaTo buscarMateria(Integer id) {
		return this.convertir2(this.iMateriaRepository.buscar(id));
	}
}
