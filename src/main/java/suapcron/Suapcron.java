/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.suapcron;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import main.java.suapcron.gui.JanelaPrincipal;
import main.java.suapcron.suapdealer.SuapConnection;

/**
 *
 * @author marcocspc
 */
public class Suapcron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        JanelaPrincipal jp = new JanelaPrincipal();
        jp.setVisible(true);
    }
    
}
