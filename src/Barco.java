public class Barco {
    private String nombre;
    private int filaInicio;
    private int columnaInicio;
    private int filaFin;
    private int columnaFin;
    private char direccion;

    public Barco(String nombre, int filaInicio, int columnaInicio, int filaFin, int columnaFin, char direccion) {
        this.nombre = nombre;
        this.filaInicio = filaInicio;
        this.columnaInicio = columnaInicio;
        this.filaFin = filaFin;
        this.columnaFin = columnaFin;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFilaInicio() {
        return filaInicio;
    }

    public int getColumnaInicio() {
        return columnaInicio;
    }

    public int getFilaFin() {
        return filaFin;
    }

    public int getColumnaFin() {
        return columnaFin;
    }

    public char getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFilaInicio(int filaInicio) {
        this.filaInicio = filaInicio;
    }

    public void setColumnaInicio(int columnaInicio) {
        this.columnaInicio = columnaInicio;
    }

    public void setFilaFin(int filaFin) {
        this.filaFin = filaFin;
    }

    public void setColumnaFin(int columnaFin) {
        this.columnaFin = columnaFin;
    }

    public void setDireccion(char direccion) {
        this.direccion = direccion;
    }
}
