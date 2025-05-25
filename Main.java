package techlab.proyecto;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String [] args){
        int opcionNumero;
        ArrayList<Producto> productos = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);


        do {
            System.out.println("""
                    +----------------------------------+
                               MENÚ PRINCIPAL
                    +----------------------------------+
                      [1] Agregar producto
                      [2] Listar productos
                      [3] Buscar producto
                      [4] Eliminar producto
                      [5] Crear un pedido
                      [6] Listar pedidos
                      [7] Salir
                    +----------------------------------+
                            ELIJA UNA OPCIÓN [1-7]
                    +----------------------------------+
                    """);
            opcionNumero = entrada.nextInt();

            switch (opcionNumero){
                case 1 -> agregarProducto(productos);
                case 2 -> listaProducto(productos);
                case 3 -> buscarProducto(productos);
                case 4 -> borrarProducto(productos);
                case 5 -> System.out.println("Gracias por usar la appp");
                case 6 -> System.out.println("Gracias por usar la apppp");
                case 7 -> System.out.println("Gracias por usar la app");
                default -> System.out.println("Opcion incorrecta");
            }
        } while (opcionNumero != 7);

    }

    //1
    public static void agregarProducto(ArrayList<Producto> productos){
        Scanner entrada = new Scanner(System.in);

        System.out.println("+----------------------------------+");

        System.out.println("Ingrese el nombre del producto: ");
        String nombre = entrada.nextLine();

        System.out.println("+----------------------------------+");

        System.out.print("Ingrese el precio del producto: ");
        double precio = entrada.nextDouble();

        System.out.println("+----------------------------------+");

        System.out.print("Ingrese el stock: ");
        int stock = entrada.nextInt();
        entrada.nextLine();

        System.out.println("+----------------------------------+");

        Producto producto = new Producto(nombre, precio, stock);
        productos.add(producto);
        System.out.println("Producto añadido correctamente.");

        System.out.println("+----------------------------------+");
    }

    //2
    public static void listaProducto(ArrayList<Producto> productos) {
        if (productos.isEmpty()){
            System.out.println("No hay producto todavia :(");
        }else {
            for (Producto p : productos){
                System.out.println("+----------------------------------+");
                p.infoProducto();
            }
        }
    }

    //3
    private static void buscarProducto(ArrayList<Producto> productos) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese ID del producto a buscar: ");
        int idBuscado = entrada.nextInt();

        Producto productoEncontrado = null;
        for (Producto o : productos) {
            if (o.getId() == idBuscado) {
                productoEncontrado = o;
                break;
            }
        }

        if (productoEncontrado != null) {
            System.out.println("Producto encontrado: " );
            productoEncontrado.infoProducto();
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    //4
    private static void borrarProducto(ArrayList<Producto> productos) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el ID del producto a eliminar: ");
        int idBorrar = entrada.nextInt();
        entrada.nextLine();
        boolean eliminado = false;
        boolean encontrado = false;
        for (Producto producto : productos){
            if (producto.getId() == idBorrar){
                encontrado = true;
                System.out.println("El producto que quiere eliminar es el siguiente: ");
                producto.infoProducto();
                System.out.println("Confirmar eliminacion?");
                System.out.println("1 - SI");
                System.out.println("2 - NO");
                int opcionEliminar = entrada.nextInt();
                entrada.nextLine();
                if (opcionEliminar == 1){
                    System.out.println("ELIMINANDO");
                    productos.remove(producto);
                    eliminado = true;
                    break;
                }
            }
        }

        if (!encontrado){
            throw new RuntimeException("No encontramos ningun producto con el id: " + idBorrar);
        }

        if (eliminado){
            System.out.println("Eliminado con exito");
        }
    }






}
