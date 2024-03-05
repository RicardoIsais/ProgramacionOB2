package edu.udelp.POO.Procesos;


import edu.udelp.POO.Cuadrado;

import edu.udelp.POO.Figura;
import edu.udelp.POO.AbstractFiguras;

public class PruebaFiguras {
	
	public static void main(String[]args) {
		
		Figura f= new Cuadrado(3.0);
		
		//Papa es figura, cuadrado es su hijo
		
		Double resultado=f.perimetro();
		System.out.print(resultado);
		
		
		AbstractFiguras fi= new Cuadrado(3.0);
		fi.getResultado();
		
		//Papa es figura, cuadrado es su hijo
		
		Double re=f.perimetro();
		System.out.print(resultado);
		
		
//		Figura f2=new Figura() {
//
//			@Override
//			public Double perimetro() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public Double area() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			
//		};
	
			
			
		
	}

}
