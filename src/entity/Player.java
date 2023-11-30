/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import classes.GamePanel;
import classes.KeyHandler;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;
/**
 *
 * @author cjgas
 */
public class Player extends Entity{
    GamePanel gp;
    KeyHandler key;
    
    public final int screenX;
    public final int screenY;
    
    public Player(GamePanel gp, KeyHandler key){
        this.gp = gp;
        this.key = key;
        
        screenX = gp.screenWidth/2 - gp.tileSize/2;
        screenY = gp.screenHeight/2 - gp.tileSize/2;
        
        setDefaultValue();
        getPlayerImage();
    }
    public void getPlayerImage(){
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/image_player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/image_player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/image_player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/image_player/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/image_player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/image_player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/image_player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/image_player/boy_right_2.png"));
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void setDefaultValue(){
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 22;
        speed = 4;
        direction = "up";
    }
    
    public void update(){
        if(key.upPressed == true || key.downPressed == true || key.leftPressed == true || key.rightPressed == true){
            spriteCounter++;
            if(spriteCounter > 8){
            if(spriteNum == 1){
                spriteNum = 2;
            }
            else if(spriteNum == 2){
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
        }
        
        if(key.upPressed == true){
            direction = "up";
            worldY -= speed;
        }
        else if(key.downPressed == true){
            direction = "down";
            worldY += speed;
        }
        else if(key.leftPressed == true){
            direction = "left";
            worldX -= speed;
        }
        else if(key.rightPressed == true){
            direction = "right";
            worldX += speed;
        }
        
        
    }
    public void draw(Graphics2D g2){
        //g2.setColor(Color.white);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        
        BufferedImage image = null;
        
        switch(direction){
            case "up":
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2){
                    image = down2;
                }
                break;
            case "left":
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }
                break;
        }
        
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
