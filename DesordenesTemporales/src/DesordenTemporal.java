import java.util.Scanner;

public class DesordenTemporal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // Leer el número de habitantes
            int n = sc.nextInt();
            if (n == 0) {
                break;  // Si el número de habitantes es 0, terminamos el programa
            }

            // Leer las edades reales
            int[] edades = new int[n];
            for (int i = 0; i < n; i++) {
                edades[i] = sc.nextInt();
            }

            // Crear un array de índices para mantener el orden administrativo
            int[] indices = new int[n];
            for (int i = 0; i < n; i++) {
                indices[i] = i;
            }

            // Contar las inversiones utilizando una versión modificada de Merge Sort
            int desordenTotal = contarInversiones(edades, indices, 0, n - 1);
            System.out.println(desordenTotal);
        }

        sc.close();
    }

    // Función de Merge Sort modificado que cuenta las inversiones
    public static int contarInversiones(int[] edades, int[] indices, int inicio, int fin) {
        if (inicio >= fin) {
            return 0;
        }

        int medio = (inicio + fin) / 2;
        int inversionIzquierda = contarInversiones(edades, indices, inicio, medio);
        int inversionDerecha = contarInversiones(edades, indices, medio + 1, fin);
        int inversionCruzada = contarInversionesCruzadas(edades, indices, inicio, medio, fin);

        return inversionIzquierda + inversionDerecha + inversionCruzada;
    }

    // Función para contar las inversiones cruzadas y ordenar el arreglo
    public static int contarInversionesCruzadas(int[] edades, int[] indices, int inicio, int medio, int fin) {
        int[] temp = new int[indices.length];
        int i = inicio;
        int j = medio + 1;
        int k = inicio;
        int inversiones = 0;

        // Ordenar y contar las inversiones
        while (i <= medio && j <= fin) {
            if (edades[indices[i]] <= edades[indices[j]]) {
                temp[k++] = indices[i++];
            } else {
                temp[k++] = indices[j++];
                inversiones += (medio - i + 1); // Las personas que quedan a la izquierda de i son todas mayores
            }
        }

        // Copiar los elementos restantes
        while (i <= medio) {
            temp[k++] = indices[i++];
        }
        while (j <= fin) {
            temp[k++] = indices[j++];
        }

        // Copiar el array temporal de vuelta a indices
        System.arraycopy(temp, inicio, indices, inicio, fin - inicio + 1);

        return inversiones;
    }
}
