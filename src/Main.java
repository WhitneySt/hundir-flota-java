import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int tamanioTablero;
        int cantidadBarcos;

        System.out.println("-------Armado del juego-------");
        System.out.println("Por favor indique el tamaño del tablero");
        tamanioTablero = scanner.nextInt();

        Tablero nuevoTablero = new Tablero(tamanioTablero);

        int cantidadIntentos = tamanioTablero*tamanioTablero;
        boolean [][]intentos = new boolean[tamanioTablero][tamanioTablero];

        nuevoTablero.inicializarTablero();
        nuevoTablero.agregarBarcos(scanner);

        System.out.println("----Inicia el Juego-----");

        boolean juegoTerminado = false;
        while (!juegoTerminado && cantidadIntentos > 0) {

            nuevoTablero.mostrarTablero(intentos);
            System.out.println("Ingrese las coordenadas a atacar (fila columna): ");
            int filaAtaque = scanner.nextInt();
            int columnaAtaque = scanner.nextInt();

            if (filaAtaque < 0 || filaAtaque >= tamanioTablero || columnaAtaque < 0 || columnaAtaque >= tamanioTablero) {
                System.out.println("Coordenadas inválidas. Inténtalo de nuevo.");
            } else if (intentos[filaAtaque][columnaAtaque]) {
                System.out.println("Ya has atacado esta posición. Inténtalo de nuevo.");
            } else {
                intentos[filaAtaque][columnaAtaque] = true;
                char resultadoAtaque = nuevoTablero.atacarBarco(filaAtaque, columnaAtaque);
                if (resultadoAtaque == 'X') {
                    System.out.println("¡Barco tocado!");
                } else if (resultadoAtaque == '-') {
                    System.out.println("¡Agua tocada!");
                } else {
                    System.out.println("Coordenadas inválidas. Inténtalo de nuevo.");
                }

                juegoTerminado = nuevoTablero.verificarJuegoTerminado();
                cantidadIntentos--;
            }
        }

        if (juegoTerminado) {
            System.out.println("¡Felicidades! ¡Has hundido todos los barcos!");
        } else {
            System.out.println("Has agotado el número de intentos. ¡Perdiste!");
        }
    }


    }
