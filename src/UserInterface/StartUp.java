package userInterface;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import tools.NuvoUtils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StartUp extends JDialog
{
        //[Variables]
        Dimension buttonSize = new Dimension(120, 30);
        private int offset; // Für den Abstand der Buttons zueinander
        //[Objects]
        private JPanel popPanel = new JPanel();
        private JButton rentButton = new JButton("Preisberechnen");
        private JButton registerButton = new JButton("Registrieren");

        //[References]
        private StartUp _instance; // Eine Reference zu sich selbst um das schließen dieses Fensters zu ermöglichen


    // Constructor
    public StartUp(Dimension screenSize)
    {
        offset = buttonSize.height + 25;
        _instance = this;

        // Stellt das Fenster ein und füllt es mit Komponenten
        initStartUp(screenSize);

        // Dieses Fenster wird sichbar gemacht
        this.setVisible(true);
    }

    // Beginnt mit dem Initialisieren des StartUp Fensters
    public void initStartUp(Dimension screen)
    {
        createFrame(screen);
        addButtons();
    }

    // Erstellt das PopUp Fenster
    private void createFrame(Dimension screenSize)
    {
        this.setSize(200, 250);
        this.setLocation(NuvoUtils.getCenter(screenSize, this.getSize()));
        this.setResizable(true);
        this.setUndecorated(true);    // Entfernt die ActionBar
        this.setModal(true);                // Modal => Ist im Dauerfokus

        // Hinzufügen des JPanels für die Komponenten
        this.add(popPanel);

        // Layout und Hintergrund für das Panel des Fensters
        popPanel.setLayout(null);
        popPanel.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.GRAY));
        popPanel.setBackground(new Color(172,201,205,255));
    }

    // Fügt die Buttons des PopUps hinzu
    private void addButtons()
    {
        // Button fürs Mieten
        rentButton.setSize(buttonSize);
        rentButton.setLocation(NuvoUtils.getCenter(this.getSize(), rentButton.getSize()));
        rentButton.setLocation(rentButton.getX(), rentButton.getY() - offset);

        // Dem Button wird eine Methode zum Ausführen gegeben
        // Öffnet das Fenster zum verfolgen der aktuellen Nutzung
        rentButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                //TODO eine LoginAbfrage hinzufügen ?
                MainUI scooterUI;
                try {
                    scooterUI = new MainUI();
                    _instance.dispose();
                    scooterUI.toFront();
                } catch (IOException e1) {
                    System.err.println("Image was not found!");
                }
            }

        });
        popPanel.add(rentButton);

        // Button fürs Registrieren
        registerButton.setSize(buttonSize);
        registerButton.setLocation(NuvoUtils.getCenter(this.getSize(), rentButton.getSize()));

        // Dem Button wird eine Methode zum Ausführen gegeben
        // Öffnet den Registrierungs Dialog
        registerButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                //TODO einen User erstellen und in die Datenbank einschreiben ?
                RegisterUI register = new RegisterUI();
                register.initWindow();
            }
        });
        popPanel.add(registerButton);
    }
}
