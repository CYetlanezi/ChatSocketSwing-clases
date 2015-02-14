/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Claudia
 */
    public class s extends JFrame{
          public s(){
                Interface();
          }  
          
          JFrame ventana;
          JTextArea area;
          JLabel label1;
          JTextField mens;
          JLabel r ;
          ObjectOutputStream output;
          ObjectInputStream input;
          ServerSocket server;
           Socket connection;
          
           private void Interface() 
            {
                  ventana = new JFrame("Chat Servidor");
                  area = new JTextArea(); 
                  label1 = new JLabel("Servidor");
                  mens = new JTextField();
                   r = new JLabel("");

                    r.setBounds(100, 100, 10, 10);
                    label1.setBounds(50, 350, 100, 50);
                    mens.setBounds(150, 350, 300, 30);
                    area.setBounds(50, 50, 450, 280);
                    
                    mens.setEditable(false);
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
                     server = new ServerSocket(4800, 100);
                while(true){
                   try{
                            area.append(" Esperando Cliente... \n");
                            connection = server.accept();
                            area.append(" Conectado con " + connection.getInetAddress().getHostName());
                            output = new ObjectOutputStream(connection.getOutputStream());
                            output.flush();
                            
                            input = new ObjectInputStream(connection.getInputStream());
                            area.append("\n Esperando \n");
                            
                            String message = " Coneccion establecida ";
                             output.writeObject("Servidor- " + message);
                             output.flush();
                             area.append("\nServido - " + message);
                            mens.setEditable(true);
                            
                            do{
                               try{
                                  message = (String) input.readObject();
                                  area.append("\n" + message);
                               }
                               catch(ClassNotFoundException classNotFoundException){
                                  area.append("\n error linea 96");
                               }
                            }while(!message.equals("Cliente- adios"));
                    }
                   catch(EOFException eofException){
                             area.append("\n fin de conneccion");
                    }
                   finally{
                       area.append("\n Cerrando coneccion... \n");
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
                }
                catch(IOException ioException){
                    ioException.printStackTrace();
                    }
          }
          
     public void Mandarmens(String message){
      try{
         output.writeObject("Servidor- " + message);
         output.flush();
         area.append("\nServidor- " + message);
      }catch(IOException ioException){
         area.append("\n ERROR");
      }
   }
    
    
    }