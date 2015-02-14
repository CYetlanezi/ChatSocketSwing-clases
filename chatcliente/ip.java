/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Claudia
 */
public class ip extends JFrame{
    JFrame ventana;JTextField ip; JLabel label1; JButton mandar;
    
    public ip(){
    
        ventana = new JFrame();
        ip = new JTextField();
        label1 = new JLabel("Escriba su IP");
        mandar = new JButton();
        
        ventana.setBounds(100, 100, 200, 300);
        ventana.setTitle("IP Cliente");
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventana.setVisible(true);
        
        label1.setBounds(55, 40, 120, 25);
        ip.setBounds(40, 90, 120, 25);
        mandar.setBounds(55, 190, 90, 25);
        mandar.setText("Mandar");
        mandar.addActionListener(
         new ActionListener(){
                public void actionPerformed(ActionEvent event){
                 c charlie;
                  charlie = new c("127.0.0.1");
                  charlie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                charlie.sock();
                
                }
             }
          );
        
         ventana.getContentPane().add(label1);
          ventana.getContentPane().add(ip);
           ventana.getContentPane().add(mandar);
           
           ventana.setLayout(null);
        
    }

    
}
