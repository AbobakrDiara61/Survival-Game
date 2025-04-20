import javax.swing.JFrame;
public class TestingGame {
    public static void main(String[] args) {
        JFrame mainWindow = new JFrame("Survivor's Awakening");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setResizable(false);
        GamePanel gamePanel = new GamePanel();
        mainWindow.add(gamePanel);
        mainWindow.pack();
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);

        gamePanel.StartGameThread();
    }
}
