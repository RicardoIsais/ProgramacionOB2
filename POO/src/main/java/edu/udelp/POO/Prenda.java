package edu.udelp.POO;
import edu.udelp.POO.Procesos.ProcesosRopa;
import lombok.Data;

@Data

public class Prenda {
    private String tipo;
    private String tamaño;
    private String genero; 
    private String codigo;
    private double precioCompra;
    private double precioVenta;
    private int cantidad;

    public Prenda(String tipo, String tamaño, String genero, double precioCompra, int cantidad) {
        this.codigo = ProcesosRopa.generaID(); 
        this.tipo = tipo;
        this.tamaño = tamaño;
        this.cantidad = cantidad;
        this.genero = genero;
        this.precioCompra = precioCompra;
        ProcesosRopa procesosRopa = new ProcesosRopa();
        this.precioVenta = procesosRopa.calcularPrecioVenta(tamaño, precioCompra);
        
    }

	@Override
	public String toString() {
		return "Prenda= "+ tipo + ", tamaño=" + tamaño + ", cantidad=" + cantidad + ", precio compra=" + precioCompra
				+ ", precio Venta=" + precioVenta;
	}
	
	public String toStringVenta() {
		return "ID="+codigo+" Prenda= "+ tipo + ", tamaño=" + tamaño + ", cantidad=" + cantidad + ", precio compra=" + precioCompra
				+ ", precio Venta=" + precioVenta;
	}
	


    

}
