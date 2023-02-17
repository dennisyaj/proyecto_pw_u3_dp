package com.example.demo.repository;
import java.util.List;

import com.example.demo.model.Materia;
import com.example.demo.service.to.MateriaTo;

public interface IMateriaRepository {
 List<Materia> buscarPorEstudiante(Integer id);
 Materia buscar(Integer id);
 
}
