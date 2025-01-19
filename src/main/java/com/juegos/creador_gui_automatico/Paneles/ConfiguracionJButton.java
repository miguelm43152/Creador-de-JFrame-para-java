package com.juegos.creador_gui_automatico.Paneles;

import java.awt.Color;

import javax.swing.*;

import com.juegos.creador_gui_automatico.BotonEditable;

public class ConfiguracionJButton extends JPanel {

    public JTextField entradaTexto = new JTextField();
    public JTextField entradaNombreVariable = new JTextField();
    public JSpinner[] setSizeJSpinners = new JSpinner[2];
    public JSpinner[] setLocationJSpinners = new JSpinner[2]; 
    BotonEditable boton = new BotonEditable();

    public BotonEditable getBoton(){
        return this.boton;
    }

    public ConfiguracionJButton(){
        this.setVisible(false);
        this.setLayout(null);
        this.setLocation(20,70);
        this.setSize(280,100);
        this.setBackground(Color.LIGHT_GRAY);

        //Agregando JLabels
        JLabel texto = new JLabel("Texto:");
        JLabel size = new JLabel("Size:");
        JLabel location = new JLabel("Location:");
        JLabel variable = new JLabel("Variable Identificador:");

        texto.setLocation(0,0);
        texto.setSize(100,25);
        size.setLocation(0,25);
        size.setSize(100,25);
        location.setLocation(0,50);
        location.setSize(100,25);
        variable.setLocation(0,75);
        variable.setSize(200,25);

        add(texto);
        add(size);
        add(location);
        add(variable);

        entradaTexto.setLocation(40,5);
        entradaTexto.setSize(100,18);
        add(entradaTexto);

        entradaNombreVariable.setLocation(135,80);
        entradaNombreVariable.setSize(100,18);
        add(entradaNombreVariable);

        for(int i = 0 ; i < setSizeJSpinners.length ; i++){
            setSizeJSpinners[i] = new JSpinner(new SpinnerNumberModel(150-i*125, 0, 5000, 5));// value, min, max, step
            setSizeJSpinners[i].setSize(80,20);
            setSizeJSpinners[i].setFocusable(false);
            this.add(setSizeJSpinners[i]);
        }
        setSizeJSpinners[0].setLocation(40,30);
        setSizeJSpinners[1].setLocation(135,30);

        for(int i = 0 ; i < setLocationJSpinners.length ; i++){
            setLocationJSpinners[i] = new JSpinner(new SpinnerNumberModel(50, 0, 5000, 5));// value, min, max, step
            setLocationJSpinners[i].setSize(80,20);
            //setLocationJSpinners[i].setEnabled(false);
            this.add(setLocationJSpinners[i]);
        }
        setLocationJSpinners[0].setLocation(70,55);
        setLocationJSpinners[1].setLocation(165,55);
        
    }//fin de metodo constructor
 
    public void setBoton(BotonEditable b){
        this.boton = b;
        entradaTexto.setText( b.getText() );
        entradaNombreVariable.setText( b.getNombre() );
        int w = b.getWidth();
        int h = b.getHeight();
        setSizeJSpinners[0].setValue( w );
        setSizeJSpinners[1].setValue( h );
        int y = b.getY();
        int x = b.getX();
        setLocationJSpinners[1].setValue( y );
        setLocationJSpinners[0].setValue( x );
    }//fin de metodo setBoton
    
}// fin de clase ConfiguracionJButton