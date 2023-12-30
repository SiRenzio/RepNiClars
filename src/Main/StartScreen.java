/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Toto
 */
public class StartScreen {
    GamePanel gamepanel;
    KeyHandler key;

    
    public StartScreen(GamePanel gamepanel, KeyHandler key) {   
        this.gamepanel = gamepanel;
        this.key = key; 
    }
    
    public void draw(Graphics2D g2){
        g2.setColor(Color.red);
        g2.fillRect(0, 0, 300, 300);
    }   
    
    public void update(){
        if (gamepanel.key.enterPressed){
            gamepanel.state = "game";
        }
        
    }   
}