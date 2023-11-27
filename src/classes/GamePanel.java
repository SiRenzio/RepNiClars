/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import Tile.TileManager;
import java.awt.*;
import javax.swing.*;
import java.lang.*;
import entity.Player;
/**
 *
 * @author cjgas
 */
public class GamePanel extends JPanel implements Runnable{
    final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public final int maxscreenCol = 16;
    public final int maxscreenRow = 12;
    public final int screenWidth = tileSize * maxscreenCol;
    public final int screenHeight = tileSize * maxscreenRow;
    
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;
    
    //FPS
    int FPS = 30;
    
    KeyHandler key = new KeyHandler();
    
    Thread gameThread;
    public Player player = new Player(this, key);
    
    TileManager tileM = new TileManager(this);
    
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;
    
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(key);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    @Override
    public void run() {
        
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        
        while(gameThread != null){
            
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            
            if(delta >= 1){
            update();
            repaint();
            delta--;
            }
        }
    }
    
    public void update(){
        player.update();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        tileM.draw(g2);
        
        player.draw(g2);
        g.dispose();
    }
    
}
