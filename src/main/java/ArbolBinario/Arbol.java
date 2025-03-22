package ArbolBinario;

public class Arbol {
    private Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public void insertar(int dato) {
        if (this.raiz == null) {
            this.raiz = new Nodo(dato);
        } else {
            this.insertar(this.raiz, dato);
        }
    }

    private void insertar(Nodo padre, int dato) {
        if (dato < padre.valorNodo()) {
            if (padre.getSubarbolIzdo() == null) {
                padre.setRamaIzdo(new Nodo(dato));
            } else {
                insertar(padre.getSubarbolIzdo(), dato);
            }
        } else if (dato > padre.valorNodo()) {
            if (padre.getSubarbolDcho() == null) {
                padre.setRamaDcho(new Nodo(dato));
            } else {
                insertar(padre.getSubarbolDcho(), dato);
            }
        }
    }
}
