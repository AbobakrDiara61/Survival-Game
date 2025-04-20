
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import javax.sound.sampled.*;

public class GameSound {
    private static GameSound instance;
    private  HashSet<String> soundsSet;
    private boolean SoundDataState;
    private static int audioIntensisty;
    private Clip clip;
    private String status;
    private AudioInputStream audioInputStream;

    public GameSound() {
        soundsSet = new HashSet<String>();
        Scanner scanner = null; // initialize to null
        try {
            scanner = new Scanner(new File("GameDev/soundSystem.txt"));
            while(scanner.hasNextLine()) {
                soundsSet.add(scanner.nextLine());
            }
            SoundDataState = true;
        }
        catch(FileNotFoundException e) {
            SoundDataState = false;
            e.printStackTrace();
        }
        catch(Exception e) {
            SoundDataState = false;
        }
        finally {
            if(scanner != null) {
                scanner.close();
            }
        }
    }
    public static GameSound getInstance() {
        if(instance == null) {
            instance = new GameSound();
        }
        return instance;
    }
    public void loadFile(String fileName) throws UnsupportedAudioFileException, 
        IOException, LineUnavailableException{
        if(!soundsSet.contains(fileName)) {
            return;
        }
        audioInputStream = AudioSystem.getAudioInputStream(new File(fileName).getAbsoluteFile()); 
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
    } 
    public void play() {
        if (clip == null) {
            System.out.println("Clip is not initialized.");
            return;
        }
        clip.flush();
        clip.start();
        try {
            Thread.sleep(clip.getMicrosecondLength() / 1000); // Sleep for the length of the audio
            status = "playing";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
