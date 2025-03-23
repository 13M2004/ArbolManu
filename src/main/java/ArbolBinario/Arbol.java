package ArbolBinario;

public class Arbol {
    private Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public Nodo getRaiz() {
        return this.raiz;
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

    //Metodo para recorrdio en POSTORDEN
    public void postorden(){
        postorden(this.raiz);
    }

    private void postorden(Nodo nodo){
        if (nodo != null) {
            postorden(nodo.getSubarbolIzdo());
            postorden(nodo.getSubarbolDcho());
            System.out.println(nodo.valorNodo() + "");
        }
    }


    //Metodo para recorrdio en PREORDEN
    public void preorden(){
        preorden(this.raiz);
    }

    private void preorden(Nodo nodo){
        if (nodo != null) {
            System.out.println(nodo.valorNodo() + "");
            preorden(nodo.getSubarbolIzdo());
            preorden(nodo.getSubarbolDcho());
        }
    }


    //METODO PARA RECORRIDO EN INORDEN
    public void inorden() {
        inorden(this.raiz);
    }

    private void inorden(Nodo nodo) {
        if (nodo!= null){
            inorden(nodo.getSubarbolIzdo());
            System.out.print(nodo.valorNodo()+ " ");
            inorden(nodo.getSubarbolDcho());

        }
    }

    //-------
    public void mostrarArbolGrafico() {
        System.out.println("\nArbol Binario:");
        mostrarArbolGrafico(this.raiz, "     ", true, true);
    }

    private void mostrarArbolGrafico(Nodo nodo, String prefijo, boolean esIzquierdo, boolean esRaiz) {
        if (nodo != null) {
            if (esRaiz) {
                System.out.println(prefijo + "(---" + nodo.valorNodo() + "---)");
            } else {
                System.out.println(prefijo + "(" + nodo.valorNodo() + ")");
            }

            if (nodo.getSubarbolIzdo() != null || nodo.getSubarbolDcho() != null) {
                System.out.println(prefijo + "/   \\");
            }

            String prefijoIzquierdo = prefijo + "";
            String prefijoDerecho = prefijo + "    ";

            if (nodo.getSubarbolIzdo() != null) {
                mostrarArbolGrafico(nodo.getSubarbolIzdo(), prefijoIzquierdo, true, false);
            }
            if (nodo.getSubarbolDcho() != null) {
                mostrarArbolGrafico(nodo.getSubarbolDcho(), prefijoDerecho, false, false);
            }
        }
    }



}
