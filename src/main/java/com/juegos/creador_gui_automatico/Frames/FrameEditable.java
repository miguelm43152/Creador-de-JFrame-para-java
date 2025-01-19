package com.juegos.creador_gui_automatico.Frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.juegos.creador_gui_automatico.BotonEditable;

import java.awt.event.*;

public class FrameEditable extends JFrame{
    int altoFrame = 640;
    int anchoFrame = 480;
    public ArrayList <BotonEditable> listaBotones = new ArrayList<BotonEditable>();

    public FrameEditable(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(this.anchoFrame,this.altoFrame);
        posicion();
        setFocusable(false);
    }//fin del constructor

    public BotonEditable agregarBoton( ){

        int indiceBotones;
        BotonEditable a = new BotonEditable();
        listaBotones.add( a );
        indiceBotones = listaBotones.size() - 1;
        a.setNombre("varboton"+indiceBotones);
        a.setLocation(50 + indiceBotones*20, 50 + indiceBotones * 26);
        a.setSize(150,25);
        add( a );
        //a.setText( "<html><font color=black>boton</font><font color=black> "+indiceBotones+"</font></html>");
        a.setText("boton" + indiceBotones);
        a.setBackground(new Color(238,238,238));        
        
        a.addKeyListener(new Teclado(a));
        a.addMouseMotionListener( new ArrastrarBoton(a));

        return a;

    }//fin de metodo agregarBoton

        public class Teclado implements KeyListener {

        JButton boton;

        public Teclado(JButton boton){
            this.boton = boton;
        }//Fin de metodo constructor

        public void eliminarBoton(){
            FrameEditable.this.listaBotones.remove(boton);
            FrameEditable.this.remove(this.boton);
            FrameEditable.this.revalidate();
            FrameEditable.this.repaint();
        }//fin de metodo eliminarBoton

        @Override
        public void keyPressed(KeyEvent e) {
            if( e.getKeyCode() == KeyEvent.VK_ENTER){
                System.out.println(this.boton.getX() + ", " + this.boton.getY());
            }
            if( e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
                eliminarBoton();
            }
            if(e.getKeyCode() == KeyEvent.VK_DELETE){
                eliminarBoton();
            }
        }//Fin de metodo keyPressed

        @Override
        public void keyReleased(KeyEvent e) {}//fin de metodo keyReleased

        @Override
        public void keyTyped(KeyEvent e) {}//fin de metodo keyTyped

    }//fin de clase Teclado

    public class ArrastrarBoton implements MouseMotionListener{
        JButton boton;
        public ArrastrarBoton(JButton b){
            this.boton = b;
        }//fin de metodo constructor

        @Override
        public void mouseDragged(MouseEvent e) {
            int x = e.getXOnScreen() - FrameEditable.this.getX() - this.boton.getWidth()/2;
            int y = e.getYOnScreen() - FrameEditable.this.getY() - this.boton.getHeight()/2;

            //System.out.println(x + ", " + y);
            this.boton.setLocation(x,y);
            if( x < 0 )//esquina superior izquierda
                this.boton.setLocation(0,this.boton.getY());
            if( y < 0 )//esquina superior izquierda
                this.boton.setLocation(this.boton.getX(),0);

            if( x > FrameEditable.this.getWidth() - this.boton.getWidth() )
                this.boton.setLocation( FrameEditable.this.getWidth() - this.boton.getWidth(), this.boton.getY() );
            
            if( y > FrameEditable.this.getHeight() - this.boton.getHeight())
                this.boton.setLocation( this.boton.getX(), FrameEditable.this.getHeight() - this.boton.getHeight() );

        }//fin de metodo mouseDragged

        @Override
        public void mouseMoved(java.awt.event.MouseEvent e) {
        }//fin de metodo mouseMoved

    }//fin de clase ArrastrarBoton  

    void posicion(){
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int altoPantalla = (int)d.getHeight();
        int anchoPantalla = (int)d.getWidth();
        setLocation((anchoPantalla-anchoFrame)/2,(altoPantalla - altoFrame)/2);
    }//fin de metodo posicion
}//fin de la clase FrameEditable