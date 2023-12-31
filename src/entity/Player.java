/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import Main.GamePanel;
import Main.KeyHandler;
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
        
        hitbox = new Rectangle();
        hitbox.x = 8;
        hitbox.y = 16;
        hitboxDefaultX = hitbox.x;
        hitboxDefaultY = hitbox.y;
        hitbox.width = 32;
        hitbox.height = 32;
        
        setDefaultValue();
        getPlayerImage();
    }
    public void getPlayerImage(){
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/image_player/Up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/image_player/Up2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/image_player/Up3.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/image_player/Down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/image_player/Down2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/image_player/Down3.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/image_player/Left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/image_player/Left2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/image_player/Left3.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/image_player/Right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/image_player/r2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/image_player/Right3.png"));
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void setDefaultValue(){
        worldX = gp.tileSize * 9;
        worldY = gp.tileSize * 9;
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
                    spriteNum = 3;
                }
                else if(spriteNum == 3){
                    spriteNum = 4;
                }
                else if(spriteNum == 4){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        
        
            if(key.upPressed == true){
                direction = "up";            
            }
            else if(key.downPressed == true){
                direction = "down";            
            }
            else if(key.leftPressed == true){
                direction = "left";            
            }
            else if(key.rightPressed == true){
                direction = "right";         
            }

            collisionOn = false;
            gp.cc.tilechecker(this);
            
            gp.cc.checkObject(this, true);

            if(collisionOn == false){
                switch(direction){
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }
        }
    }
    public void draw(Graphics2D g2){
        
        BufferedImage image = null;
        
        switch(direction){
            case "up":
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up2;
                }
                if(spriteNum == 3){
                    image = up3;
                }
                if(spriteNum == 4){
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
                if(spriteNum == 3){
                    image = down3;
                }
                if(spriteNum == 4){
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
                if(spriteNum == 3){
                    image = left3;
                }
                if(spriteNum == 4){
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
                if(spriteNum == 3){
                    image = right3;
                }
                if(spriteNum == 4){
                    image = right2;
                }
                break;
        }
        
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}