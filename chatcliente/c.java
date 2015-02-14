/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Claudia
 */
    public class c extends JFrame{
        
        JFrame ventana;
          JTextArea area;
          JLabel label1; 
          JTextField mens;
          JLabel r ;
         ObjectOutputStream output;
        ObjectInputStream input;
         String mensaje = "";
         String IP;
         Socket connection;
          
          public c(String host){
                Interface();
                IP= host;
          }  
          
          
          private void Interface() 
            {
                  ventana = new JFrame("Chat Cliente");
                  area = new JTextArea(); 
                  label1 = new JLabel("Cliente");
                  mens = new JTextField();
                   r = new JLabel("");

                    r.setBounds(100, 100, 10, 10);
                    label1.setBounds(50, 350, 100, 50);
                    mens.setBounds(150, 350, 300, 30);
                    area.setBounds(50, 50, 450, 280);
                    
                    area.setEditable(false);
                    mens.addActionListener(
         new ActionListener(){
                public void actionPerformed(ActionEvent event){
                   Mandarmens(event.getActionCommand());
                   mens.setText("");
                }
             }
          );
                    
                     ventana.getContentPane().add(label1);
                     ventana.getContentPane().add(mens);
                     ventana.getContentPane().add(area);
                     ventana.getContentPane().add(r);
                     ventana.pack();
                     ventana.setBounds(100, 100, 600, 600);
                     ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                     ventana.setResizable(false);
                     ventana.setLocationRelativeTo(null);
                     ventana.setVisible(true);
    
        }

   public void sock(){
       try{
         area.append("Estableciendo coneccion.. \n");
            connection = new Socket(InetAddress.getByName(IP), 4800);
        area.append("Connectado  con: " + connection.getInetAddress().getHostName() );
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(connection.getInputStream());
        area.append("\n n.n! \n");
         mens.setEditable(true);
      do{
         try{
            mensaje = (String) input.readObject();
            area.append("\n" + mensaje);
         }
         catch(ClassNotFoundException classNotfoundException){
           area.append("\n algo va mal");
         }
      }
      while(!mensaje.equals("Servidor- adios"));
      }catch(EOFException eofException){
         area.append("\n El cliente termino la coneccion");
      }catch(IOException ioException){
         ioException.printStackTrace();
      }finally{
         area.append("\n Cerrando coneccion...");
      mens.setEditable(false);
      try{
         output.close();
         input.close();
         connection.close();
      }catch(IOException ioException){
         ioException.printStackTrace();
      }
   }
   }
     private void Mandarmens(String mensaje){
      try{
         output.writeObject("Cliente- " + mensaje);
         output.flush();
         area.append("\nCliente-" + mensaje);
      }catch(IOException ioException){
         area.append("\n error!");
      }
   }
    }

