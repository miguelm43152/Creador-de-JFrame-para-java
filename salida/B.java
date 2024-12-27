
import javax.swing.*;
import java.awt.Color;

public class B extends JFrame {

	int anchoFrame = 480;
	int altoFrame = 640;
	int x = 720;
	int y = 220;
	int r = 238;
	int g = 238;
	int b = 238;
	JButton boton0 = new JButton("boton0");
	JButton boton1 = new JButton("boton1");
	

	public B(){

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(this.anchoFrame,this.altoFrame);
        setLocation(this.x, this.y);
        setTitle("B");
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

                
        }//fin de metodo agregarBotones

	public static void main(String[] args) {

        B frame = new B();
        frame.setVisible(true);
        
	}//fin de metodo main

}//fin de clase B

