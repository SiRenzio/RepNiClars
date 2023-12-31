/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author cjgas
 */
public class KeyHandler implements KeyListener{
    GamePanel gamepanel;
    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;
    
    public KeyHandler(GamePanel gamepanel){
        this.gamepanel = gamepanel;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        if("game".equals(gamepanel.state)){
            if(code == KeyEvent.VK_W){
                upPressed = true;
            }
            if(code == KeyEvent.VK_S){
                downPressed = true;
            }
            if(code == KeyEvent.VK_A){
                leftPressed = true;
            }
            if(code == KeyEvent.VK_D){
                rightPressed = true;
            }
        }
        if("start".equals(gamepanel.state)){
            if (code == KeyEvent.VK_ENTER){
                enterPressed = true;
            }
        }
        
        if("over".equals(gamepanel.state)){
            if(code == KeyEvent.VK_W){
                upPressed = true;
            }
            
            if(code == KeyEvent.VK_S){
                downPressed = true;
            }
            
            if (code == KeyEvent.VK_ENTER){
                enterPressed = true;
            }
            
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
        if (code == KeyEvent.VK_ENTER){
            enterPressed = false;
        }
    }
    
}
