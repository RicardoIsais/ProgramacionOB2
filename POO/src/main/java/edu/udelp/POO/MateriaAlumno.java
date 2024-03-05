package edu.udelp.POO;

public class MateriaAlumno extends Materia {
	
    private Materia materia;
	private Double primerParcial;
	private Double segundoParcial;
	private Double proyecto;
	private Double examenFinal;
	
	
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	public Double getPrimerParcial() {
		return primerParcial;
	}
	public void setPrimerParcial(Double primerParcial) {
		this.primerParcial = primerParcial;
	}
	public Double getSegundoParcial() {
		return segundoParcial;
	}
	public void setSegundoParcial(Double segundoParcial) {
		this.segundoParcial = segundoParcial;
	}
	public Double getProyecto() {
		return proyecto;
	}
	public void setProyecto(Double proyecto) {
		this.proyecto = proyecto;
	}
	public Double getExamenFinal() {
		return examenFinal;
	}
	public void setExamenFinal(Double examenFinal) {
		this.examenFinal = examenFinal;
	}
	@Override
	public String toString() {
		return "MateriaAlumno [primerParcial=" + primerParcial + ", segundoParcial=" + segundoParcial + ", proyecto="
				+ proyecto + ", examenFinal=" + examenFinal + "]";
	}
	
	
	

}
