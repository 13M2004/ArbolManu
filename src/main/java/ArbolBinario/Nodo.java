package ArbolBinario;

public class Nodo {
    protected int dato;
    protected Nodo izdo;
    protected Nodo dcho;

    //primer constructor
    public Nodo(int valor) {
        dato = valor;
        izdo = dcho = null;
    }

    //segundo constructor
    public Nodo (Nodo ramaIzdo, int valor, Nodo ramaDcho){
        dato = valor;
        izdo = ramaIzdo;
        dcho = ramaDcho;
    }

    //accesos:
    public int valorNodo(){
        return dato;
    }

    public Nodo getSubarbolIzdo(){
        return izdo;
    }

    public Nodo getSubarbolDcho(){
        return dcho;
    }

    public void setRamaIzdo (Nodo n){
        izdo = n;
    }
    public void setRamaDcho (Nodo n){
        dcho = n;
    }

    public void imprimirDato (){
        System.out.println(this.valorNodo());
    }
}
