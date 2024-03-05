package edu.udelp.POO.Procesos;

import java.util.Random;

public class ProcesosRopa {
	
    public static double calcularPrecioVenta(String tamaño, double precioCompra) {
        if (tamaño.equals("CH") || tamaño.equals("M")) {
            return precioCompra * 1.10;
        } else { 
            return precioCompra * 1.20; 
        }
    }
    
	public static String generaID() {
		int num;
		Random rnd;
		rnd = new Random();
		num = 10000000 + rnd.nextInt(90000000); 
		return Integer.toString(num);
	}

}
