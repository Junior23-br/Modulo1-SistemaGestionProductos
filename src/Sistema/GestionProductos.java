package Sistema;
import java.util.Scanner;
/**
 *Sistema básico de registro y consulta de información de un producto
 */
public class GestionProductos {
    static String nombre = "N/A";
    static double precioUnitario = 0.0;
    static int cantidad = 0;
    //-------------------------
    //  Metodo principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero(sc, "Ingrese su opción: ");
            switch (opcion) {
                case 1 -> registrarProducto(sc);
                case 2 -> mostrarInformacion();
                case 3 -> calcularValorTotal();
                case 4 -> resumenCompleto();
                case 5 -> limpiarDatos();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opcion no valida. Ingrese una opcion en el rango de 0 y 5");
            }
            System.out.println();
        } while (opcion != 0);
        sc.close();
    }
    //Menu con opciones disponibles
    public static void mostrarMenu() {
        System.out.println("--- Sistema de Gestión de Productos ---");
        System.out.println("1. Registrar nuevo producto");
        System.out.println("2. Mostrar información del producto actual");
        System.out.println("3. Calcular valor total del inventario");
        System.out.println("4. Mostrar resumen completo del producto");
        System.out.println("5. Limpiar datos del producto actual");
        System.out.println("0. Salir");
    }
    //Metodo para registrar la informacion de un producto
    public static void registrarProducto(Scanner sc) {
        if(!nombre.equals("N/A")) {
            System.out.print("Ya existe un producto registrado. " +
                    "¿Desea sobreescribir los datos, 'si' o 'no'?: (s/n): ");
            String respuesta = sc.next().toLowerCase();
            while (!respuesta.equals("s") && !respuesta.equals("n")) {
                System.out.print("Entrada inválida. Digite 's' o 'n': ");
                respuesta = sc.next().trim().toLowerCase();
            }
            if(respuesta.equals("n")) {
                System.out.print("Registro cancelado... ");
                return;
            }
        }
        sc.nextLine();
        nombre = validarNombre(sc, "Ingrese el nombre del producto: ");
        precioUnitario = validarPrecio(sc, "Ingrese el precioUnitario del producto: ");
        cantidad = validarCantidad(sc, "Ingrese la cantidad del producto: ");
        System.out.println("Producto registrado exitosamente.");
    }
    //Metodos auxiliar que contribuira con la valdiacion del precio
    public static double validarPrecio(Scanner sc, String texto) {
        double precio;
        while(true) {
            System.out.println(texto);
            if(sc.hasNextDouble()) {
                precio = sc.nextDouble();
                if(precio > 0) {
                    return precio;
                }
            }
            System.out.println("Valor del precio Unitario incorrecto. Ingrese un valor adecuado:  ");
            sc.next();
        }
    }
    //Metodos auxiliar que contribuira con la valdiacion de cantidad de producto
    public static int validarCantidad(Scanner sc, String texto) {
        int cantidad;
        while(true) {
            System.out.println(texto);
            if(sc.hasNextInt()) {
                cantidad = sc.nextInt();
                if(cantidad >= 0) {
                    return cantidad;
                }
            }
            System.out.println("Cantidad incorrecto. Ingrese un valor adecuado:  ");
            sc.next();
        }
    }
    //Metodos auxiliar que contribuira con la valdiacion del nombre del producto
    public static String validarNombre(Scanner sc, String texto) {
        String nombre;
        while (true) {
            System.out.println(texto);
            nombre = sc.nextLine().trim();
            if(!nombre.isEmpty()) {
                return nombre;
            }
            System.out.println("Nombre vacio, ingrese un nombre del producto adecuado: ");
        }
    }
    //metodo auxiliar para leer opciones del menu
    public static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.println(mensaje);
            if(sc.hasNextInt()) {
                return sc.nextInt();
            }
            System.out.println("Entrada inválida. Debe ingresar un número entero.");
            sc.next();
        }
    }
    //Permitirá ver la informacion relacionada con el producto
    public static void mostrarInformacion() {
        if(nombre.equals("N/A")) {
            System.out.println("No hay datos de producto registrados actualmente.");
            return;
        }
            System.out.println("Nombre: " + nombre);
            System.out.println("Precio Unitario: " + precioUnitario);
            System.out.println("Cantidad en inventario: " + cantidad);
    }
    //Calcular total del prodcucto
    public static double calcularValorTotal() {
        if(nombre.equals("N/A")) {
            System.out.println("No hay datos de productos registrados actualmente");
            return 0;
        } else {
            double valorTotal = precioUnitario * cantidad;
            System.out.printf("El valor total a pagar es: %.2f%n", valorTotal);
            return valorTotal;
        }
    }
    //Metodo para visualizar la informacion completa del producto y estado
    public static void resumenCompleto () {
        if(nombre.equals("N/A")) {
            System.out.println("No hay datos registrados");
            return;
        }
        System.out.println("--- Resumen del producto ---");
        mostrarInformacion();
        double valorT = calcularValorTotal();
        String estadoStock = (cantidad < 5) ? "Stock bajo" : (cantidad <= 20) ? "Stock suficiente" : "Stock alto";
        System.out.println("Estado del Stock: " + estadoStock);
    }
    //reestablecer datos
    public static void limpiarDatos() {
        if (nombre.equals("N/A")) {
            System.out.println("No hay productos registrados");
            return;
        }
        nombre = "N/A";
        precioUnitario = 0.0;
        cantidad = 0;
        System.out.println("Los datos del producto actual han sido borrados exitosamente.");
    }
}
