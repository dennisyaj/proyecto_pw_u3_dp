package com.example.demo.service.to;

import java.io.Serializable;

public class MateriaNuevaTo implements Serializable {

	private String nombre;

	private Integer creditos;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

}
