/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Objects.Statue;

/**
 *
 * @author cjgas
 */
public class ObjectSetter {
    GamePanel gp;
    public ObjectSetter(GamePanel gp){
        this.gp = gp;
    }
    
    public void setobject(){
        gp.object[0] = new Statue();
        gp.object[0].worldX = 11 * gp.tileSize;
        gp.object[0].worldY = 64 * gp.tileSize;
    }
}