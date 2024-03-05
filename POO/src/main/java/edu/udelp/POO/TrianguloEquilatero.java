package edu.udelp.POO;
import edu.udelp.POO.Triangulo;
import lombok.Data;
@Data

public class TrianguloEquilatero extends AbstractTriangulo{
	public TrianguloEquilatero(Double lado, Double altura) {
		super(lado, altura);
	}

	@Override
	public Double perimetro() {
		// TODO Auto-generated method stub
		return lado*3;
	}

	@Override
	public Double area() {
		// TODO Auto-generated method stub
		return (lado*altura)/2;
	}

	@Override
	public Integer numLados() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public String nombreFigura() {
		// TODO Auto-generated method stub
		return "Triangulo Equilatero";
	}

}
