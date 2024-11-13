import java.util.Random;
import java.util.Scanner;

public class StarWarsGame {

    static final int SIZE = 10;
    static char[][] tableroYoda = new char[SIZE][SIZE];
    static char[][] tableroVader = new char[SIZE][SIZE];

    static int yodaX, yodaY;
    static int vaderX, vaderY;

    static int vidasYoda = 3;
    static int vidasVader = 3;

    static int[] dirX = {0, 0, 1, -1};
    static int[] dirY = {-1, 1, 0, 0};

    public static void inicializarTablero() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                tableroYoda[i][j] = 'L';
                tableroVader[i][j] = 'L';
            }
        }

        yodaX = new Random().nextInt(SIZE);
        yodaY = new Random().nextInt(SIZE);
        tableroYoda[yodaX][yodaY] = 'Y';

        vaderX = new Random().nextInt(SIZE);
        vaderY = new Random().nextInt(SIZE);
        tableroVader[vaderX][vaderY] = 'V';

        for (int i = 0; i < 5; i++) {
            int x, y;
            do {
                x = new Random().nextInt(SIZE);
                y = new Random().nextInt(SIZE);
            } while (tableroYoda[x][y] != 'L');
            tableroYoda[x][y] = 'D';
        }

        for (int i = 0; i < 5; i++) {
            int x, y;
            do {
                x = new Random().nextInt(SIZE);
                y = new Random().nextInt(SIZE);
            } while (tableroVader[x][y] != 'L');
            tableroVader[x][y] = 'R';
        }

        for (int i = 0; i < 5; i++) {
            int x, y;
            do {
                x = new Random().nextInt(SIZE);
                y = new Random().nextInt(SIZE);
            } while (tableroYoda[x][y] != 'L');
            tableroYoda[x][y] = 'M';
        }

        for (int i = 0; i < 5; i++) {
            int x, y;
            do {
                x = new Random().nextInt(SIZE);
                y = new Random().nextInt(SIZE);
            } while (tableroVader[x][y] != 'L');
            tableroVader[x][y] = 'M';
        }

        tableroYoda[9][9] = 'F';
        tableroVader[9][9] = 'F';
    }

    public static void mostrarTablero(char[][] tablero) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void moverJugador(char[][] tablero, int jugador, char direccion) {
        int x = jugador == 1 ? yodaX : vaderX;
        int y = jugador == 1 ? yodaY : vaderY;
        int dx = 0, dy = 0;

        switch (direccion) {
            case 'W': dx = -1; dy = 0; break;
            case 'S': dx = 1; dy = 0; break;
            case 'A': dx = 0; dy = -1; break;
            case 'D': dx = 0; dy = 1; break;
        }

        x = (x + dx + SIZE) % SIZE;
        y = (y + dy + SIZE) % SIZE;

        if (tablero[x][y] == 'L' || tablero[x][y] == 'F') {
            if (jugador == 1) {
                yodaX = x;
                yodaY = y;
            } else {
                vaderX = x;
                vaderY = y;
            }
        } else if (tablero[x][y] == 'D' || tablero[x][y] == 'R') {
            if (jugador == 1) {
                vidasYoda--;
            } else {
                vidasVader--;
            }
        } else if (tablero[x][y] == 'M') {
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        inicializarTablero();
        mostrarTablero(tableroYoda);

        while (vidasYoda > 0 && vidasVader > 0) {
            System.out.println("Turno de Yoda");
            System.out.print("Ingrese movimiento (W, A, S, D): ");
            char direccionYoda = sc.nextLine().charAt(0);
            moverJugador(tableroYoda, 1, direccionYoda);
            mostrarTablero(tableroYoda);

            if (vidasYoda == 0) {
                System.out.println("Yoda ha perdido. ¡Darth Vader gana!");
                break;
            }

            System.out.println("Turno de Darth Vader");
            System.out.print("Ingrese movimiento (W, A, S, D): ");
            char direccionVader = sc.nextLine().charAt(0);
            moverJugador(tableroVader, 2, direccionVader);
            mostrarTablero(tableroVader);

            if (vidasVader == 0) {
                System.out.println("Darth Vader ha perdido. ¡Yoda gana!");
                break;
            }
        }

        sc.close();
    }
}
