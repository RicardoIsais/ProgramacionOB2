package edu.udelp.POO;
import edu.udelp.POO.Carrera;
import edu.udelp.POO.Materia;
import edu.udelp.POO.Profesor;
import edu.udelp.POO.Estudiante;
import edu.udelp.POO.MateriaAlumno;
import java.util.List;

public class ProcesosEscuela {
	public static Carrera buscarCarreraPorId(List<Carrera> carreras, String idCarrera) {
	    for (Carrera carrera : carreras) {
	        if (carrera.getId().equals(idCarrera)) {
	            return carrera;
	        }
	    }
	    return null; 
	}
	public static Profesor buscarProfesorPorId(List<Profesor> profesores, String idProfesor) {
	    for (Profesor profesor : profesores) {
	        if (profesor.getID().equals(idProfesor)) {
	            return profesor;
	        }
	    }
	    return null; 
	}
	public static Materia buscarMateriaPorId(List<Materia> materias, String idMateria) {
	    for (Materia materia : materias) {
	        if (materia.getId().equals(idMateria)) {
	            return materia;
	        }
	    }
	    return null; 
	}
   
	public Estudiante buscarEstudiantePorId(List<Estudiante> estudiantes, String idEstudiante) {
	    for (Estudiante estudiante : estudiantes) {
	        if (estudiante.getID().equals(idEstudiante)) {
	            return estudiante;
	        }
	    }
	    return null;
	}
    public boolean carreraTieneMaterias(List<Materia> materias, Carrera carrera) {
        for (Materia materia : materias) {
            if (materia.getCarrera().equals(carrera)) {
                return true;
            }
        }
        return false;
    }
    public static double calcularPromedioMateria(MateriaAlumno calificacionesMateria) {
        double primerParcial = calificacionesMateria.getPrimerParcial();
        double segundoParcial = calificacionesMateria.getSegundoParcial();
        double proyecto = calificacionesMateria.getProyecto();
        double examenFinal = calificacionesMateria.getExamenFinal();
        return ((primerParcial + segundoParcial) / 2) * 0.5 + proyecto * 0.25 + examenFinal * 0.25;

    }
    public static boolean esCalificacionValida(String calificacionCadena) {
        try {
            double calificacion = Double.parseDouble(calificacionCadena);
            return calificacion >= 0 && calificacion <= 100;
        } catch (NumberFormatException e) {
            return false;
        }
    }





}
