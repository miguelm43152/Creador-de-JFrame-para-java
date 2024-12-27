
import javax.swing.*;
import java.awt.Color;

public class F extends JFrame {

	int anchoFrame = 480;
	int altoFrame = 640;
	int x = 720;
	int y = 220;
	int r = 238;
	int g = 238;
	int b = 238;
	

	public F(){

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(this.anchoFrame,this.altoFrame);
        setLocation(this.x, this.y);
        setTitle("F");
        getContentPane().setBackground(new Color(r,g,b));
        agregarBotones();
	}//fin del constructor

        public void agregarBotones(){
                //aqui vamos a agregar todos los botones
                
		
        }//fin de metodo agregarBotones

	public static void main(String[] args) {

        F frame = new F();
        frame.setVisible(true);
        
	}//fin de metodo main

}//fin de clase F

