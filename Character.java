import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Character {
    public int x,y,speed;
    // public int worldX , worldY;
    
    public int height;
    public int width;
    
    public BufferedImage up1,up2,down1,down2,right1,right2,left1,left2;
    public String direction;

    public int spriteCounter=0;
    public int spriteNum=1;
    public Rectangle solidArea;
    public boolean collisionOn;
}
