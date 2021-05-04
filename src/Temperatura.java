/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author benja
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.InputMismatchException;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class Temperatura extends JFrame implements ActionListener {

    JPanel panel, cabecera, cuerpo;
    JLabel convertir;
    JComboBox origen, destino;
    JLabel resultado;
    JTextField grados;
    double result;

    public Temperatura() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(300, 200, 350, 150); //ancho,alto
        setVisible(true);
        setTitle("Calculadora de temperatura");
        //setLayout(null);
        getContentPane().setLayout(new BorderLayout());
         result=0;
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        //panel donde ira el botón convertir
        cabecera = new JPanel();   //donde ira la pantalla
        cabecera.setLayout(new GridLayout()); //una columna por componente en una sola fila
        convertir = new JLabel("Click aqui para convertir");

       
        cabecera.add(convertir);
        /// cabecera.setBackground(Color.WHITE);
        panel.add("North", cabecera);

        cuerpo = new JPanel();
        cuerpo.setLayout(new GridLayout(2, 2, 10, 10));
        /*2 filas 2 columnas 10 pixeles de 
                               distancia en horizontal y 10 px de distancia en vertical*/
        cuerpo.setBorder(new EmptyBorder(10, 10, 10, 10)); //borde vacio 10 px cada lado

        origen = new JComboBox();
        origen.addItem("Centigrados");
        origen.addItem("Fahrenheit");
        origen.addItem("Kelvin");
        origen.addActionListener(this);

        destino = new JComboBox();
        destino.addItem("Centigrados");
        destino.addItem("Fahrenheit");
        destino.addItem("Kelvin");
        destino.addActionListener(this);

        cuerpo.add(origen);   //origen.addActionListener(this);
        cuerpo.add(destino);  //destino.addActionListener(this);

        resultado = new JLabel("");

        resultado.setBorder(new LineBorder(Color.BLACK, 1));
        grados = new JTextField();
        cuerpo.add(grados);
        cuerpo.add(resultado);

        panel.add("Center", cuerpo);
        getContentPane().add(panel);
        getContentPane().setVisible(false);
        getContentPane().setVisible(true);
    }

    public void actionPerformed(ActionEvent mn) {
        
      
           if (mn.getSource() == origen || mn.getSource() == destino) {
        if(origen.getSelectedItem().toString()==destino.getSelectedItem().toString())
        {
             try{
           result = Double.parseDouble(grados.getText());
            resultado.setText(result+"");
             convertir.setText("Formula grado  * 1");}
             catch (Exception e){ JOptionPane.showMessageDialog(null,"Introduzca los grados en formato numerico");
                                          resultado.setText("");}
          }
           
              
        if((origen.getSelectedItem().toString()== "Fahrenheit")&&
          (destino.getSelectedItem().toString()== "Centigrados"))
           {
           
           if(!grados.getText().equals("")){
               try{
           result = Double.parseDouble(grados.getText());
           result= (result - 32.0)*(5.0/9.0) ;
           resultado.setText(""+result);
           convertir.setText("Formula: (°F − 32) × 5/9");
               } catch (Exception e){ JOptionPane.showMessageDialog(null,"Introduzca los grados en formato numerico");
                                          resultado.setText("");}
           }else{ JOptionPane.showMessageDialog(null,"Introduzca los grados Fahrenheit primero");
                                          resultado.setText("");}
           
           }
        
        if((origen.getSelectedItem().toString()== "Centigrados")&&
          (destino.getSelectedItem().toString()== "Fahrenheit"))
           {
             if(!grados.getText().equals("")){
               try{
           result = Double.parseDouble(grados.getText());
           result=(result *(9.0/5.0)) + 32.0;
      
           resultado.setText(""+result);
            convertir.setText("Formula: (°C × 9/5) + 32");
               } catch (Exception e){ JOptionPane.showMessageDialog(null,"Introduzca los grados en formato numerico");
                                          resultado.setText("");}
           }else{ JOptionPane.showMessageDialog(null,"Introduzca los grados centigrados primero");
                                          resultado.setText("");}
           }
        
        if((origen.getSelectedItem().toString()== "Centigrados")&&
          (destino.getSelectedItem().toString()== "Kelvin"))
           {
           if(!grados.getText().equals("")){
               try{
           result = Double.parseDouble(grados.getText());
           result=result +273.15;
           resultado.setText(""+result);
           convertir.setText("Formula: °C + 273.15");
               } catch (Exception e){ JOptionPane.showMessageDialog(null,"Introduzca los grados en formato numerico");
                                          resultado.setText("");}
           }else{ JOptionPane.showMessageDialog(null,"Introduzca los grados centigrados primero");
                                          resultado.setText("");}
           
           }
        
        if((origen.getSelectedItem().toString()== "Kelvin")&&
          (destino.getSelectedItem().toString()== "Centigrados"))
           {
               if(!grados.getText().equals("")){
               try{
           result = Double.parseDouble(grados.getText());
           result=result -273.15;
           resultado.setText(""+result);
            convertir.setText("Formula:  K − 273.15 ");
               } catch (Exception e){ JOptionPane.showMessageDialog(null,"Introduzca los grados en formato numerico");
                                          resultado.setText("");}
           }else{ JOptionPane.showMessageDialog(null,"Introduzca los grados Kelvin primero");
                                          resultado.setText("");}
          
           }
        
         if((origen.getSelectedItem().toString()== "Fahrenheit")&&
          (destino.getSelectedItem().toString()== "Kelvin"))
           {
             if(!grados.getText().equals("")){
               try{
           result = Double.parseDouble(grados.getText());
           result=((result -32.0) * (5.0/9.0)) + 273.15;
         
           resultado.setText(""+result);
            convertir.setText("Formula: (°F − 32) × 5/9 + 273.15 ");
               } catch (Exception e){ JOptionPane.showMessageDialog(null,"Introduzca los grados en formato numerico");
                                          resultado.setText("");}
           }else{ JOptionPane.showMessageDialog(null,"Introduzca los grados Fahrenheit primero");
                                          resultado.setText("");}
           
           }
         
          if((origen.getSelectedItem().toString()== "Kelvin")&&
          (destino.getSelectedItem().toString()== "Fahrenheit"))
           {
           if(!grados.getText().equals("")){
               try{
           result = Double.parseDouble(grados.getText());
           result=((result -273.15) * (9.0/5.0))+32.0;
       
           resultado.setText(""+result);
           convertir.setText("Formula: (K − 273.15) × 9/5 + 32 ");
               } catch (Exception e){ JOptionPane.showMessageDialog(null,"Introduzca los grados en formato numerico");
                                          resultado.setText("");}
           }else{ JOptionPane.showMessageDialog(null,"Introduzca los grados kelvi primero");
                                          resultado.setText("");}
           
           }
          
    }
    }
        
      

    

    public static void main(String[] args) {
        Temperatura t = new Temperatura();

    }
}
