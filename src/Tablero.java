import java.util.ArrayList;
import java.util.Scanner;

public class Tablero {
    private int tamanioTablero;
    private char [][]tablero;
    private ArrayList<Barco> barcos;


    public Tablero(int tamanioTablero) {
        this.tamanioTablero = tamanioTablero;
        this.tablero = new char[tamanioTablero][tamanioTablero];
        this.barcos = new ArrayList<>();

    }

    public int getTamanioTablero() {
        return tamanioTablero;
    }

    public char[][] getTablero() {
        return tablero;
    }

    public ArrayList<Barco> getBarcos() {
        return this.barcos;
    }

    public void setTamanioTablero(int tamanioTablero) {
        this.tamanioTablero = tamanioTablero;
    }

    public void setTablero(char[][] tablero) {
        this.tablero = tablero;
    }

    public void setBarcos(ArrayList<Barco> barcos) {
        this.barcos = barcos;
    }

    public void inicializarTablero(){
        char[][] tablero = getTablero();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = '~'; // '~' representa agua
            }
        }

        setTablero(tablero);
    }

    public void agregarBarcos(Scanner scanner){
        System.out.println("Ingrese la cantidad de Barcos");
        int cantidadBarcos = scanner.nextInt();

        System.out.println("Coloca los barcos.");

        for (int i = 0; i < cantidadBarcos; i++) {
            String nombreBarco = "Barco "+(i+1);
            System.out.println(nombreBarco);
            System.out.print("Coordenadas de inicio (fila columna): ");
            int filaInicio = scanner.nextInt();
            int columnaInicio = scanner.nextInt();

            System.out.print("Coordenadas de fin (fila columna): ");
            int filaFin = scanner.nextInt();
            int columnaFin = scanner.nextInt();

            System.out.print("Dirección (H para horizontal, V para vertical): ");
            char direccion = scanner.next().charAt(0);

            if (!validarCoordenadas(filaInicio, columnaInicio, filaFin, columnaFin)) {
                System.out.println("Coordenadas inválidas o barco superpuesto. Inténtalo de nuevo.");
                i--;
            } else {

                colocarBarco(nombreBarco,filaInicio, columnaInicio, filaFin, columnaFin, direccion);
            }
        }

    }



    public void colocarBarco(String nombre, int filaInicio, int columnaInicio, int filaFin, int columnaFin, char direccion) {
        char[][] tablero = getTablero();
        ArrayList<Barco> barcos = getBarcos();

        barcos.add(new Barco(nombre, filaInicio, columnaInicio, filaFin, columnaFin, direccion));

        for (int i = filaInicio; i <= filaFin; i++) {
            for (int j = columnaInicio; j <= columnaFin; j++) tablero[i][j] = 'B';
        }
        setTablero(tablero);
        setBarcos(barcos);
    }

    public boolean validarCoordenadas(int filaInicio, int columnaInicio, int filaFin, int columnaFin) {
        char[][] tablero = getTablero();

        if (filaInicio < 0 || filaInicio >= tablero.length || columnaInicio < 0 || columnaInicio >= tablero[0].length ||
                filaFin < 0 || filaFin >= tablero.length || columnaFin < 0 || columnaFin >= tablero[0].length) {
            return false;
        }

        if (filaInicio == filaFin && columnaInicio == columnaFin) {
            return false;
        }

        if (filaInicio != filaFin && columnaInicio != columnaFin) {
            return false;
        }

        for (int i = filaInicio; i <= filaFin; i++) {
            for (int j = columnaInicio; j <= columnaFin; j++) {
                if (tablero[i][j] == 'B') {
                    return false;
                }
            }
        }

        return true;
    }
    public void mostrarTablero(boolean[][] intentos) {
        char[][] tablero = getTablero();
        System.out.println("Tablero:");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (intentos[i][j]) {
                    if (tablero[i][j] == 'B'||tablero[i][j] == 'X') {
                        System.out.print('X'); // 'X' representa un barco tocado
                    } else {
                        System.out.print('-'); // '-' representa agua tocada
                    }
                } else {
                    System.out.print('~'); // '~' representa agua no tocada
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public char atacarBarco(int fila, int columna) {
        char[][] tablero = getTablero();
        char caracter = ' ';
        if (tablero[fila][columna] == 'B') {
            caracter = 'X';
        } else if (tablero[fila][columna] == '~') {
            caracter = '-';
        }
        tablero[fila][columna] = caracter;
        setTablero(tablero);
        return caracter;

    }

    public boolean verificarJuegoTerminado() {
        char[][] tablero = getTablero();
        for(int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == 'B') {
                    return false;
                }
            }
        }
        return true;
    }

}
