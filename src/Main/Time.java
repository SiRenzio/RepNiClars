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
public class Time {
    GamePanel gamepanel;
    public int TimeRemaining;
    public String time;
    private int counter;

    public Time(GamePanel gamepanel){
        this.gamepanel = gamepanel;
        this.TimeRemaining = 60 * 10;
        this.time = timeformatting(TimeRemaining);
        this.counter = 0;
    }
    public void update(){
        counter++;
        if (counter == 60){
            TimeRemaining--;   
            time = timeformatting(TimeRemaining);
            counter = 0;
        }
        
        if (TimeRemaining == 0){
            gamepanel.state = "over";
        }
        
    }
    
    public String timeformatting(int time){
        int minutes = time / 60;
        int seconds = time % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
    
    public void draw(Graphics2D g2){
        Font font = new Font("arial", Font.BOLD, 50);
        
        g2.fillRect(10, 10, 130, 50);
        g2.setColor(Color.black);
        
        g2.setFont(font);
        g2.setColor(Color.white);
        g2.drawString(time, 10, 50);
    }
    
    public void resetted(){
        TimeRemaining = 60 * 10;
    }
}

