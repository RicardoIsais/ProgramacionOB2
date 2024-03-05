package edu.udelp.POO;
import lombok.Data;
@Data


public class TrianguloEscaleno extends AbstractTriangulo {
	private Double base;
	private Double lado3;
	public TrianguloEscaleno(Double lado,Double base,Double lado3, Double altura) {
		super(lado, altura);
		this.base=base;
		this.lado3=lado3;
	}
	@Override
	public Double perimetro() {
		// TODO Auto-generated method stub
		return lado+base+lado3;
	}
	@Override
	public Double area() {
		// TODO Auto-generated method stub
		return (base*altura)/2;
	}
	@Override
	public Integer numLados() {
		// TODO Auto-generated method stub
		return 3;
	}
	@Override
	public String nombreFigura() {
		// TODO Auto-generated method stub
		return "Triangulo Escaleno";
	}

}
