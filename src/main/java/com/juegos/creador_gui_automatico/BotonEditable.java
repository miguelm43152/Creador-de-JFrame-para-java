package com.juegos.creador_gui_automatico;

import javax.swing.JButton;

public class BotonEditable extends JButton {
    
    String nombre;

    public BotonEditable(){
        super();
    }//fin de metodo constructor

    public BotonEditable(String a){
        super(a);
    }//fin de metodo constructor

    public void setNombre(String nombre){
        this.nombre = nombre;
    }// fin de metodo setter

    public String getNombre(){
        return this.nombre;
    }//fin de metodo getter

}//fin de clase BotonEditable
