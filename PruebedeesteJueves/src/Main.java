import java.util.Random;
import java.util.Scanner;
//Quiero dos tableros de 10*10 , uno lo relleno con números aleatorios y el otro lo relleno con x , el usuario va a poder insertar 10 números, por cada numero que yo inserte necesito chequearlo con el de números aleatorios sin que este se vea y que se represente ese numero en el de las x ,

class TableroJuego {
    public static void main(String[] args) {
        int fila = 10;
        int columna = 10;
        int[][] tableroNumero = new int[fila][columna];
        char[][] tableroX = new char[fila][columna];

        // Rellenamos el tablero con los números aleatorios
        Random aleatorio = new Random();
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                tableroNumero[i][j] = aleatorio.nextInt(99) + 1; // Rango de 1 a 100
                tableroX[i][j] = 'X'; // Sirve para inicializar el tablero de X
            }
        }


        // Mostrar el tablero de 'X' inicial
        System.out.println("Tablero de X inicial:");
        mostrarTablero(tableroX);//La función esta abajo del todo :), cabe destacar que al no hacer bien las condicionales el tablero no se actualiza bien.

        Scanner scanner = new Scanner(System.in);//Usaremos el Scanner para poderle pedir al usuario que nos inserte 10 dinemor
        int[] numerosUsuario = new int[10];

        // Pedimos al usuario que inserte 10 números
        for (int i = 0; i < 10; i++) {
            System.out.print("Inserta el número " + (i + 1) + ": ");
            numerosUsuario[i] = scanner.nextInt();

        }

        // Marcar los números en el tablero de 'X'
        for (int numero : numerosUsuario) {
            boolean encontrado = false;
            for (int i = 0; i < fila; i++) {
                for (int j = 0; j < columna; j++) {
                    if (tableroNumero[i][j] == numero) { //No se como seguir en este punto...., pongo que el 1 es el número acertado ya que no me sale de otra manera
                        tableroX[i][j] = (char) (numero + '0') ;
                        encontrado = true;
                        break;
                    }
                }
            }
        }

        // Se muestra el tablero de 'X' actualizado
        System.out.println("Tablero de X después de los numeros insertados:");
        mostrarTablero(tableroX);
    }

    //
    static void mostrarTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println(); // Se immprime asi en forma de tabla
        }
    }

}

