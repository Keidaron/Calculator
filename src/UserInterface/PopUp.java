package UserInterface;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;

public class PopUp extends JDialog
{
        // Pop-UP Variables & Objects
        private JPanel popPanel = new JPanel();

        Dimension buttonSize = new Dimension(100, 30);
        private JButton rentButton = new JButton("Mieten");
        private JButton registerButton = new JButton("Registrieren");


    public PopUp(Dimension resolution)
    {
        createFrame(resolution);
        addButtons();

        this.setVisible(true);
    }

    // Erstellt das PopUp Fenster
    private void createFrame(Dimension screenResolution)
    {
        this.setSize(200, 250);
        this.setLocation((screenResolution.width / 2) - (this.getWidth() / 2), (screenResolution.height / 2) - (this.getHeight() / 2));

        // Modal => Ist im Dauerfokus
        this.setResizable(true);
        this.setUndecorated(true);
        this.setModal(true);

        // Hinzufügen des JPanels
        this.add(popPanel);
        popPanel.setLayout(null);
        popPanel.setBackground(Color.red);
    }

    // Fügt die Buttons des PopUps hinzu
    private void addButtons()
    {
        // Button fürs Mieten
        rentButton.setSize(buttonSize);
        rentButton.setLocation((this.getWidth() / 2) - (rentButton.getWidth() / 2), (this.getHeight() / 2) - (rentButton.getHeight() / 2));
        popPanel.add(rentButton);

        // Button fürs Registrieren
        registerButton.setSize(buttonSize);
        registerButton.setLocation(rentButton.getX(), (this.getHeight() / 2) - (rentButton.getHeight() / 2));
        popPanel.add(registerButton);
    }
}
