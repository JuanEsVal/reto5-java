package view;

import controller.ControladorRequerimientosReto5;
import model.vo.LiderCiudad;
import model.vo.SumaProveedor;
import model.vo.ProyectoCiudad;

import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class VistaRequerimientosReto5 extends JFrame{

    public static ControladorRequerimientosReto5 controlador = new ControladorRequerimientosReto5();
    
    private JPanel panel;
    private JTextArea txtArea;  


    public VistaRequerimientosReto5() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 30, 800, 700);
        panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null);

        JLabel titulo = new JLabel("Misiontic2022 - UTP - Ciclo 2 - Programacion Basica - Reto 5");
        titulo.setBounds(15, 10, 500, 20);
        panel.add(titulo);

        JScrollPane scrPane = new JScrollPane();
        scrPane.setBounds(15,30,500,600);
        panel.add(scrPane);
                
        txtArea = new JTextArea();
        scrPane.setViewportView(txtArea);

        JButton btnConsulta1 = new JButton("Consulta 1");
        btnConsulta1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento1();                
            }
        });
        btnConsulta1.setBounds(600,100,125,30);
        panel.add(btnConsulta1);

        JButton btnConsulta3 = new JButton("Consulta 3");
        btnConsulta3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento3();
                
            }
        });
        btnConsulta3.setBounds(600,150,125,30);
        panel.add(btnConsulta3);

        JButton btnConsulta4 = new JButton("Consulta 4");
        btnConsulta4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento4();                
            }
        });
        btnConsulta4.setBounds(600,200,125,30);
        panel.add(btnConsulta4);

        JButton btnBorrar = new JButton("Borrar");
        btnBorrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                txtArea.setText("");                
            }
        });
        btnBorrar.setBounds(600,550,125,30);
        panel.add(btnBorrar);
    }

    public void requerimiento1() {
        try{
            ArrayList<ProyectoCiudad> rankingProyectosCiudad = controlador.consultarProyectoCiudad();
            String texto = "-----Proyecto Ciudad------- \n\nConstructora\t\tFecha_Inicio\t\tClasificación\n\n";

            for(ProyectoCiudad proyectoCiudad: rankingProyectosCiudad){
                texto += proyectoCiudad.getConstructora() + "\t" +  proyectoCiudad.getFechaInicio() + "\t\t" +  proyectoCiudad.getClasificacion() + "\n";
            }
            txtArea.setText(texto);            
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public void requerimiento3(){
        try{
            ArrayList<SumaProveedor> rankingSumaProveedor = controlador.consultarSumaProveedor();    
            String texto = "-----Suma Cantidades------- \n\nSuma Cantidades \n\n";                 
            int suma = 0;
            for(SumaProveedor sumaProveedor: rankingSumaProveedor){                 
                suma = suma + sumaProveedor.getCantidad();    
            }
            texto = texto + String.valueOf(suma);
            txtArea.setText(texto);
        }catch(SQLException e){
            System.out.println(e);
        }    
    }

    public void requerimiento4() {
        try{
            ArrayList<LiderCiudad> rankingLiderCiudad = controlador.consultarLiderCiudad();    
            String texto = "-----Líder Ciudad------- \n\nNombre Líder\n";                         
            for(LiderCiudad liderCiudad: rankingLiderCiudad){
                texto += liderCiudad.getNombreLider() + "\n";
            }
            txtArea.setText(texto);
            }catch(SQLException e){
                System.out.println(e);
            }    
    }
}