/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import javax.swing.*;
/**
 *
 * @author cjgas
 */
public class App {
    public static void main(String[] args){
        JFrame window = new JFrame("2D Adventure Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        
        GamePanel gamepanel = new GamePanel();
        window.add(gamepanel);
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gamepanel.startGameThread();
    }
}
