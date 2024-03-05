package edu.udelp.POO;
import lombok.Data;

@Data

public abstract class AbstractFiguras  implements Figura{
	protected Double lado;
	
	public AbstractFiguras(Double lado) {
		this.lado=lado;
	}
	
	
	public abstract Integer numLado();
	public abstract String nombreFigura();
	
	public void getResultado() {
		System.out.print("La figura "+ nombreFigura());
		System.out.print("Lados "+ numLado());
		System.out.print("Perimetro "+ perimetro());
		System.out.print("Area "+ area());
	}
	

}

//Cuando se tienen un proceso en comun se usa la clases abstractas

