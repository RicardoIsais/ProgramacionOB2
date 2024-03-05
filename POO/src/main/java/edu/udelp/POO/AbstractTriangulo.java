package edu.udelp.POO;

public abstract class AbstractTriangulo implements Figura{
	protected Double lado;
	protected Double altura;
	public AbstractTriangulo(Double lado, Double altura) {
		this.altura=altura;
		this.lado = lado;
	}
	public abstract Integer numLados();
	public abstract String nombreFigura();
	public void getResultados(){
		System.out.println("La Figura"+nombreFigura());
		System.out.println("Lados"+numLados());
		System.out.println("Perimetro"+ perimetro());
		System.out.println("Area"+area());
	}

}