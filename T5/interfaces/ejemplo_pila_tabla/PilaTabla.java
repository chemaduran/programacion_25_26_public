package U5_herencia_interfaces.teoria.interfaces.ejemplo_pila_tabla;

import java.util.Arrays;

public class PilaTabla {
    private final int MAX_ELEMENTOS = 10;
    private Integer[] t;
    private int indice_cima;

    public PilaTabla() {
        t = new Integer[MAX_ELEMENTOS];
        indice_cima = -1;
    }

    public PilaTabla(int capacidad_inicial) {
        t = new Integer[capacidad_inicial];
        indice_cima = -1;
    }

    private boolean pila_vacia() {
        return indice_cima == -1;
    }

    private boolean pila_llena() {
        return indice_cima == t.length - 1;
    }

    Integer cima() {
        Integer elemento_cima = null;
        if (!pila_vacia()) {
            elemento_cima = t[indice_cima];
        }
        return elemento_cima;
    }

    public String mostrar() {
        String resultado = "";
        for (int i = 0; i <= indice_cima; i++) {
            resultado += t[i] + " ";
        }
        resultado += "(cima)";
        return resultado;
    }

    public void apilar(Integer e) {
        if (pila_llena()) {
            t = Arrays.copyOf(t, t.length + 10);
        }
        t[++indice_cima] = e;
    }

    public Integer desapilar() {
        Integer elemento = null;
        if (!pila_vacia()) {
            elemento = t[indice_cima];
            indice_cima--;
        }
        return elemento;
    }
}
