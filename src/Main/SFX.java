/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author cjgas
 */
public class SFX {
    File sfx[] = new File[30];
    Clip clip;
    
    public SFX(){
        sfx[0] = new File("src\\Sounds\\Yoshi.wav");
        sfx[1] = new File("src\\Sounds\\Victory.wav");
    }
    
    public void setFile(int i){
        try{
            if(sfx[i].exists()){
                AudioInputStream ais = AudioSystem.getAudioInputStream(sfx[i]);
                this.clip = AudioSystem.getClip();
                this.clip.open(ais);
            }
            else{
                System.out.print("Error");
            }
        }catch(Exception e){
            
        }
    }
    
    public void play(){
        clip.start();
    }
    
    public void stop(){
        clip.stop();
    }
    
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
