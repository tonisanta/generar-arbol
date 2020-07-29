package GenerarArbol;

import java.util.HashMap;

public class Arbol {
    private Nodo raiz;
    private int indice;
    private HashMap<String, Integer> hash;

    /**
     * Construir árbol a partir de su recorrido preorden e inorden
     * @param preorden array strings
     * @param inorden array strings
     */
    public Arbol(String[] preorden, String[] inorden) {
        if (preorden.length != inorden.length) {
            System.out.println("Ambos recorridos deben tener el mismo número de elementos");
            return;
        }

        this.indice = 0;
        this.hash = new HashMap<>();
        for (int i = 0; i < inorden.length; i++) {
            hash.put(inorden[i], i);
        }
        this.raiz = generarArbol(preorden, 0, preorden.length - 1);
    }

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

    public void imprimirInorden() {
        this.imprimirInorden(this.raiz);
    }

    private void imprimirInorden(Nodo nodo) {
        if (nodo == null)
            return;
        imprimirInorden(nodo.getHijoIz());
        System.out.print(nodo.getItem() + " ");
        imprimirInorden(nodo.getHijoDer());
    }

    public void imprimirPostorden() {
        this.imprimirPostorden(this.raiz);
    }

    private void imprimirPostorden(Nodo nodo) {
        if (nodo == null)
            return;
        imprimirPostorden(nodo.getHijoIz());
        imprimirPostorden(nodo.getHijoDer());
        System.out.print(nodo.getItem() + " ");
    }


}

