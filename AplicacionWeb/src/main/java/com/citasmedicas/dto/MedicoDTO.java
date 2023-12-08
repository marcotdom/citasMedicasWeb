package com.citasmedicas.dto;

public class MedicoDTO {
	
	private int id;
	private String nombre;
	private String apellido;
	private String especialidad;
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public MedicoDTO(int id, String nombre, String apellido, String especialidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.especialidad = especialidad;
		this.apellido = apellido;
	}
	public MedicoDTO() {
		super();
	}
}
