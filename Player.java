import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Player extends Character {
    KeyHandler kh;
    public final int screenX = GamePanel.windWidth / 2 - GamePanel.tileSize/2;
    public final int screenY = GamePanel.windHeight / 2 - GamePanel.tileSize/2; 

    public Player(KeyHandler keyHandler) {
        this.kh = keyHandler;
        setDefault(11,11);
        width = GamePanel.tileSize;
        height = GamePanel.tileSize;
        solidArea = new Rectangle(8, 16, 32, 32);
        getPlayerImg();
    }

    public void setDefault(int x,int y){
        this.x = x * GamePanel.tileSize;
        this.y = y * GamePanel.tileSize;
        speed=4;
        direction="down";
    }

    public void getPlayerImg(){
        try {
            up1= ImageIO.read(new File("res/Player/up1.png"));
            up2= ImageIO.read(new File("res/Player/up2.png"));
            down1= ImageIO.read(new File("res/Player/down1.png"));
            down2= ImageIO.read(new File("res/Player/down2.png"));
            right1= ImageIO.read(new File("res/Player/right1.png"));
            right2= ImageIO.read(new File("res/Player/right2.png"));
            left1= ImageIO.read(new File("res/Player/left1.png"));
            left2= ImageIO.read(new File("res/Player/left2.png"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(kh.up==true||kh.down==true||kh.right==true||kh.left==true)
        {  
            if(kh.up==true){ direction="up";}
            if(kh.left==true){ direction="left";}
            if(kh.right==true){ direction="right";}
            if(kh.down==true){ direction="down";}
            collisionOn = false;
            GamePanel.cosDec.detect(this);
            if(!collisionOn) {
                if(direction == "up"){ y-=speed;}
                if(direction == "left"){ x-=speed;}
                if(direction == "right"){ x+=speed;}
                if(direction == "down"){ y+=speed;}
            }
            spriteCounter++;
            if(spriteCounter>10){ if(spriteNum==1) spriteNum=2;
            else if(spriteNum==2){ spriteNum=1; }
            spriteCounter=0;}
        }
    }

    public void draw(Graphics2D g2){
        BufferedImage image =null;
        switch(direction){
            case "up": if(spriteNum==1) {image=up1;} if(spriteNum==2) {image=up2;} break;
            case "left": if(spriteNum==1) {image=left1;} if(spriteNum==2) {image=left2;} break;
            case "right": if(spriteNum==1) {image=right1;} if(spriteNum==2) {image=right2;} break;
            case "down": if(spriteNum==1) {image=down1;} if(spriteNum==2) {image=down2;} break;
        }

        g2.drawImage(image,screenX,screenY,width,height,null);
    }
}
