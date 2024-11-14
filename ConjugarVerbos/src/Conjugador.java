import java.util.Scanner;

public class Conjugador {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // Pedir al usuario el verbo y el tiempo
            System.out.print("Introduce el verbo y el tiempo (A/P/F). Escribe 'T' para terminar: ");
            String input = sc.nextLine();

            // Dividir la entrada en verbo y tiempo
            String[] partes = input.split(" ");
            String verbo = partes[0];
            String tiempo = partes[1];

            // Si el tiempo es 'T', terminamos el programa
            if (tiempo.equals("T")) {
                System.out.println("Programa terminado.");
                break;
            }

            // Llamamos a la función de conjugación según el tiempo verbal
            conjugacion(verbo, tiempo);
        }

        sc.close();
    }

    public static void conjugacion(String verbo, String tiempo) {
        String raiz = verbo.substring(0, verbo.length() - 2);  // Raíz del verbo (sin las últimas dos letras)
        String terminacion = verbo.substring(verbo.length() - 2);  // Terminación del verbo

        // Determinar la conjugación según la terminación del verbo
        if (terminacion.equals("ar")) {
            // Conjugación de verbos terminados en -ar
            if (tiempo.equals("A")) { // Presente
                System.out.println("yo " + raiz + "o");
                System.out.println("tu " + raiz + "as");
                System.out.println("el " + raiz + "a");
                System.out.println("nosotros " + raiz + "amos");
                System.out.println("vosotros " + raiz + "áis");
                System.out.println("ellos " + raiz + "an");
            } else if (tiempo.equals("P")) { // Pretérito Perfecto Simple
                System.out.println("yo " + raiz + "é");
                System.out.println("tu " + raiz + "aste");
                System.out.println("el " + raiz + "ó");
                System.out.println("nosotros " + raiz + "amos");
                System.out.println("vosotros " + raiz + "asteis");
                System.out.println("ellos " + raiz + "aron");
            } else if (tiempo.equals("F")) { // Futuro
                System.out.println("yo " + raiz + "aré");
                System.out.println("tu " + raiz + "arás");
                System.out.println("el " + raiz + "ará");
                System.out.println("nosotros " + raiz + "aremos");
                System.out.println("vosotros " + raiz + "aréis");
                System.out.println("ellos " + raiz + "arán");
            }
        } else if (terminacion.equals("er")) {
            // Conjugación de verbos terminados en -er
            if (tiempo.equals("A")) { // Presente
                System.out.println("yo " + raiz + "o");
                System.out.println("tu " + raiz + "es");
                System.out.println("el " + raiz + "e");
                System.out.println("nosotros " + raiz + "emos");
                System.out.println("vosotros " + raiz + "éis");
                System.out.println("ellos " + raiz + "en");
            } else if (tiempo.equals("P")) { // Pretérito Perfecto Simple
                System.out.println("yo " + raiz + "í");
                System.out.println("tu " + raiz + "iste");
                System.out.println("el " + raiz + "ió");
                System.out.println("nosotros " + raiz + "imos");
                System.out.println("vosotros " + raiz + "isteis");
                System.out.println("ellos " + raiz + "ieron");
            } else if (tiempo.equals("F")) { // Futuro
                System.out.println("yo " + raiz + "eré");
                System.out.println("tu " + raiz + "erás");
                System.out.println("el " + raiz + "erá");
                System.out.println("nosotros " + raiz + "eremos");
                System.out.println("vosotros " + raiz + "eréis");
                System.out.println("ellos " + raiz + "erán");
            }
        } else if (terminacion.equals("ir")) {
            // Conjugación de verbos terminados en -ir
            if (tiempo.equals("A")) { // Presente
                System.out.println("yo " + raiz + "o");
                System.out.println("tu " + raiz + "es");
                System.out.println("el " + raiz + "e");
                System.out.println("nosotros " + raiz + "imos");
                System.out.println("vosotros " + raiz + "ís");
                System.out.println("ellos " + raiz + "en");
            } else if (tiempo.equals("P")) { // Pretérito Perfecto Simple
                System.out.println("yo " + raiz + "í");
                System.out.println("tu " + raiz + "iste");
                System.out.println("el " + raiz + "ió");
                System.out.println("nosotros " + raiz + "imos");
                System.out.println("vosotros " + raiz + "isteis");
                System.out.println("ellos " + raiz + "ieron");
            } else if (tiempo.equals("F")) { // Futuro
                System.out.println("yo " + raiz + "iré");
                System.out.println("tu " + raiz + "irás");
                System.out.println("el " + raiz + "irá");
                System.out.println("nosotros " + raiz + "iremos");
                System.out.println("vosotros " + raiz + "iréis");
                System.out.println("ellos " + raiz + "irán");
            }
        }
    }
}
