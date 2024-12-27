package com.juegos.creador_gui_automatico;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.File;

import com.juegos.creador_gui_automatico.Frames.*;
import com.juegos.creador_gui_automatico.utils.CreateFileDir;
import com.juegos.creador_gui_automatico.*;
import com.juegos.creador_gui_automatico.k.*;

public class App {
    FrameEditable frameEditable;
    CrearJFrames crearJFrames;
    int altoPantalla;
    int anchoPantalla;

    App(){
        crearJFrames = new CrearJFrames();
        crearJFrames.setVisible(true);

        frameEditable = new FrameEditable();
        frameEditable.setVisible(true);
        dimensionesPantalla();

        frameEditable.addComponentListener(new MoviendoFrame());
        crearJFrames.setSizeJSpinners[0].addChangeListener(new setSizeJSpinner());
        crearJFrames.setSizeJSpinners[1].addChangeListener(new setSizeJSpinner());
        crearJFrames.setLocationJSpinners[0].addChangeListener(new setLocationJSpinner());
        crearJFrames.setLocationJSpinners[1].addChangeListener(new setLocationJSpinner());
        crearJFrames.agregarBoton.addActionListener(new AgregarComponenteBoton());

        crearJFrames.centrarFrame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                centrarFrame();
            }
        });
        for(int i = 0 ; i < 3 ; i++)
        crearJFrames.color[i].addChangeListener(new CambiarColorFondo());

        crearJFrames.guardarFrame.addActionListener(new Guardar());
        SaludoKt.main();
    }//fin de metodo constructor

    public void dimensionesPantalla(){
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();

        this.altoPantalla = (int)d.getHeight();
        this.anchoPantalla = (int)d.getWidth();
    }//fin de metodo

    public void centrarFrame(){
        int tamagnoX = Integer.parseInt(crearJFrames.setSizeJSpinners[0].getValue().toString());
        int tamagnoY = Integer.parseInt(crearJFrames.setSizeJSpinners[1].getValue().toString());

        frameEditable.setLocation(( this.anchoPantalla - tamagnoX )/2,(this.altoPantalla - tamagnoY )/2);
    }//fin de metodo centrar frame

    public void moverFrame(){
        int posX = Integer.parseInt(crearJFrames.setLocationJSpinners[0].getValue().toString());
        int posY = Integer.parseInt(crearJFrames.setLocationJSpinners[1].getValue().toString());

        frameEditable.setLocation(posX,posY);
    }//fin de metodo moverFrame

    public class AgregarComponenteBoton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            frameEditable.agregarBoton();
        }//fin de metodo actionPerformed
    }//fin de clase AgregarComponenteBoton

    public class MoviendoFrame implements ComponentListener{

        @Override
        public void componentResized(ComponentEvent e) {
            crearJFrames.centrarFrame.setSelected(false);
            int ancho = frameEditable.getWidth();
            int alto = frameEditable.getHeight();
            crearJFrames.setSizeJSpinners[0].setValue(ancho);
            crearJFrames.setSizeJSpinners[1].setValue(alto);
        }

        @Override
        public void componentMoved(ComponentEvent e) {
            crearJFrames.centrarFrame.setSelected(false);
            int x = frameEditable.getX();
            int y = frameEditable.getY();
            crearJFrames.setLocationJSpinners[0].setValue(x);
            crearJFrames.setLocationJSpinners[1].setValue(y);
        }

        @Override
        public void componentShown(ComponentEvent e) {}

        @Override
        public void componentHidden(ComponentEvent e) {}

    }//fin de clase MoviendoFrame

    public class Guardar implements ActionListener{

        public String savePath(){
            
            String filepath = null;
            JFileChooser selectorArchivo = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Java Source Code", "java");
            selectorArchivo.setCurrentDirectory(new File("."));
            selectorArchivo.setFileFilter(filter);
            selectorArchivo.setDialogTitle("Guardar clase java");
            //selectorArchivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY );
            int result = selectorArchivo.showSaveDialog(selectorArchivo);

            if( result == JFileChooser.APPROVE_OPTION){
                File selectedFile = selectorArchivo.getSelectedFile();
                filepath = selectedFile.getAbsolutePath();
                System.out.println(filepath);
            }else if(result == JFileChooser.CANCEL_OPTION ){
                return filepath;
            }

            return filepath;
        }//fin de metodo savePath

        public String agregarExtension(String nombreArchivo){
            int tamagno = nombreArchivo.length();
            if(tamagno < 6){
                nombreArchivo += ".java";
                return nombreArchivo;
            }
    
            String extension = nombreArchivo.substring(tamagno-5, tamagno);
            extension = extension.toLowerCase();
            if( extension.equals(".java") ){
                System.out.println("extension correcta");
            }else{
                nombreArchivo+=".java";
            }
            return nombreArchivo;
        }//fin de metodo agregarExtension

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Guardando");
            String filepath = this.savePath();

            if( filepath == null){
                JOptionPane.showMessageDialog(null, "No se ha seleccionado nada");
                return;
            }
            filepath = agregarExtension(filepath);

            int tamagnoX = Integer.parseInt(crearJFrames.setSizeJSpinners[0].getValue().toString());
            int tamagnoY = Integer.parseInt(crearJFrames.setSizeJSpinners[1].getValue().toString());
            boolean centrar = crearJFrames.centrarFrame.isSelected();
            int x = Integer.parseInt(crearJFrames.setLocationJSpinners[0].getValue().toString());
            int y = Integer.parseInt(crearJFrames.setLocationJSpinners[1].getValue().toString());
            //String titulo = "MyFrame";
            int r = Integer.parseInt(App.this.crearJFrames.color[0].getValue().toString());
            int g = Integer.parseInt(App.this.crearJFrames.color[1].getValue().toString());
            int b = Integer.parseInt(App.this.crearJFrames.color[2].getValue().toString());

            System.out.println(filepath);
            CreateFileDir c = new CreateFileDir(filepath);

            //c.setTitle(titulo);
            c.setSize(tamagnoX, tamagnoY);
            c.setLocation(x, y);
            c.setColor(r, g, b);
            c.setBotones(frameEditable.listaBotones);
            
            System.out.println(c.dir);
            c.crearArchivo();
            c.escribiendoMensaje();
            c.escribirEnArchivo();
            
        }// fin de metodo actionPerformed

    }// fin de clase Guardar

    public class CambiarColorFondo implements ChangeListener{

        @Override
        public void stateChanged(ChangeEvent e) {
            
            int r = Integer.parseInt(App.this.crearJFrames.color[0].getValue().toString());
            int g = Integer.parseInt(App.this.crearJFrames.color[1].getValue().toString());
            int b = Integer.parseInt(App.this.crearJFrames.color[2].getValue().toString());

            App.this.frameEditable.getContentPane().setBackground(new Color(r, g, b));
        }   
        
    }//fin de clase CambiarColorFondo

    public class SelectorCentrarFrame implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            for(int i = 0 ; i < crearJFrames.setLocationJSpinners.length ;i++){
                boolean isCheckBoxSelected = crearJFrames.centrarFrame.isSelected();
                crearJFrames.setLocationJSpinners[i].setEnabled( !isCheckBoxSelected );
                if(isCheckBoxSelected){
                    App.this.centrarFrame();
                }else{
                    App.this.moverFrame();
                }                
            }
        }//fin de metodo stateChanged
        
    }//fin de clase interna SelectorCentrarFrame

    public class setLocationJSpinner implements ChangeListener{

        @Override
        public void stateChanged(ChangeEvent e) {
            int posX = Integer.parseInt(App.this.crearJFrames.setLocationJSpinners[0].getValue().toString());    
            int posY = Integer.parseInt(App.this.crearJFrames.setLocationJSpinners[1].getValue().toString());    
            App.this.frameEditable.setLocation(posX,posY);
        }//fin de metodo stateChanged
        
    }// fin de clase interna setLocationJSpinnerX

    public class setSizeJSpinner implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            boolean isCheckBoxSelected = crearJFrames.centrarFrame.isSelected();
            int tamagnoX = Integer.parseInt(crearJFrames.setSizeJSpinners[0].getValue().toString());
            int tamagnoY = Integer.parseInt(crearJFrames.setSizeJSpinners[1].getValue().toString());
            frameEditable.setSize(tamagnoX,tamagnoY);
            if( isCheckBoxSelected )
            frameEditable.setLocation(( App.this.anchoPantalla - tamagnoX )/2,(App.this.altoPantalla - tamagnoY )/2);
        }//fin de metodo stateChanged
    }//fin de clase interna

    void saludo(){
        System.out.println("Iniciando Aplicacion...");
    }
    public static void main(String[] args){
        App app = new App();
        app.saludo();        
        System.out.println(app.frameEditable.getContentPane().getBackground().toString());
    }//fin de metodo main
}//fin de clase App
