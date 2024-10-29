import java.util.Scanner;

public class PiramideEgipcia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            long bloques = scanner.nextLong();
            if (bloques == 0) {
                break;
            }
            int niveles = 0;
            long totalBloques = 0;

            while (true) {
                niveles++;
                totalBloques += (long) niveles * niveles * niveles; // k^3
                if (totalBloques > bloques) {
                    niveles--; // Deshacemos el último incremento que sobrepasa
                    break;
                }
            }

            System.out.println(niveles);
        }
        scanner.close();
    }
}
