package com.juegos.creador_gui_automatico;
import java.awt.event.*;
public class AgregarComponenteBoton implements ActionListener{

    App outer;
    public AgregarComponenteBoton(App app){
        this.outer = app;
    }//fin de metodo constructor

    @Override
    public void actionPerformed(ActionEvent e) {
        BotonEditable a = outer.frameEditable.agregarBoton();
        a.addKeyListener(new EliminarBoton());
        a.addMouseListener(new ClickBoton(a));
        a.addMouseMotionListener(new MoviendoBoton(a));
        outer.crearJFrames.panelConfiguracionJButton.setBoton(a);
        outer.crearJFrames.panelConfiguracionJButton.setVisible(true);
    }//fin de metodo actionPerformed

    public class EliminarBoton implements KeyListener {
    
        public void eliminarBoton(){
            outer.crearJFrames.panelConfiguracionJButton.setVisible(false);
        }//fin de metodo eliminarBoton
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if( e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
                eliminarBoton();
            }
            if(e.getKeyCode() == KeyEvent.VK_DELETE){
                eliminarBoton();
            }
        }//Fin de metodo keyPressed
        @Override
        public void keyReleased(KeyEvent e) {
        }
        
    }//fin de clase interna EliminarBoton

    public class MoviendoBoton implements MouseMotionListener{

        BotonEditable boton;
        public MoviendoBoton(BotonEditable b){
            this.boton = b;
        }//fin de metodo constructor

        @Override
        public void mouseDragged(MouseEvent e) {
            outer.crearJFrames.panelConfiguracionJButton.setLocationJSpinners[0].setValue(outer.crearJFrames.panelConfiguracionJButton.getBoton().getX());
            outer.crearJFrames.panelConfiguracionJButton.setLocationJSpinners[1].setValue(outer.crearJFrames.panelConfiguracionJButton.getBoton().getY());
            outer.crearJFrames.panelConfiguracionJButton.setBoton(this.boton);
        }//fin de metodo mouseDragged

        @Override
        public void mouseMoved(MouseEvent e) {
        }//fin de metodo mouseMoved
    }//fin de clase interna MoviendoBoton

    public class ClickBoton implements MouseListener{

        BotonEditable boton;

        ClickBoton(BotonEditable boton){
            this.boton = boton;
        }//fin de metodo constructor

        @Override
        public void mouseClicked(MouseEvent e) {
            outer.crearJFrames.panelConfiguracionJButton.setBoton(this.boton);
            outer.crearJFrames.panelConfiguracionJButton.setVisible(true);
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}

    }//fin de clase interna ClickBoton

}//fin de clase AgregarComponenteBoton