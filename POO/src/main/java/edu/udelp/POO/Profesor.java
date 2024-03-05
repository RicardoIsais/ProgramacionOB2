package edu.udelp.POO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import edu.udelp.POO.Persona;


public class Profesor extends Persona {
	private Calendar fechaIngreso;
	private List<Materia> materias;
	
    public Profesor(String nombre, Calendar fechaNacimiento, String ID, char sexo, Calendar fechaIngreso) {
        super(nombre, fechaNacimiento, ID, sexo);
        this.fechaIngreso = fechaIngreso;
        this.materias = new ArrayList<>(); 
    }

	
	
	public Profesor(Calendar fechaIngreso,List<Materia> materias) {
		this.materias = materias;
		this.fechaIngreso=fechaIngreso;		
	}
	
	public List<Materia> getMaterias(){
		return materias;
	}

	public void setMaterias(List materias) {
		this.materias = materias;
		
	}
	public void addMateria(Materia materia) {
		this.materias.add(materia);
	}

	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String toString() {
		return "Profesor [fechaIngreso=" + fechaIngreso + ", materias=" + materias + "]";
	}
	
    public void imprimirMateriasAsignadas() {
        System.out.println("Materias asignadas al profesor:");
        for (Materia materia : materias) {
            System.out.println("ID: " + materia.getId() + ", Nombre: " + materia.getNombre());
        }
    }
	
	
	

}
