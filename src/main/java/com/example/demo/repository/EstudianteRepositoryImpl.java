package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.model.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
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

	@Override
	public List<Estudiante> buscarNombre(String nombre) {
		TypedQuery<Estudiante> myQuery = this.entityManager
				.createQuery("SELECT e FROM Estudiante e WHERE e.nombre=:nombre", Estudiante.class);
		myQuery.setParameter("nombre", nombre);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarApe(String apellido) {
		TypedQuery<Estudiante> myQuery = this.entityManager
				.createQuery("SELECT e FROM Estudiante e WHERE e.apellido=:apellido", Estudiante.class);
		myQuery.setParameter("apellido", apellido);
		return myQuery.getResultList();
	}

}
