package UserInterface;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import java.awt.Toolkit;
import java.awt.Dimension;

/**
 * MainUI
 * Hier wird alles anzeigt was interessant ist
 */
public class MainUI extends JFrame{
    Dimension screenResolution;

    // Initialisiert das Hauptfenster der GUI
    public MainUI(String title)
    {
        screenResolution = Toolkit.getDefaultToolkit().getScreenSize();

        this.setTitle(title);
        this.setSize(600, 400);

        this.setLocation((screenResolution.width / 2) - (this.getWidth() / 2), (screenResolution.height / 2) - (this.getHeight() / 2));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

        new PopUp(screenResolution);
    }
}