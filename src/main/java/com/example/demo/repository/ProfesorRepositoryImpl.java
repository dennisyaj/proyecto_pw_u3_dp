package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Profesor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProfesorRepositoryImpl implements IProfesorRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertProfesor(Profesor profesor) {
		this.entityManager.persist(profesor);
	}

	@Override
	public void actualizarProfesor(Profesor profesor) {
		this.entityManager.merge(profesor);
	}

	@Override
	public Profesor buscar(Integer id) {
		return this.entityManager.find(Profesor.class, id);
	}

	@Override
	public List<Profesor> buscarTodos() {
		TypedQuery<Profesor> query = this.entityManager.createQuery("SELECT p FROM Profesor p ", Profesor.class);
		return query.getResultList();
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public Profesor buscarPorCedula(String cedula) {
		TypedQuery<Profesor> query = this.entityManager
				.createQuery("SELECT p FROM Profesor p WHERE p.cedula = :cedula ", Profesor.class);
		query.setParameter("cedula", cedula);
		return query.getSingleResult();
	}

}
