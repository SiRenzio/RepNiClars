/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author Toto
 */
public class GameOver {
    GamePanel gamepanel;
    KeyHandler key;
    public int cursorlocY = 500, cursorlocX = 325;
    public boolean drawtext = true;
    
    public GameOver(GamePanel gamepanel, KeyHandler key){
        this.gamepanel = gamepanel;
        this.key = key;
    }
    
    public void update(){
        if (gamepanel.key.upPressed){
            cursorlocY = 500;
            cursorlocX = 325;
        }
        
        if (gamepanel.key.downPressed){
            cursorlocY = 600;
            cursorlocX = 325;
        }
        
        if (gamepanel.key.enterPressed){
            if (cursorlocY == 600 && cursorlocX == 325){
                System.exit(0);
            }
            
            if (cursorlocY == 500 && cursorlocX == 325){
                gamepanel.reset = true;
            }
        }
    }
    
    public void defaultvalues(){

    }
    
    public void draw(Graphics2D g2){
        Font font1 = new Font("arial", Font.BOLD, 100);
        Font font2 = new Font("arial", Font.BOLD, 35);
        
        g2.setColor(new Color(0,0,0,1));
        g2.fillRect(0, 0, gamepanel.screenWidth, gamepanel.screenHeight);
        
        g2.setFont(font1);
        g2.setColor(Color.red);
        g2.drawString("GAME OVER", 100, 350);
        
        g2.setFont(font2);
        g2.setColor(Color.yellow);
        g2.drawString("Retry", 355, 500);
        
        g2.setFont(font2);
        g2.setColor(Color.yellow);
        g2.drawString("Quit", 357, 600);
        

        g2.setFont(font2);
        g2.setColor(Color.yellow);
        g2.drawString(">", cursorlocX, cursorlocY);

        
    }
}
