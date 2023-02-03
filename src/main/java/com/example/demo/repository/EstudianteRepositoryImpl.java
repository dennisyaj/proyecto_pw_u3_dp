package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.model.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class EstudianteRepositoryImpl implements IEstudianteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertEstudiante(Estudiante estudiante) {
		this.entityManager.persist(estudiante);

	}

	@Override
	public void actualizarEstudiante(Estudiante estudiante) {
		this.entityManager.merge(estudiante);

	}

	@Override
	public Estudiante buscar(Integer id) {
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.buscar(id));
	}

}
