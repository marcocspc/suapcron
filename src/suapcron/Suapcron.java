/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suapcron;

import javax.swing.UIManager;
import suapcron.domain.Hora;
import suapcron.gui.JanelaPrincipal;

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
