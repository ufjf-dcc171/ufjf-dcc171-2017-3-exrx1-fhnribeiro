/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exrrelampago;

import javax.swing.JFrame;

/**
 *
 * @author 11944413600
 */
public class ExrRelampago {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JanelaRelampago janela = new JanelaRelampago();
        janela.setSize(500,300);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }
    
}
