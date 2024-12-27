
import javax.swing.*;
import java.awt.Color;

public class D extends JFrame {

	int anchoFrame = 480;
	int altoFrame = 640;
	int x = 720;
	int y = 220;
	int r = 238;
	int g = 238;
	int b = 238;
	JButton boton0 = new JButton("boton0");
	JButton boton1 = new JButton("boton1");
	JButton boton2 = new JButton("boton2");
	JButton boton3 = new JButton("boton3");
	JButton boton4 = new JButton("boton4");
	JButton boton5 = new JButton("boton5");
	

	public D(){

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(this.anchoFrame,this.altoFrame);
        setLocation(this.x, this.y);
        setTitle("D");
        getContentPane().setBackground(new Color(r,g,b));
        agregarBotones();
	}//fin del constructor

        public void agregarBotones(){
                //aqui vamos a agregar todos los botones
                
		boton0.setSize(150,25);
                boton0.setLocation(50,50);
                add(boton0);

                boton1.setSize(150,25);
                boton1.setLocation(70,76);
                add(boton1);

                boton2.setSize(150,25);
                boton2.setLocation(90,102);
                add(boton2);

                boton3.setSize(150,25);
                boton3.setLocation(110,128);
                add(boton3);

                boton4.setSize(150,25);
                boton4.setLocation(130,154);
                add(boton4);

                boton5.setSize(150,25);
                boton5.setLocation(150,180);
                add(boton5);

                
        }//fin de metodo agregarBotones

	public static void main(String[] args) {

        D frame = new D();
        frame.setVisible(true);
        
	}//fin de metodo main

}//fin de clase D

