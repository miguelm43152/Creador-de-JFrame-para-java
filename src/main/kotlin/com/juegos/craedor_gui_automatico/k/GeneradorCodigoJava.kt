package com.juegos.creador_gui_automatico.k;
import javax.swing.JButton;
import java.util.ArrayList;
class BloqueTexto{
    var title:String?=null;
    var anchoFrame:Int?=null;
    var altoFrame:Int?=null;
    var x:Int?=null;
    var y:Int?=null;
    var r:Int?=null;
    var g:Int?=null;
    var b:Int?=null;
    var mensaje:String?=null;
    var botones:ArrayList<JButton> = ArrayList<JButton>()
        set(value) {
                // Puedes agregar lógica personalizada aquí, por ejemplo:
                field = value
                println("Se han actualizado los botones. Nuevo tamaño: ${field.size}")
        }

    fun prepararMensaje(){
        var declaracion:String = "\n\t";
        var dimensiones:String = "\n\t\t";
        for(i in botones){
                declaracion+= "JButton ${i.getText()} = new JButton(\"${i.getText()}\");\n\t";
        }
        for(i in botones){
                dimensiones+="""${i.getText()}.setSize(${i.getWidth()},${i.getHeight()});
                ${i.getText()}.setLocation(${i.getX()},${i.getY()});
                add(${i.getText()});

                """
        }

        this.mensaje ="""
import javax.swing.*;
import java.awt.Color;

public class ${title} extends JFrame {

	int anchoFrame = ${anchoFrame};
	int altoFrame = ${altoFrame};
	int x = ${x};
	int y = ${y};
	int r = ${r};
	int g = ${g};
	int b = ${b};"""+ declaracion +"""

	public ${title}(){

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(this.anchoFrame,this.altoFrame);
        setLocation(this.x, this.y);
        setTitle("${title}");
        getContentPane().setBackground(new Color(r,g,b));
        agregarBotones();
	}//fin del constructor
"""+"""
        public void agregarBotones(){
                //aqui vamos a agregar todos los botones
                """+dimensiones+"""
        }//fin de metodo agregarBotones
"""+"""
	public static void main(String[] args) {

        ${title} frame = new ${title}();
        frame.setVisible(true);
        
	}//fin de metodo main

}//fin de clase ${title}

""";
    }//fin de metodo prepararMensaje
}//fin de clase BloqueTexto