package edu.udelp.POO;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class Cuadrado extends AbstractFiguras {
	//AÑadir los parametros
	
	private Double lado;

    public Cuadrado(Double lado) {
        super(lado);
        this.lado = lado;
    }
	
	

	@Override
	public Double perimetro() {
		
		return lado*4.0;
	}

	@Override
	public Double area() {
		return lado*lado;
	}

	@Override
	public Integer numLado() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public String nombreFigura() {
		// TODO Auto-generated method stub
		return "Cuadrado";
	}
	

}
