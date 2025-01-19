
import javax.swing.*;
import java.awt.Color;

public class FrameDeSalida extends JFrame {

	int anchoFrame = 480;
	int altoFrame = 301;
	int x = 720;
	int y = 389;
	int r = 205;
	int g = 206;
	int b = 238;
	JButton varboton0 = new JButton("haz click aqui");
	JButton varboton1 = new JButton("o aqui");
	JButton varboton2 = new JButton("o mejor aqui");
	JButton varboton3 = new JButton("boton1");
	JButton varboton4 = new JButton("boton2");
	JButton varboton5 = new JButton("boton3");
	

	public FrameDeSalida(){

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(this.anchoFrame,this.altoFrame);
        setLocation(this.x, this.y);
        setTitle("FrameDeSalida");
        getContentPane().setBackground(new Color(r,g,b));
        setVisible(true);
        agregarBotones();
        
	}//fin del constructor

        public void agregarBotones(){
                //aqui vamos a agregar todos los botones
                
		varboton0.setSize(150,25);
                varboton0.setLocation(158,18);
                add(varboton0);

                varboton1.setSize(150,25);
                varboton1.setLocation(158,56);
                add(varboton1);

                varboton2.setSize(150,25);
                varboton2.setLocation(154,93);
                add(varboton2);

                varboton3.setSize(90,55);
                varboton3.setLocation(68,162);
                add(varboton3);

                varboton4.setSize(90,55);
                varboton4.setLocation(180,160);
                add(varboton4);

                varboton5.setSize(90,55);
                varboton5.setLocation(294,160);
                add(varboton5);

                
        }//fin de metodo agregarBotones

	public static void main(String[] args) {

        FrameDeSalida frame = new FrameDeSalida();
        frame.setVisible(true);
        
	}//fin de metodo main

}//fin de clase FrameDeSalida

