/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import javax.imageio.ImageIO;

/**
 *
 * @author cjgas
 */
public class PlayerLife extends ParentObject{
    public PlayerLife(){
        name = "Life";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/image_objects/Life1.png"));
        }catch(Exception e){
            e.printStackTrace();
        }
        collision = true;
    }
}