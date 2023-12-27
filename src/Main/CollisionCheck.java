/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import entity.Entity;


/**
 *
 * @author cjgas
 */
public class CollisionCheck{
    GamePanel gp;
    
    public CollisionCheck(GamePanel gp){
        this.gp = gp;
    }
    
    public void tilechecker(Entity entity){
        int entityleftworldX = entity.worldX + entity.hitbox.x;
        int entityrightworldX = entity.worldX + entity.hitbox.x + entity.hitbox.width;
        int entitytopworldY = entity.worldY + entity.hitbox.y;
        int entitybottomworldY = entity.worldY + entity.hitbox.y + entity.hitbox.height;
        
        int entityleftCol = entityleftworldX / gp.tileSize;
        int entityrightCol = entityrightworldX / gp.tileSize;
        int entitytopRow = entitytopworldY / gp.tileSize;
        int entitybottomRow = entitybottomworldY / gp.tileSize;
        
        int tileNum1, tileNum2;
        
        switch(entity.direction){
            case "up":
                entitytopRow = (entitytopworldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityleftCol][entitytopRow];
                tileNum2 = gp.tileM.mapTileNum[entityrightCol][entitytopRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entitybottomRow = (entitybottomworldY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityleftCol][entitybottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityrightCol][entitybottomRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityleftCol = (entityleftworldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityleftCol][entitytopRow];
                tileNum2 = gp.tileM.mapTileNum[entityleftCol][entitybottomRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityrightCol = (entityrightworldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityrightCol][entitytopRow];
                tileNum2 = gp.tileM.mapTileNum[entityrightCol][entitybottomRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
        }
    }
}
