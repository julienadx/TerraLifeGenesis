import com.terra.graphics.GameWindow;

import javax.swing.*;

public class TestWindow {
    public static void main(String[] args) {
        GameWindow window = new GameWindow();
        boolean playing = true;
        String message;
        while (playing) {
            if (window.startGame()) {
                message = "you win! Congrats your planet is suitable for human beings!\nPlay again?";
            } else {
                message = "you loose :( Nobody's left on your planet...\nRestart a new game?";
            }
            int result = JOptionPane.showConfirmDialog(window,message, "Game Over",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.NO_OPTION){
                System.exit(0);
            } else {
                window = new GameWindow();
            }
        }
    }
}
