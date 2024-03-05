package edu.udelp.POO;

public class Materia {

	private Integer semestre;
	private String horario;
	private String nombre;
	private Carrera carrera;
	private String id;
	
	public Materia() {
		
	}
	
	
	public Materia(Integer semestre, String horario, String nombre, Carrera carrera, String id) {
	    this.nombre = nombre;
	    this.semestre = semestre;
	    this.horario = horario;
	    this.carrera = carrera; 
	    this.id = id;
	}

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public Integer getSemestre() {
		return semestre;
	}


	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}


	
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Carrera getCarrera() {
		return carrera;
	}
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
	@Override
	public String toString() {
		return "Materia [semestre=" + semestre + ", horario=" + horario + ", nombre=" + nombre + ", carrera=" + carrera
				+ "]";
	}
	

}
