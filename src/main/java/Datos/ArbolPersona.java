package Datos;

public class ArbolPersona {

    private NodoPersona raiz;

    public ArbolPersona(){
        this.raiz = null;
    }

    public void insertar(Personas personas){
        if(this.raiz == null){
            this.raiz = new NodoPersona(personas);
        } else {
            this.insertar(this.raiz, personas);
        }
    }

    private void insertar(NodoPersona padre, Personas personas) {
        //Convierte de Entero a String (Para evaluar por unidad)
        String NumberActual = String.valueOf(personas.getNumeroTelefono());
        String NumberPadre = String.valueOf(padre.valornodo().getNumeroTelefono());

        //Evalua Padre con el Hijo (MENOR-IZQUIERDA)
        //Si es menor a la raiz, verificara si la clase hijo-izquierda esta vacio para colocarse
        // o evaluarse la que se esta ingresando.
        if(NumberActual.compareTo(NumberPadre) < 0) {
           if(padre.getIzquierdo() == null){
               padre.setIzquierdo(new NodoPersona(personas));
           } else {
               insertar(padre.getIzquierdo(), personas);
           }

        } else {

            //Evalua Padre con el Hijo (MAYOR-DERECHA)
            //En el caso que sea maypr a la raiz pasa evaluar si esta vacio se coloca
            //Si no se evalua el que ya esta y ese pasa ser padre...
            if(padre.getDerecha() == null) {
                padre.setDerecha(new NodoPersona(personas));
            } else {
                insertar(padre.getDerecha(), personas);
            }
        }

    }

    // Méetodo del reccorrido
    public void mostrarInOrden() {
        if (raiz == null) {
            System.out.println("El árbol está vacío");
        } else {
            recorridoInOrden(raiz);
        }
    }

    //  Recorrido Inorden
    private void recorridoInOrden(NodoPersona nodo) {
        if (nodo != null) {
            recorridoInOrden(nodo.getIzquierdo());
            System.out.println("Nombre: " + nodo.valornodo().getNombre() +
                    " | Teléfono: " + nodo.valornodo().getNumeroTelefono() +
                    " | Dirección: " + nodo.valornodo().getDireccion());
            recorridoInOrden(nodo.getDerecha());
        }
    }




}
