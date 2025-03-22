package ArbolCadena;

public class NodoCadena {
    protected String dato;
    protected NodoCadena izdo;
    protected NodoCadena dcho;

    //primer constructor
    public NodoCadena( String valor) {
        dato = valor;
        izdo = dcho = null;
    }

    //segundo constructor
    public NodoCadena(NodoCadena ramaIzdo, String valor, NodoCadena ramaDcho){
        dato = valor;
        izdo = ramaIzdo;
        dcho = ramaDcho;
    }

    //accesos:
    public String valorNodoCadena(){
        return dato;
    }

    public NodoCadena getSubarbolIzdo(){
        return izdo;
    }

    public NodoCadena getSubarbolDcho(){
        return dcho;
    }

    public void setRamaIzdo (NodoCadena n){
        izdo = n;
    }
    public void setRamaDcho (NodoCadena n){
        dcho = n;
    }

    public void imprimirDato (){
        System.out.println(this.valorNodoCadena());
    }
}


