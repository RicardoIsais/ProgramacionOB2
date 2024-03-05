package edu.udelp.POO;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Triangulo implements Figura {
	
	//Triangulo equilatero

	private Double base;
	private Double altura;

	@Override
	public Double perimetro() {

		return base*3;
	}

	@Override
	public Double area() {
		// TODO Auto-generated method stub
		return (base*altura)/2;
	}

}
