package GenerarArbol;

public class Main {

    public static void main(String[] args) {
        String[] preorden = new String[] { "A", "B", "D", "E", "C", "F" };
        String[] inorden = new String[] { "D", "B", "E", "A", "F", "C" };
        Arbol arbol = new Arbol(preorden, inorden);

        System.out.print("Inorden: ");
        arbol.imprimirInorden();

        System.out.print("Postorden: ");
        arbol.imprimirPostorden();
    }
}
