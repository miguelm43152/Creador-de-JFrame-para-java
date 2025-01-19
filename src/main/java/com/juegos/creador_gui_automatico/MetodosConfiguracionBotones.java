package com.juegos.creador_gui_automatico;

import javax.swing.event.*;
import java.awt.event.*;;

public class MetodosConfiguracionBotones {

    App outer;

    public MetodosConfiguracionBotones(App outer){
        this.outer = outer;
        outer.crearJFrames.panelConfiguracionJButton.entradaTexto.addKeyListener(new SetTextBoton());
        outer.crearJFrames.panelConfiguracionJButton.entradaNombreVariable.addKeyListener(new SetNameVar());
        outer.crearJFrames.panelConfiguracionJButton.setSizeJSpinners[0].addChangeListener(new SetSizeBoton());
        outer.crearJFrames.panelConfiguracionJButton.setSizeJSpinners[1].addChangeListener(new SetSizeBoton());
        
        outer.crearJFrames.panelConfiguracionJButton.setLocationJSpinners[0].addChangeListener( new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                int x = Integer.parseInt(outer.crearJFrames.panelConfiguracionJButton.setLocationJSpinners[0].getValue().toString());
                outer.crearJFrames.panelConfiguracionJButton.getBoton().setLocation(x,outer.crearJFrames.panelConfiguracionJButton.getBoton().getY());
            }//fin de metodo stateChanged
            
        } );

        outer.crearJFrames.panelConfiguracionJButton.setLocationJSpinners[1].addChangeListener( new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                int y = Integer.parseInt(outer.crearJFrames.panelConfiguracionJButton.setLocationJSpinners[1].getValue().toString());
                outer.crearJFrames.panelConfiguracionJButton.getBoton().setLocation(outer.crearJFrames.panelConfiguracionJButton.getBoton().getX(),y);
            }//fin de metodo stateChanged
            
        } );
    }//fin de metodo constructor

    public class SetTextBoton implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }//fin de metodo keyTyped

        @Override
        public void keyPressed(KeyEvent e) {
        }//fin de metodo keyPressed
        
        @Override
        public void keyReleased(KeyEvent e) {
            outer.crearJFrames.panelConfiguracionJButton.getBoton().setText(outer.crearJFrames.panelConfiguracionJButton.entradaTexto.getText());
        }//fin de metodo keyReleased
        
    }//fin de clase interna SetTextBoton

    public class SetNameVar implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {}//fin de metodo keyTyped
        @Override
        public void keyPressed(KeyEvent e) {}//fin de metodo keyPressed
        @Override
        public void keyReleased(KeyEvent e) {
            outer.crearJFrames.panelConfiguracionJButton.getBoton().setName(outer.crearJFrames.panelConfiguracionJButton.entradaNombreVariable.getText());
        }//fin de metodo keyReleased
        
    }//fin de clase interna SetNameVar

    public class SetSizeBoton implements ChangeListener{

        @Override
        public void stateChanged(ChangeEvent e) {
            String w = outer.crearJFrames.panelConfiguracionJButton.setSizeJSpinners[0].getValue().toString();
            String h = outer.crearJFrames.panelConfiguracionJButton.setSizeJSpinners[1].getValue().toString();

            int width = Integer.parseInt(w);
            int height = Integer.parseInt(h);

            outer.crearJFrames.panelConfiguracionJButton.getBoton().setSize(width,height);
        }//fin de metodo stateChanged
        
    }//fin de clase interna SetSizeBoton
    
}//fin de clase MetodosConfiguracionBotones
