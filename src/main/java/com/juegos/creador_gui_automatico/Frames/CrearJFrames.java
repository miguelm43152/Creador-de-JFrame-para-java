package com.juegos.creador_gui_automatico.Frames;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import com.juegos.creador_gui_automatico.Paneles.*;

import javax.swing.*;

public class CrearJFrames extends JFrame{
    /*
     * Declaracion de atributos
     */
    
    int anchoFrame = 480;
    int altoFrame = 640;
    public JSpinner[] setSizeJSpinners = new JSpinner[2];
    public JSpinner[] setLocationJSpinners = new JSpinner[2]; 
    //public JCheckBox centrarFrame = new JCheckBox("Centrar frame?");
    public JButton centrarFrame = new JButton("Centrar frame");
    public JSpinner[] color = new JSpinner[3];
    public JButton guardarFrame = new JButton("Guardar");
    JPanel panelDecoracion;
    JPanel panelBounds;
    JButton alternarPaneles;
    public JPanel panelComponentes;
    public ConfiguracionJButton panelConfiguracionJButton;
    public JButton agregarBoton = new JButton("Agregar boton");

    /*
     * Declaracion de metodo constructor
     */
    public CrearJFrames(){
        getContentPane().setBackground(Color.YELLOW);
        dimensiones();
        setTitle("Creando Nuevo Frame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panelBounds();
        panelDecoracion();
        panelComponentes();

        //panelComponentes.addMouseListener(new PosicionMouse());
        panelConfiguracionJButton.addMouseListener(new PosicionMouse());

        alternarPaneles = new JButton("Agregar componentes");
        alternarPaneles.setSize(200,25);
        alternarPaneles.setLocation(25,325);
        add(this.alternarPaneles);
        alternarPaneles.addActionListener(new AlternarPaneles());

        guardarFrame.setSize(150,25);
        guardarFrame.setLocation((anchoFrame-150)/2,500);
        add(this.guardarFrame);
    }//fin de metodo constructor clase CrearJFrames

    public class PosicionMouse implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("x: " + e.getX() + ", Y: " + e.getY() );
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    
        
    }//fin de clase PosicionMouse

    public class AlternarPaneles implements ActionListener{
        boolean estado = true;
        @Override
        public void actionPerformed(ActionEvent e) {
            estado^=true;
            alternarPaneles.setText( !estado?"Dimensiones JFrame":"Agregar componentes" );
            panelDecoracion.setVisible(estado);
            panelBounds.setVisible(estado);
            panelComponentes.setVisible(!estado);

        }//fin de metodo actionPerformed
    }//fin de clase AlternarPaneles

    /*
     * Declaracion de metodos
     */

    public void dimensiones(){
        setLayout(null);
        setResizable(false);
        setSize(anchoFrame,altoFrame);
        setLocation(200,250);
    }//fin de metodo dimensiones

    public void panelComponentes(){
        panelComponentes = new JPanel();
        panelComponentes.setLayout(null);
        panelComponentes.setBackground(Color.LIGHT_GRAY);
        panelComponentes.setSize(430,200);
        panelComponentes.setLocation((this.anchoFrame-430)/2,30);
        panelComponentes.setVisible(false);
        this.add(panelComponentes);

        agregarBoton.setSize(150,50);
        agregarBoton.setLocation(20,10);
        panelComponentes.add(agregarBoton);
        panelConfiguracionJButton = new ConfiguracionJButton();
        panelComponentes.add(panelConfiguracionJButton);
    }//fin de metodo panelComponentes

    public void panelBounds(){

        String panelBoundsTextos[] = {"setSize:","setLocation:"};
        JLabel panelBoundsLabels[] = new JLabel[panelBoundsTextos.length];

        panelBounds = new JPanel();
        panelBounds.setLayout(null);
        panelBounds.setBackground(Color.LIGHT_GRAY);
        panelBounds.setSize(430,200);
        panelBounds.setLocation((this.anchoFrame-430)/2,30);
        this.add(panelBounds);
        for( int i = 0 ; i < panelBoundsTextos.length ; i++){
            panelBoundsLabels[i] = new JLabel(panelBoundsTextos[i]);
            panelBounds.add(panelBoundsLabels[i]);
            panelBoundsLabels[i].setSize(150,50);
        }
        panelBoundsLabels[0].setLocation(20,10);
        panelBoundsLabels[1].setLocation(20,80);

        for(int i = 0 ; i < setSizeJSpinners.length ; i++){
            setSizeJSpinners[i] = new JSpinner(new SpinnerNumberModel(480+i*160, 5, 5000, 10));// value, min, max, step
            setSizeJSpinners[i].setSize(80,20);
            panelBounds.add(setSizeJSpinners[i]);
        }
        setSizeJSpinners[0].setLocation(70,45);
        setSizeJSpinners[1].setLocation(70,75);

        for(int i = 0 ; i < setLocationJSpinners.length ; i++){
            setLocationJSpinners[i] = new JSpinner(new SpinnerNumberModel(500-i*250, 5, 5000, 10));// value, min, max, step
            setLocationJSpinners[i].setSize(80,20);
            //setLocationJSpinners[i].setEnabled(false);
            panelBounds.add(setLocationJSpinners[i]);
        }
        setLocationJSpinners[0].setLocation(70,145);
        setLocationJSpinners[1].setLocation(70,175);
    
        centrarFrame.setSelected(true);
        centrarFrame.setSize(115,20);
        centrarFrame.setLocation(20,115);
        panelBounds.add(this.centrarFrame);

    }//fin de metodo panelBounds

    void panelDecoracion(){
        panelDecoracion = new JPanel();

        String panelDecoracionTextos[] = {"color:"};
        JLabel panelDecoracionLabels[] = new JLabel[panelDecoracionTextos.length];
        
        panelDecoracion.setLayout(null);
        panelDecoracion.setBackground(Color.LIGHT_GRAY);
        panelDecoracion.setSize(430,50);
        panelDecoracion.setLocation((this.anchoFrame-430)/2,260);
        this.add(panelDecoracion);

        panelDecoracionLabels[0] = new JLabel(panelDecoracionTextos[0]);
        panelDecoracionLabels[0].setSize(600,25);
        panelDecoracionLabels[0].setLocation(20,10);
        panelDecoracion.add(panelDecoracionLabels[0]);
        for(int i = 0 ; i < this.color.length ; i++){
            this.color[i] = new JSpinner(new SpinnerNumberModel(238,0,255,1));
            this.color[i].setSize(50,25);
            this.color[i].setLocation(65+i*60,10);
            panelDecoracion.add(this.color[i]);
        }
        
    }//fin de metodo panelDecoracion

}//fin de clase CrearJFrames