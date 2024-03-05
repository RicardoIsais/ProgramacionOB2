package edu.udelp.POO;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import lombok.Data;

@Data

public class Persona {
	
	private String nombre;
	private Calendar fechaNacimiento;
	private String ID;
	private Character sexo;
	private Double peso;
	private Double altura;

	public Persona() { // Constructor vacío
	}
	public Persona(String nombre, Calendar fechaNacimiento, String ID, char sexo) {
	    this.nombre = nombre;
	    this.fechaNacimiento = fechaNacimiento;
	    this.ID = ID;
	    this.sexo = sexo;
	}

	public Persona(String nombre, Calendar fechaNacimiento, char sexo) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
	}

	public Persona(String nombre, Calendar fechaNacimiento, String ID, char sexo, double peso, double altura) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.ID = ID;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public String toString() {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MMM/yyyy");
		String fechaFormateada = formatoFecha.format(fechaNacimiento.getTime());
		return "Persona:" + "nombre='" + nombre + '\'' + ", fechaNacimiento=" + fechaFormateada + ", ID='" + ID + '\''
				+ ", sexo=" + sexo + ", peso=" + peso + ", altura=" + altura;
	}
	
	
	
	
	
   
	
	

}
