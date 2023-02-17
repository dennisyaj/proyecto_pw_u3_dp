package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Estudiante;
import com.example.demo.model.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Materia> buscarPorEstudiante(Integer id) {
		TypedQuery<Materia> query = this.entityManager
				.createQuery("SELECT m FROM Materia m WHERE m.estudiante.id =: id", Materia.class);
		query.setParameter("id", id);
		return query.getResultList();
	}

	@Override
	public Materia buscar(Integer id) {
		return this.entityManager.find(Materia.class, id);
	}
}
