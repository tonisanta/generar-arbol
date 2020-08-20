package GenerarArbol;

import Excepciones.RecorridoInvalidoException;

import java.util.ArrayList;
import java.util.HashMap;

public class Arbol {
    private Nodo raiz;
    private int indice;
    private HashMap<String, Integer> hash;
    private ArrayList<String> postorden;

    /**
     * Construir árbol a partir de su recorrido preorden e inorden
     * @param preorden array strings
     * @param inorden array strings
     */
    public Arbol(String[] preorden, String[] inorden) throws RecorridoInvalidoException {
        if (preorden.length != inorden.length) {
            throw new RecorridoInvalidoException("Ambos recorridos deben tener el mismo número de elementos");
        }

        this.indice = 0;
        this.postorden = new ArrayList<>();
        this.hash = new HashMap<>();
        for (int i = 0; i < inorden.length; i++) {
            hash.put(inorden[i], i);
        }

        this.raiz = generarArbol(preorden, 0, preorden.length - 1);
    }

    /**
     * Algoritmo recursivo que genera el árbol a partir de los recorridos introducidos
     * @param preorden
     * @param indiceInicio
     * @param indiceFinal
     * @return Devuelve el Nodo raíz
     */
    private Nodo generarArbol(String[] preorden, int indiceInicio, int indiceFinal) {
        if (indiceInicio > indiceFinal)
            return null;

        Nodo n = new Nodo(preorden[indice]);
        indice++;
        if (indiceInicio == indiceFinal)
            return n;

        int indiceInorden = hash.get(n.getItem());
        n.setHijoIz(generarArbol(preorden, indiceInicio, indiceInorden - 1));
        n.setHijoDer(generarArbol(preorden, indiceInorden + 1, indiceFinal));
        return n;
    }

    public ArrayList<String> getPostorden(){
        this.getPostorden(this.raiz);
        return postorden;
    }

    private void getPostorden(Nodo nodo) {
        if (nodo == null)
            return;
        getPostorden(nodo.getHijoIz());
        getPostorden(nodo.getHijoDer());
        postorden.add(nodo.getItem());
    }
}

