package edu.udelp.POO;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import edu.udelp.POO.MateriaAlumno;

import edu.udelp.POO.Materia; 

public class Estudiante extends Persona {
	private Integer semestre;
	private List materias;
	private String generacion;
	private Carrera carrera;
	private List<MateriaAlumno> calificaciones;
	
	public Estudiante(String nombre, Calendar fechaNacimiento, String ID, char sexo,Integer semestre,String generacion) {
	    super(nombre, fechaNacimiento, ID, sexo); 
		this.semestre=semestre;
		this.generacion=generacion;
		this.calificaciones = new ArrayList<>();
	    
	}
	
	public Estudiante(Integer semestre,List materias,String generacion, Carrera carrera) {
		this.materias = materias;
		this.semestre=semestre;
		this.generacion=generacion;
		this.carrera=carrera;
		
	}
    public List<MateriaAlumno> getCalificaciones() {
        return calificaciones;
    }

    public void agregarCalificaciones(MateriaAlumno calificaciones) {
        this.calificaciones.add(calificaciones);
    }
	


	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public List getMaterias() {
		return materias;
	}

	public void setMaterias(List materias) {
		this.materias = materias;
	}

	public String getGeneracion() {
		return generacion;
	}

	public void setGeneracion(String generacion) {
		this.generacion = generacion;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	@Override
	public String toString() {
		return "Estudiante [semestre=" + semestre + ", materias=" + materias + ", generacion=" + generacion
				+ ", carrera=" + carrera + "]";
	}
    public MateriaAlumno buscarCalificacionesPorMateria(Materia materia) {
        
        List<MateriaAlumno> calificacionesAlumno = this.calificaciones;
        if (calificacionesAlumno != null) {
            for (MateriaAlumno calificacion : calificacionesAlumno) {
                if (calificacion.getMateria().equals(materia)) {
                    return calificacion;
                }
            }
        }
        return null; 
    }
	
	
	

}
