/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import Objects.ParentObject;
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
    public final int maxscreenRow = 16;
    public final int screenWidth = tileSize * maxscreenCol;
    public final int screenHeight = tileSize * maxscreenRow;
    
    public final int maxWorldCol = 75;
    public final int maxWorldRow = 75;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;
    
    int FPS = 60;
    
    KeyHandler key;
    Thread gameThread;
    public Player player;
    
    public CollisionCheck cc = new CollisionCheck(this);
    public ParentObject object[] = new ParentObject[15];
    public ObjectSetter os = new ObjectSetter(this);
    public SFX music = new SFX();
    public SFX fx = new SFX();
    public Time time = new Time(this);
    
    TileManager tileM = new TileManager(this);
    StartScreen ss = new StartScreen(this,key);
    
    public String state = "start";
    
    public GamePanel(){
        key = new KeyHandler(this);
        player = new Player(this,key);
        
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(key);
    }
            
    public void gameSetUP(){
        os.setobject();
        
        playBGM(0);
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
        if ("game".equals(state)){
            player.update();
            time.update();
        }
        else if ("start".equals(state)){
            ss.update();
        }
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        if ("game".equals(state)){
            tileM.draw(g2);
            for(int i = 0; i < object.length; i++){
                if(object[i] != null){
                    object[i].draw(g2, this);
                }
            }
            player.draw(g2);
            time.draw(g2);
        }
        else if ("start".equals(state)){
            ss.draw(g2);
        }
        g.dispose();
    }
    
    public void playBGM(int i){
        music.setFile(i);
        music.play();
        music.loop();
    }
    
    public void stopBGM(){
        music.stop();
    }
    
    public void playSfx(int i){
        fx.setFile(i);
        fx.play();
    }
}
