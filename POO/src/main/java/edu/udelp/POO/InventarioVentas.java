package edu.udelp.POO;
import java.util.ArrayList;

public class InventarioVentas {
    private ArrayList<Prenda> ventas;

    public InventarioVentas() {
        ventas = new ArrayList<>();
    }

    public void agregarPrenda(Prenda prenda) {
        ventas.add(prenda);
    }

    public void mostrarInventarioVentaInventario() {
        System.out.println("Prenda | Tamaño | Cantidad | Precio Compra | Precio Venta");
        for (Prenda prenda : ventas) {
            System.out.println(prenda.toString());
        }
    }

    public void mostrarTablaVentas() {
        System.out.println("Prenda | Tamaño | Total de Ventas | Precio Compra | Precio Venta");
        ArrayList<String> prendasUnicas = new ArrayList<>();
        for (Prenda prenda : ventas) {
            String clave = prenda.getTipo() + " | " + prenda.getTamaño();
            if (!prendasUnicas.contains(clave)) {
                int totalVentas = calcularTotalVentas(prenda.getTipo(), prenda.getTamaño());
                System.out.println(prenda.getTipo() + " | " + prenda.getTamaño() + " | " + totalVentas + " | " + prenda.getPrecioCompra() + " | " + prenda.getPrecioVenta());
                prendasUnicas.add(clave);
            }
        }
    }

    private int calcularTotalVentas(String tipo, String tamaño) {
        int totalVentas = 0;
        for (Prenda prenda : ventas) {
            if (prenda.getTipo().equals(tipo) && prenda.getTamaño().equals(tamaño)) {
                totalVentas += prenda.getCantidad();
            }
        }
        return totalVentas;
    }
}
