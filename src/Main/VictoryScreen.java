/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author cjgas
 */
public class VictoryScreen {
    GamePanel gamepanel;
    Font font;
    
    public VictoryScreen(GamePanel gamepanel){
        this.gamepanel = gamepanel;
        font = new Font("arial", Font.BOLD, 100);
    }
    
    public void draw(Graphics2D g2){
        String text;
        int textlength;
        int x;
        int y;
        
        text = "Victory!";
        textlength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        x = (gamepanel.screenWidth / 2) - textlength;
        y = gamepanel.screenHeight / 2;
        
        g2.setFont(font);
        g2.setColor(Color.yellow);
        g2.drawString(text, x, y);
    }
}
