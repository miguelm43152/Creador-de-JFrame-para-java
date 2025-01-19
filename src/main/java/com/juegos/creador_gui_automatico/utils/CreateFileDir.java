package com.juegos.creador_gui_automatico.utils;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;

import com.juegos.creador_gui_automatico.BotonEditable;
//import com.juegos.creador_gui_automatico.*;
import com.juegos.creador_gui_automatico.k.*;

public class CreateFileDir {  
  public String dir = System.getProperty("user.dir");
  String mensaje = "";
  String title = "MyFrame";
  String fileName = title+".java";
  int tamagnoX = 480;
  int tamagnoY = 640;
  int x=500;
  int y=250;
  int r,g,b = 238;
  String filepath;
  BloqueTexto bloqueTexto = new BloqueTexto();
  ArrayList<BotonEditable> botones = new ArrayList<BotonEditable>();

  public CreateFileDir(String filepath){
    this.filepath = filepath;
  }//fin de metodo constructor
  
  public void setTitle(String title){
    this.title = title;
  }//fin de metodo setTitle

  public void setSize(int tamagnoX, int tamagnoY){
    this.tamagnoX = tamagnoX;
    this.tamagnoY = tamagnoY;
  }//fin de metodo setSize

  public void setLocation(int x, int y){
    this.x  = x;
    this.y = y;
  }//fin de metodo setLocation

  public void setColor(int r, int g, int b){
    this.r = r;
    this.g = g;
    this.b = b;
  }//fin de metodo setColor

  public void setBotones(ArrayList<BotonEditable> b){
    this.botones = b;
  }//fin de metoodo setBotones

  public String quitarExtension(String nombreArchivo){
    int tamagno = nombreArchivo.length();
    return nombreArchivo.substring(0, tamagno-5);
  }//fin de metodo agregarExtension
  
  public void crearArchivo(){
    try {  

        System.out.println("a");
      //File myObj = new File( this.dir + "\\salida\\"+this.fileName);  
      File myObj = new File(this.filepath);  
      this.title = quitarExtension(myObj.getName());
      System.out.println("File created: " + myObj.getName());  
      System.out.println("File created: " + myObj.getAbsolutePath());  
      System.out.println("b");
      if (myObj.createNewFile()) {  
        System.out.println("File created: " + myObj.getName());  
        System.out.println("Absolute path: " + myObj.getAbsolutePath());  
      } else {  
        System.out.println("File already exists.");  
      }  
      System.out.println("c");
    } catch (IOException e) {
      System.out.println("An error occurred while creating file.");
      e.printStackTrace();
    }   
  }//fin de metodo crearArchivo

  public void escribirEnArchivo(){

        try {  
          //FileWriter myWriter = new FileWriter(this.dir + "\\salida\\"+this.fileName);
          FileWriter myWriter = new FileWriter(this.filepath);
          myWriter.write(this.mensaje);
          myWriter.close();
          System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
          System.out.println("An error occurred while writting file.");
          e.printStackTrace();
        }
  }//fin de metodo escribirEnArchivo

  public void escribiendoMensaje(){

    bloqueTexto.setTitle(this.title);
		bloqueTexto.setAnchoFrame(this.tamagnoX);
		bloqueTexto.setAltoFrame(this.tamagnoY);
		bloqueTexto.setX(this.x);
		bloqueTexto.setY(this.y);
		bloqueTexto.setR(this.r);
		bloqueTexto.setG(this.g);
		bloqueTexto.setB(this.b);
    bloqueTexto.setBotones(this.botones);

		bloqueTexto.prepararMensaje();
    this.mensaje = bloqueTexto.getMensaje();
    
  }//fin de metodo escribiendoMensaje
  
}//fin de clase CreateFileDir