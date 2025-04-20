import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.ImageIcon;

public class WorldMap {
    private static WorldMap instance;
    Image waterImg;
    Image grassImg; 
    Image greTreeImg;
    Image yelTreeImg;
    Image bushImg;
    Image stoneImg;


    public static HashSet<String> tiles;
    ArrayList<Block> blocksArray;
    WorldMap() {
        blocksArray = new ArrayList<Block>();
        getImages();
        tiles = new HashSet<String>();
        tiles.add("w");
        loadMap();
    }
    private void getImages() {
        waterImg = new ImageIcon(getClass().getResource("/GamePhotos/Tiles/tile_0037.png")).getImage();
        grassImg = new ImageIcon(getClass().getResource("/GamePhotos/Tiles/tile_0001.png")).getImage();
        greTreeImg = new ImageIcon(getClass().getResource("/GamePhotos/Tiles/tile_0028.png")).getImage();
        yelTreeImg = new ImageIcon(getClass().getResource("/GamePhotos/Tiles/tile_0027.png")).getImage();
        stoneImg = new ImageIcon(getClass().getResource("/GamePhotos/Tiles/tile_0043.png")).getImage();
        // stoneImg = new ImageIcon(getClass().getResource("/GamePhotos/Tiles/tile_0005.png")).getImage();
        bushImg = new ImageIcon(getClass().getResource("/GamePhotos/Tiles/tile_0005.png")).getImage();
    }
    public static WorldMap getInstance() {
        if(instance == null) {
            instance = new WorldMap();
        }
        return instance;
    }
    public void loadMap() {
        blocksArray.add(new Block(waterImg));
        blocksArray.add(new Block(grassImg));
        blocksArray.add(new Block(yelTreeImg));
        blocksArray.add(new Block(greTreeImg));
    }
    public void mapDraw(Graphics2D g2){
        for(int r=0 ; r<GamePanel.worldscreenRowCount ; r++) {
            for(int c=0 ; c<GamePanel.worldscreenColCount ; c++) {
                String row = WorldMap.map[r];     
                char tileMapChar = row.charAt(c);
                int worldX = c * GamePanel.tileSize; // x world
                int worldY = r * GamePanel.tileSize; // y world
                int screenX = worldX - GamePanel.player.x + GamePanel.player.screenX;
                int screenY = worldY - GamePanel.player.y + GamePanel.player.screenY;

                /* if(worldX + GamePanel.tileSize > GamePanel.player.x - GamePanel.player.screenX &&
                    worldX - GamePanel.tileSize < GamePanel.player.x + GamePanel.player.screenX &&
                    worldY + GamePanel.tileSize > GamePanel.player.y - GamePanel.player.screenY &&
                    worldY - GamePanel.tileSize < GamePanel.player.y + GamePanel.player.screenY) {
                    
                } */
                if(tileMapChar == 'w') {
                    g2.drawImage(blocksArray.get(0).image,screenX,screenY,(GamePanel.tileSize + 5),(GamePanel.tileSize + 5),null);
                }
                else if(tileMapChar == 'g') {
                    // grass.add(new Block(grassImg,screenX,screenY,GamePanel.tileSize,GamePanel.tileSize));
                    g2.drawImage(blocksArray.get(1).image,screenX,screenY,(GamePanel.tileSize ),(GamePanel.tileSize ),null);
                } else if(tileMapChar == 'y') {
                    g2.drawImage(blocksArray.get(1).image,screenX,screenY,(GamePanel.tileSize ),(GamePanel.tileSize ),null);
                    g2.drawImage(blocksArray.get(2).image,screenX,screenY,(GamePanel.tileSize ),(GamePanel.tileSize ),null);
                } else if(tileMapChar == 'r') {
                    g2.drawImage(blocksArray.get(1).image,screenX,screenY,(GamePanel.tileSize ),(GamePanel.tileSize ),null);
                    g2.drawImage(blocksArray.get(3).image,screenX,screenY,(GamePanel.tileSize ),(GamePanel.tileSize ),null);
                }
            }
        }
    }
    class Block {
        Image image;
        Block(Image image) {
            this.image = image;
        }
    }
    public final static String[] map = {
        "wwww".repeat(32),
        "wwww".repeat(32),
        // "ww"+"ggmggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg"+"ww",
        "wr"+"gyrg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "ww"+"gggg".repeat(14)+"ww",
        "wwww".repeat(32),
        "wwww".repeat(32)
    };
}
