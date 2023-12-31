/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author Toto
 */
public class StartScreen {
    GamePanel gamepanel;
    KeyHandler key;
    public BufferedImage SS;
    private int counter;
    private boolean drawText;
    
    public StartScreen(GamePanel gamepanel, KeyHandler key) {   
        this.gamepanel = gamepanel;
        this.key = key; 
        GetSSImage();
        counter = 0;
        drawText = true;
    }
    
    public void GetSSImage(){
        try{
            SS = ImageIO.read(getClass().getResourceAsStream("/image_StartScreen/StartGA.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    public void draw(Graphics2D g2){
        Font font = new Font("arial",Font.BOLD,50);
        g2.drawImage(SS,0, 0, gamepanel.screenWidth, gamepanel.screenHeight-80,null);
        g2.setFont(font);
        g2.setColor(Color.yellow);

        if(drawText == true){
            g2.drawString("Press Enter", 250, 575);
        }
        counter++;
        if (counter == 20) {
            counter = 0;
            drawText = !drawText;
        }
    }   
    
    public void update(){
        if (gamepanel.key.enterPressed){
            gamepanel.state = "game";
        }
        
    }   
}