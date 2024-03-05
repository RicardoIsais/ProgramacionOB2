package edu.udelp.POO;
import lombok.Data;
@Data

public class Rectangulo extends AbstractFiguras {

	private Double altura;
	
	public Rectangulo(Double base,Double altura) {
		super(base);
		this.altura=altura;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double perimetro() {
		// TODO Auto-generated method stub
		return (altura * 2)+(lado * 2);
	}

	@Override
	public Double area() {
		// TODO Auto-generated method stub
		return lado * altura;
	}

	@Override
	public Integer numLado() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public String nombreFigura() {
		// TODO Auto-generated method stub
		return "Rectangulo";
	}

}
