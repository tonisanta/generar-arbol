package GenerarArbol;

public class Nodo {
    private final String item;
    private Nodo hijoIz;
    private Nodo hijoDer;

    public Nodo(String item) {
        this.item = item;
        this.hijoIz = null;
        this.hijoDer = null;
    }

    public String getItem() {
        return item;
    }

    public void setHijoIz(Nodo hijoIz) {
        this.hijoIz = hijoIz;
    }

    public void setHijoDer(Nodo hijoDer) {
        this.hijoDer = hijoDer;
    }

    public Nodo getHijoIz() {
        return hijoIz;
    }

    public Nodo getHijoDer() {
        return hijoDer;
    }
}
