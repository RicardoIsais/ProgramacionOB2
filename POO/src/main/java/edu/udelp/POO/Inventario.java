package edu.udelp.POO;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Prenda> prendas;

    public Inventario() {
        prendas = new ArrayList<>();
    }

    public void agregarPrenda(Prenda prenda) {
        prendas.add(prenda);
    }

    public void mostrarInventario() {
        System.out.println("Prenda | Tamaño | Cantidad | Precio Compra | Precio Venta");
        for (Prenda prenda : prendas) {
            System.out.println(prenda.toString());
        }
    }
    
    public void mostrarInventarioVenta() {
        System.out.println("ID | Prenda | Tamaño | Cantidad | Precio Compra | Precio Venta");
        for (Prenda prenda : prendas) {
            System.out.println(prenda.toStringVenta());
        }
    }
    public Prenda obtenerPrendaPorId(String idPrenda) {
        for (Prenda prenda : prendas) {
            if (prenda.getCodigo().equals(idPrenda)) { 
                return prenda;
            }
        }
        return null; 
    }
    
    public void eliminarPrenda(String idPrenda) {
        Prenda prendaAEliminar = null;
        for (Prenda prenda : prendas) {
            if (prenda.getCodigo().equals(idPrenda)) {
                prendaAEliminar = prenda;
                break;
            }
        }
        if (prendaAEliminar != null) {
            prendas.remove(prendaAEliminar);
        }
    }
    public void disminuirCantidadPrenda(String idPrenda, int cantidad) {
        for (Prenda prenda : prendas) {
            if (prenda.getCodigo().equals(idPrenda)) {
                int nuevaCantidad = prenda.getCantidad() - cantidad;
                if (nuevaCantidad >= 0) {
                    prenda.setCantidad(nuevaCantidad);
                } else {
                    System.out.println("No hay suficientes prendas en el inventario para realizar esta venta.");
                }
                break;
            }
        }
    }

}

