package Datos;


public class NodoPersona {

    private Personas personas;
    private NodoPersona izquierdo;
    private NodoPersona derecha;

    public NodoPersona(Personas personas){
        this.personas = personas;
        this.izquierdo = null;
        this.derecha = null;
    }

    public NodoPersona(NodoPersona ramaiz, Personas personas, NodoPersona ramade) {
        this.personas = personas;
        this.izquierdo = ramaiz;
        this.derecha = ramade;
    }

    public Personas valornodo(){
        return personas;
    }

    public NodoPersona getIzquierdo(){
        return izquierdo;
    }

    public NodoPersona getDerecha(){
        return derecha;
    }

    public void setIzquierdo (NodoPersona M){
        izquierdo = M;
    }

    public void setDerecha (NodoPersona M){
        derecha = M;
    }





}
