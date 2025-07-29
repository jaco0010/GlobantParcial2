package org.example;

import java.time.LocalDate; //Se usa para manejar fechas (fecha de vencimiento)
import java.util.ArrayList; //Para guardar los productos en una lista dinámica
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Producto> productos = new ArrayList<>();
    //static	Hay una sola referencia compartida entre todos los métodos y posibles instancias.
    //final 	La referencia no puede cambiarse una vez asignada.
    //private	Oculta el campo para que solo sea accesible dentro de la clase.

    public static void main(String[] args) {
        String opcionMenu;
        do { //Esto asegura que el menú se muestre al menos una vez,
            // incluso si opcionMenu ya fuera "5" desde antes

            mostrarMenu();
            opcionMenu = scanner.nextLine().trim();
            switch (opcionMenu) {
                case "1" -> agregarProducto();
                case "2" -> eliminarProducto();
                case "3" -> mostrarProductos();
                case "4" -> editarPrecioProducto();
                case "5" -> System.out.println("👋 ¡Gracias por usar el sistema!");
                default -> System.out.println("❌ Opción inválida. Intenta de nuevo.");
            }
        } while (!opcionMenu.equals("5")); //mientras no sea 5 el bucle sigue
    }
    //este es el bucle principal del programa:
    //Muestra un menú.
    //Lee la opción ingresada.
    //Ejecuta la acción correspondiente usando switch.

    private static void mostrarMenu() {
        System.out.println("\n=== Bienvenido al Supermercado ===");
        System.out.print("""
                ¿Qué deseas hacer?
                  1. Agregar producto
                  2. Eliminar producto
                  3. Mostrar lista de productos
                  4. Editar precio
                  5. Salir
                Ingresa opción: """);
    }
    //Muestra las opciones disponibles al usuario.

    private static void agregarProducto() {
        System.out.println("\nCrear nuevo producto:");

        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Categoría: ");
        String categoria = scanner.nextLine();
        System.out.print("Proveedor: ");
        String proveedor = scanner.nextLine();
        System.out.print("Foto 1: ");
        String foto1 = scanner.nextLine();
        System.out.print("Foto 2: ");
        String foto2 = scanner.nextLine();

        LocalDate fechaVencimiento = ValidadorEntrada.leerFecha(scanner);
        int precio = ValidadorEntrada.leerEntero(scanner, "Precio unitario: ");
        int cantidad = ValidadorEntrada.leerEntero(scanner, "Cantidad en bodega: ");

        Producto nuevo = new Producto(id, nombre, descripcion, categoria,
                proveedor, foto1, foto2, fechaVencimiento, precio, cantidad);
        productos.add(nuevo);
        System.out.println("✅ Producto agregado correctamente.");
    }
//Solicita todos los datos de un producto al usuario.
//Usa clases auxiliares como ValidadorEntrada para leer y validar la entrada.
//Crea un nuevo objeto Producto y lo añade a la lista



    private static void eliminarProducto() {
        if (productos.isEmpty()) {
            System.out.println("📭 No hay productos para eliminar.");
            return;
        }

        // Mostrar la lista actual con numeración
        mostrarProductos();

        // Leer la opción del usuario
        int opcion = ValidadorEntrada.leerEntero(scanner, "Número de producto a eliminar: ");

        // Depuración: mostrar estado antes
        System.out.println("Debug: tamaño antes = " + productos.size());
        System.out.println("Debug: opción ingresada = " + opcion);

        // Validar rango
        if (opcion < 1 || opcion > productos.size()) {
            System.out.println("❌ Selección no válida.");
            return;
        }

        // Eliminar producto del índice correcto
        productos.remove(opcion - 1);

        // Depuración: mostrar estado después
        System.out.println("Debug: eliminado índice = " + (opcion - 1));
        System.out.println("Debug: tamaño después = " + productos.size());

        System.out.println("🗑️ Producto eliminado con éxito.");
        //Chequeamos si la lista está vacía para evitar fallos o comportamientos inesperados.
        //
        //Si productos.size() == 0, el método termina sin intentar eliminar nada,
        // lo cual sigue buenas prácticas mencionadas en foros técnicos

        // Mostrar lista actualizada
        mostrarProductos();
    }

    //Muestra la lista de productos.
    //
    //Permite al usuario seleccionar uno para eliminarlo.



    private static void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("📭 No hay productos registrados.");
            return;
        }
        int i = 1;
        for (Producto p : productos) {
            System.out.println("\nPRODUCTO #" + i++);
            System.out.println(p); // Esto llama automáticamente a p.toString()
        }
    }




    private static void editarPrecioProducto() {
        if (productos.isEmpty()) {
            System.out.println("📭 No hay productos para editar.");
            return;
        }
        int i = 1;
        for (Producto p : productos) {
            System.out.println(i++ + ". " + p.nombre + " — Precio actual: $" + p.PrecioUnitario);
        }
        int opcion = ValidadorEntrada.leerEntero(scanner, "Número del producto a modificar: ");
        if (opcion < 1 || opcion > productos.size()) {
            System.out.println("❌ Selección no válida.");
            return;
        }
        int nuevoPrecio = ValidadorEntrada.leerEntero(scanner, "Nuevo precio unitario: ");
        productos.get(opcion - 1).PrecioUnitario = nuevoPrecio;
        System.out.println("💲 Precio actualizado correctamente.");
    }
}
//Muestra productos con sus precios.
//
//Permite cambiar el precio de uno de ellos.