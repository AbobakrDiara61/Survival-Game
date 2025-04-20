public class CollisionDetector {
    private static CollisionDetector instance;
    public CollisionDetector() {
        
    }
    public static CollisionDetector getInstance() {
        if(instance == null) {
            instance = new CollisionDetector();
        }
        return instance;
    }
    public void detect(Character character) {
        int charWorldX = character.x;
        int charWorldY = character.y;
        String direction = character.direction;
        int leftSideX = charWorldX + character.solidArea.x ;
        int rightSideX = charWorldX + character.solidArea.x + character.solidArea.width;
        int topY = charWorldY + character.solidArea.y;
        int bottomY = charWorldY + character.solidArea.y + character.solidArea.height;

        int leftRectCol = leftSideX / GamePanel.tileSize;
        int rightRectCol = rightSideX / GamePanel.tileSize;
        int toptRectRow = topY / GamePanel.tileSize;
        int bottRectRow = bottomY / GamePanel.tileSize;
        char tileColOne;
        char tileColTwo;
        switch (direction) {
            case "up":
                toptRectRow = (topY - character.speed)/GamePanel.tileSize;
                tileColOne = WorldMap.map[toptRectRow].charAt(leftRectCol);
                tileColTwo = WorldMap.map[toptRectRow].charAt(rightRectCol);
                if(tileColOne == 'w' || tileColTwo == 'w') {
                    character.collisionOn = true;
                }
                break;
                case "down":
                bottRectRow = (bottomY + character.speed) / GamePanel.tileSize;
                tileColOne = WorldMap.map[bottRectRow].charAt(leftRectCol);
                tileColTwo = WorldMap.map[bottRectRow].charAt(rightRectCol);
                if(tileColOne == 'w' || tileColTwo == 'w') {
                    character.collisionOn = true;   
                }
                case "right":
                rightRectCol = (rightSideX + character.speed) / GamePanel.tileSize;  
                tileColOne = WorldMap.map[toptRectRow].charAt(rightRectCol);
                tileColTwo = WorldMap.map[bottRectRow].charAt(rightRectCol);
                if(tileColOne == 'w' || tileColTwo == 'w') {
                    character.collisionOn = true;                    
                }                
                break;
                case "left":
                leftRectCol = (leftSideX - character.speed) / GamePanel.tileSize;
                tileColOne = WorldMap.map[toptRectRow].charAt(leftRectCol);
                tileColTwo = WorldMap.map[bottRectRow].charAt(leftRectCol);
                if(tileColOne == 'w' || tileColTwo == 'w') {
                    character.collisionOn = true;
                }
                break;
        
            default:
                break;
        }
    }
    
}
