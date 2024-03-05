package edu.udelp.POO;

import java.util.Random;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import edu.udelp.POO.Persona;

public class ProcesosPersona {
	public int calcularIMC(Persona persona) {
		int respuesta;
		double imc;
		imc = persona.getPeso() / Math.pow(persona.getAltura(), 2);
		if (imc < 20) {
			respuesta = -1;
		} else if (imc >= 20 && imc <= 25) {
			respuesta = 0;
		} else {
			respuesta = 1;
		}
		return respuesta;
	}

	public int indiceDeId(Persona[] personas, String id) {
		int indice = -1;
		for (int i = 0; i < personas.length; i++) {
			if (personas[i] != null && personas[i].getID().equals(id)) {
				indice = i;
				break;
			}
		}
		return indice;
	}

	public String generaID() {
		int num;
		Random rnd;
		rnd = new Random();
		num = 10000000 + rnd.nextInt(90000000); // Un número aleatorio de 8 cifras
		return Integer.toString(num);
	}

	public int calcularEdad(Persona persona) {
		int edad;
		Calendar hoy;
		hoy = Calendar.getInstance(); // Obtiene la fecha y hora actual del sistema
		edad = hoy.get(Calendar.YEAR) - persona.getFechaNacimiento().get(Calendar.YEAR); // Calcula la diferencia de
																							// años entre el año actual
																							// y el año de nacimiento
		if (hoy.get(Calendar.DAY_OF_YEAR) < persona.getFechaNacimiento().get(Calendar.DAY_OF_YEAR)) { // de nacimiento
			edad--;
		}
		return edad;
	}

	public boolean esMayorDeEdad(Persona persona) {
		boolean respuesta;
		int edad;
		edad = calcularEdad(persona);
		if (edad <= 18) {
			respuesta = false;
		} else {
			respuesta = true;
		}
		return respuesta;
	}

	// Validaciones
	public boolean validarEntero(String valor) {
		boolean respuesta;
		try {
			Integer.parseInt(valor);
			respuesta = true;
		} catch (Exception ex) {
			respuesta = false;
		}
		return respuesta;
	}

	public boolean validarFlotante(String valor) {
		boolean respuesta;
		try {
			Double.parseDouble(valor);
			respuesta = true;
		} catch (Exception ex) {
			respuesta = false;
		}
		return respuesta;
	}

	public boolean validarNombre(String valor) {
		boolean respuesta = false;
		if (valor.length() > 0) {
			respuesta = true;
		}
		return respuesta;
	}

	public boolean validarId(String valor) {
		boolean respuesta = false;
		if (valor.length() == 8) {
			respuesta = true;
		}
		return respuesta;
	}

	public boolean validarAltura(double altura) {
		boolean respuesta = false;
		if (altura > 0 && altura <= 2.40) {
			respuesta = true;
		}
		return respuesta;
	}

	public boolean validarPeso(double peso) {
		boolean respuesta = false;
		if (peso > 0 && peso <= 444) {
			respuesta = true;
		}
		return respuesta;
	}

	public boolean validarSexo(char letra) {
		boolean respuesta = false;
		if (letra == 'H' || letra == 'M') {
			respuesta = true;
		}
		return respuesta;
	}

	public boolean validarFecha(String fechaString) {
		boolean respuesta = false;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		try {
			Date fecha = dateFormat.parse(fechaString);
			Calendar fechaActual = Calendar.getInstance();
			fechaActual.add(Calendar.YEAR,0);
			if (fecha.before(fechaActual.getTime())) {
				respuesta = true;
			}
		} catch (Exception ex) {
			respuesta = false;
		}
		return respuesta;
	}
}
