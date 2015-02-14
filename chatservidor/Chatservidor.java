/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Claudia
 */
public class Chatservidor{
 

    /**
     * @param args the command line arguments
     */
            

public static void main(String[] args) {
        // TODO code application logic here
        s inicio = new s();
        inicio.sock();
          
    }
     
    
}
