package UserInterface;

import javax.swing.JDialog;
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

    // Popup zum Wählen von Aktionen des Users
    // Registrieren, Mieten (Anmelden)
    JDialog decisionPopUp = new JDialog();

    public MainUI(String title)
    {
        this.setTitle(title);
        this.setSize(600, 400);

        screenResolution = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenResolution.width / 2) - (this.getWidth() / 2), (screenResolution.height / 2) - (this.getHeight() / 2));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

        initPopUp();
    }

    private void initPopUp()
    {
        decisionPopUp.setSize(150, 200);
        decisionPopUp.setLocation((screenResolution.width / 2) - (decisionPopUp.getWidth() / 2), (screenResolution.height / 2) - (decisionPopUp.getHeight() / 2));
        

        decisionPopUp.setUndecorated(false);
        decisionPopUp.setModal(true);
        decisionPopUp.setVisible(true);
    }
}