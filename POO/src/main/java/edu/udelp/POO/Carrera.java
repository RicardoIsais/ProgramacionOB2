package edu.udelp.POO;

public class Carrera {
	private String nombre;
	private String id;
	


	public Carrera(String nombre,String id) {
		this.nombre = nombre;
		this.id=id;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Carrera [nombre=" + nombre + ", id=" + id + "]";
	}



}
