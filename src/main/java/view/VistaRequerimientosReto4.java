package view;

import controller.ControladorRequerimientosReto4;
import model.vo.LiderCiudad;
import model.vo.SumaProveedor;
import model.vo.ProyectoCiudad;

import java.sql.SQLException;
import java.util.ArrayList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class VistaRequerimientosReto4 extends JFrame{

    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();
    
    public JPanel panelContenedor = new JPanel();
    public JTextArea txtRespuesta = new JTextArea();

    public JLabel logoMLabel; 
    public JLabel encabezadoLabel; 
    public JLabel pieLabel; 
    public JLabel logoULabel;
    public JScrollPane campoPanel;
    public JButton requerimiento1;
    public JButton requerimiento3;
    public JButton requerimiento4;

    public VistaRequerimientosReto4 () {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 700);
        Dimension pantallaTamano = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((pantallaTamano.width/2)-(this.getWidth()/2), (pantallaTamano.height/2)-(this.getHeight()/2));
        panelContenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelContenedor.setBackground(new Color(29, 36, 74));
        panelContenedor.setLayout(null);

        logoMLabel = new JLabel();
        logoMLabel.setBounds(280, 0, 300, 160);
        Icon logoM = new ImageIcon("logo-mision.png");
        logoMLabel.setIcon(logoM);
        panelContenedor.add(logoMLabel);
        
        encabezadoLabel = new JLabel("Reto 5");
        encabezadoLabel.setBounds(365, 165, 800, 20);
        encabezadoLabel.setFont(new Font("Uniform Medium", Font.BOLD, 20));
        encabezadoLabel.setForeground(Color.WHITE);
        panelContenedor.add(encabezadoLabel);

        campoPanel = new JScrollPane();
        campoPanel.setBounds(10, 240, 780, 350);
        panelContenedor.add(campoPanel);

        campoPanel.setViewportView(txtRespuesta);

        requerimiento1 = new JButton ("Consulta Uno");
        requerimiento1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento1();
            }
        });
        requerimiento1.setBounds(130, 200, 150, 20);
        requerimiento1.setBackground(new Color(210, 230, 236));
        requerimiento1.setBorder(null);
        panelContenedor.add(requerimiento1);

        requerimiento3 = new JButton ("Consulta Dos");
        requerimiento3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento3();
            }
        });
        requerimiento3.setBounds(330, 200, 150, 20);
        requerimiento3.setBackground(new Color(210, 230, 236));
        requerimiento3.setBorder(null);
        panelContenedor.add(requerimiento3);

        requerimiento4 = new JButton ("Consulta Tres");
        requerimiento4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento4();
            }
        });
        requerimiento4.setBounds(530, 200, 150, 20);
        requerimiento4.setBackground(new Color(210, 230, 236));
        requerimiento4.setBorder(null);
        panelContenedor.add(requerimiento4);

        pieLabel = new JLabel("Yina Marcela Wilches Rodriguez");
        pieLabel.setBounds(270, 610, 800, 20);
        pieLabel.setFont(new Font("Uniform Medium", Font.BOLD, 14));
        pieLabel.setForeground(Color.WHITE);
        panelContenedor.add(pieLabel);

        logoULabel = new JLabel();
        logoULabel.setBounds(635, 560, 170, 140);
        Icon logoU = new ImageIcon("logo-u.png");
        logoULabel.setIcon(logoU);
        panelContenedor.add(logoULabel);

        add(panelContenedor);

    }

    public void requerimiento1() {  

        try {

            ArrayList<ProyectoCiudad> rankingProyectoCiudad = controlador.consultarProyectoCiudad();

            // Encabezado del resultado
            String resultado1 = "\n-----Proyecto Ciudad-------\n";
            resultado1 += "\nConstructora";
            resultado1 += "\t\t";
            resultado1 += "Fecha_Inicio";
            resultado1 += "\t";
            resultado1 += "Clasificación\n";

            // Cada VO cargado, mostrarlo en la vista
            for (ProyectoCiudad proyectoCiudad : rankingProyectoCiudad) {
                resultado1 += proyectoCiudad.getConstructora();
                resultado1 += "\t";
                resultado1 += proyectoCiudad.getFechaInicio();
                resultado1 += "\t";
                resultado1 += proyectoCiudad.getClasificacion();
                resultado1 += "\t\n";
            }
            txtRespuesta.setText(resultado1);

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }

    }

    public void requerimiento3() {

        try {

            ArrayList<SumaProveedor> rankingSumaProveedor = controlador.consultarSumaProveedor();

            // Encabezado del resultado
            String resultado2 = "\n-----Suma Cantidades-------\n";
            resultado2 += "\nSuma Cantidades\n";

            // Cada VO cargado, mostrarlo en la vista
            for (SumaProveedor suma : rankingSumaProveedor) {
                resultado2 += suma.getCantidad();
                resultado2 += "\n";
            }
            txtRespuesta.setText(resultado2);

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }

    }

    public void requerimiento4() {

        try {

            ArrayList<LiderCiudad> rankingLiderCiudad = controlador.consultarLiderCiudad();

            // Encabezado del resultado
            System.out.println("");

            // Encabezado del resultado
            String resultado3 = "\n-----Líder Ciudad-------\n";
            resultado3 += "\nNombre Líder\n";

            // Cada VO cargado, mostrarlo en la vista
            for (LiderCiudad lider : rankingLiderCiudad) {
                resultado3 += lider.getNombreLider();
                resultado3 += "\n";
            }
            txtRespuesta.setText(resultado3);

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }

    }

}