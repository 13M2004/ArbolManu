package org.miumg;

import Datos.ArbolPersona;
import Datos.Personas;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
/*
        Arbol aarbol = new Arbol();
        aarbol.insertar(6);
        aarbol.insertar(10);
        aarbol.insertar(4);
        aarbol.insertar(8);
        aarbol.insertar(5);
        aarbol.insertar(3);
        aarbol.insertar(15);
        // aarbol.insertar(8);
        //aarbol.insertar(11);

        ArbolCadena ar = new ArbolCadena();
        ar.insertar("Farore");
        ar.insertar("Impa");
        ar.insertar("Navi");
        ar.insertar("Farore");


        System.out.println("fin!");
    }*/

        ArbolPersona perso = new ArbolPersona();

        //Nodo Padre
        Personas p1 = new Personas();
        p1.setNumeroTelefono(58103302);
        p1.setNombre("Manuel");
        p1.setDireccion("Zona Mit1");

        Personas p2 = new Personas();
        p2.setNumeroTelefono(11225533);
        p2.setNombre("Nayeli");
        p2.setDireccion("Zona Mit2");

        Personas p3 = new Personas();
        p3.setNumeroTelefono(22334455);
        p3.setNombre("Melissa");
        p3.setDireccion("Zona Mit3");

        Personas p4 = new Personas();
        p4.setNumeroTelefono(33114455);
        p4.setNombre("Alexander");
        p4.setDireccion("Zona Mit4");

        //Insertar
        perso.insertar(p1);
        perso.insertar(p2);
        perso.insertar(p3);
        perso.insertar(p4);

        System.out.println("\nMostrando el árbol en ORDEN:");

        perso.mostrarInOrden();

        System.out.println("\nProceso Finalizado");
    }

}


