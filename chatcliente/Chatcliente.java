/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Claudia
 */
public class Chatcliente {
 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        c cliente;
      cliente = new c("127.0.0.1");
      cliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      cliente.sock();
    
    }
    
}
