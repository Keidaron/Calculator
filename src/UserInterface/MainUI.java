package UserInterface;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import Utils.NuvoUtils;

import java.awt.Toolkit;
import java.awt.Dimension;

/**
 * MainUI
 * Hier wird alles anzeigt was interessant ist
 */
public class MainUI extends JFrame{
    Dimension screenResolution;

    // Initialisiert das Hauptfenster der GUI
    public MainUI()
    {
        screenResolution = Toolkit.getDefaultToolkit().getScreenSize();

        this.setUndecorated(true);
        this.setSize(600, 400);

        this.setLocation(NuvoUtils.getMiddleOfScreen().x - (this.getWidth() / 2), NuvoUtils.getMiddleOfScreen().y - (this.getHeight() / 2));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}