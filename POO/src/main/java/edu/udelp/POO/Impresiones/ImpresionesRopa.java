package edu.udelp.POO.Impresiones;
import java.util.Scanner;
import edu.udelp.POO.Inventario;
import edu.udelp.POO.InventarioVentas;
import edu.udelp.POO.Prenda;
import edu.udelp.POO.Profesor;

public class ImpresionesRopa {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();
        InventarioVentas inventarioVenta = new InventarioVentas();
        int opcion;

        do {
            System.out.println("\n--- Menú Sistema de Inventario de Ropa ---");
            System.out.println("1. Agregar una prenda");
            System.out.println("2. Mostrar prendas");
            System.out.println("3. Venta de prendas");
            System.out.println("4. Mostrar las prendas que se han vendido");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
            case 1:
                System.out.print("Ingrese el tipo de prenda (Pantalón de Vestir, Pantalón de Mezclilla, Camisa, Falda, Blusa, Playera): ");
                String tipo = scanner.nextLine();
                if (!tipo.equals("Falda") && !tipo.equals("Blusa") && !tipo.equals("Pantalón de Vestir") && !tipo.equals("Pantalón de Mezclilla") && !tipo.equals("Camisa") && !tipo.equals("Playera")) {
                    System.out.println("Tipo de prenda inválido.");
                    break;
                }

                System.out.print("Ingrese el tamaño (CH, M, G, EX): ");
                String tamaño = scanner.nextLine();
                
                System.out.print("Ingrese el género (Hombre, Mujer): ");
                String genero = scanner.nextLine();
                if ((tipo.equals("Falda") || tipo.equals("Blusa")) && !genero.equals("Mujer")) {
                    System.out.println("Las faldas y las blusas solo pueden ser para mujeres.");
                    break;
                }
                
                System.out.print("Ingrese el precio de compra: ");
                double precioCompra = scanner.nextDouble();
                
                System.out.print("Ingrese la cantidad: ");
                int cantidad = scanner.nextInt();
                scanner.nextLine(); 
                for (int i = 0; i < cantidad; i++) {
                    Prenda prenda = new Prenda(tipo, tamaño, genero, precioCompra,1);
                    inventario.agregarPrenda(prenda);
                }
                System.out.println(cantidad + " prendas de tipo " + tipo + " agregadas exitosamente.");
                break;

                case 2:
                	
                    System.out.println("Mostrando las prendas en el inventario:");
                    inventario.mostrarInventario();
                    break;
                case 3:
                    inventario.mostrarInventarioVenta();
                    System.out.println("Ingrese los IDs de las prendas a vender o escriba 'salir' para finalizar la compra:");
                    
                    double totalVenta = 0;
                    while (true) {
                        String line = scanner.nextLine();
                        if (line.equalsIgnoreCase("salir")) {
                            break; 
                        }
                        
                        String[] ids = line.split(" ");
                        for (String idStr : ids) {
                            Prenda prendaSeleccionada = inventario.obtenerPrendaPorId(idStr);
                            if (prendaSeleccionada != null) {
                            	inventarioVenta.agregarPrenda(prendaSeleccionada);
                                System.out.println("Vendiendo: " + prendaSeleccionada.toStringVenta());
                                totalVenta += prendaSeleccionada.getPrecioVenta() * prendaSeleccionada.getCantidad();
                                inventario.eliminarPrenda(idStr); 
                                
                            } else {
                                System.out.println("No se encontró la prenda con ID: " + idStr);
                            }
                        }
                        System.out.println("Total a pagar hasta ahora: $" + totalVenta);
                        System.out.println("Puede continuar ingresando IDs de prendas a vender, o escriba 'salir' para finalizar la compra:");
                    }

                    System.out.println("Total a pagar: $" + totalVenta);
                    break;
                case 4:
                	System.out.println("Mostrando las prendas totales que se han vendido:");
                	inventarioVenta.mostrarInventarioVentaInventario();;
                	System.out.println("----------------------------------");
                    System.out.println("Resumen con las prendas y su cantidad se han vendido por el tipo y tamaño:");
                    inventarioVenta.mostrarTablaVentas();
                    break;


                case 0:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }


}
