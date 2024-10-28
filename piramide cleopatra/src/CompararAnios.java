import java.util.Scanner; // Importamos la clase Scanner para leer la entrada del usuario

public class CompararAnios {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creamos un objeto Scanner para leer datos del teclado

        // Pedir al usuario que ingrese los años A, B y C
        System.out.print("Ingrese el año A: ");
        int añoA = scanner.nextInt(); // Leer el año A
        System.out.print("Ingrese el año B: ");
        int añoB = scanner.nextInt(); // Leer el año B
        System.out.print("Ingrese el año C: ");
        int añoC = scanner.nextInt(); // Leer el año C

        // Calcular las distancias entre A y B, y C y B
        int distanciaAB = Math.abs(añoA - añoB); // Distancia entre A y B
        int distanciaCB = Math.abs(añoC - añoB); // Distancia entre C y B

        // Comparar distancias y determinar cuál año está más próximo a B
        if (distanciaAB < distanciaCB) {
            System.out.println("El año A (" + añoA + ") está más próximo al año B (" + añoB + ").");
        } else if (distanciaCB < distanciaAB) {
            System.out.println("El año C (" + añoC + ") está más próximo al año B (" + añoB + ").");
        } else {
            System.out.println("Los años A (" + añoA + ") y C (" + añoC + ") están equidistantes del año B (" + añoB + ").");
        }

        scanner.close(); // Cerramos el scanner para liberar recursos
    }
}









