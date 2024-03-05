package edu.udelp.POO;
import lombok.Data;
@Data




public class TrianguloIsoceles extends AbstractTriangulo {
	private Double ladoDiferente;
	public TrianguloIsoceles(Double lado,Double ladoDiferente, Double altura) {
		super(lado, altura);
		this.ladoDiferente=ladoDiferente;
	}
	@Override
	public Double perimetro() {
		// TODO Auto-generated method stub
		return ladoDiferente+(lado*2);
	}

	@Override
	public Double area() {
		// TODO Auto-generated method stub
		return (ladoDiferente*altura)/2;
	}

	@Override
	public Integer numLados() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public String nombreFigura() {
		// TODO Auto-generated method stub
		return "Triangulo Isosceles";
	}
	
}