import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserInterface extends JFrame
{
    private Calculator calculator = new Calculator(0.18f);

    // Variablen
    private Dimension windowSize;
    private Dimension screenSize;

    // Fenster Komponenten
    BufferedImage logo;
    private JFrame windowFrame = new JFrame("ScooTeq Calculator");
    private JPanel windowPanel = new JPanel(new BorderLayout());
    private JPanel lowerPanel = new JPanel();
    private JPanel upperPanel = new JPanel();
    private JPanel midPanel = new JPanel(new GridLayout(3,2));
    private JButton calculateButton = new JButton("Preis berechnen!");
    private JLabel logoLabel = new JLabel();

    private JLabel minutesLabel = new JLabel("Minuten:");
    private JLabel secondsLabel = new JLabel("Sekunden:");
    private JTextField minutesField = new JTextField();
    private JTextField secondsField = new JTextField();
    private JLabel priceLabel = new JLabel("Preis:");
    private JTextField priceField = new JTextField();

    // Constructor
    public UserInterface(int width, int height) throws IOException
    {
        // Holt sich die Bildschirmgröße und setzt die windowSize
        screenSize = NuvoUtils.getScreenResolution();
        windowSize = new Dimension(width, height);

        // Liest das Logo aus dem Projektpfad aus
        InputStream input = new FileInputStream("src\\pictures\\templateLogo.jpg");
        logo = ImageIO.read(input);

        // Methodenaufruf
        init();
    }

    // Erstellt die komplette GUI
    private void init()
    {   
        // Fenstereinstellungen
        windowFrame.setSize(windowSize); // Fenstergröße
        windowFrame.setResizable(false); // Größe änderbar vom Anwender ?
        windowFrame.setLocation(NuvoUtils.getCenter(screenSize, windowFrame.getSize()));
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Beim Schließen des Fensters, wird auch das Programm terminiert

        // JPanel für das JFrame (Hauptfenster)
        windowPanel.setBackground(Color.lightGray);
        windowPanel.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.GRAY));
        windowFrame.add(windowPanel);

        // Hinzufügen der Gliederung für die Komponenten
        upperPanel.setBackground(new Color(172,201,205,255));
        windowPanel.add(upperPanel, BorderLayout.NORTH);

        midPanel.setBackground(Color.lightGray);
        midPanel.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.GRAY));
        windowPanel.add(midPanel, BorderLayout.CENTER);

        lowerPanel.setBackground(new Color(172,201,205,255));
        windowPanel.add(lowerPanel, BorderLayout.SOUTH);

        // Hinzufügen der Komponenten
        ImageIcon _icon = new ImageIcon(logo.getScaledInstance(100, 64, Image.SCALE_SMOOTH)); // Skaliert das Logo runter
        logoLabel.setIcon(_icon); // Label wird mit Logo gefüllt

        upperPanel.add(logoLabel);
        // Dem Button wird eine Methode zum ausführen gegeben.
        calculateButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent action) 
            {
                // Wenn keine Zahl/gar nichts eingetragen wird, dann öffnet sich eine Fehlermeldung.
                // Andernfalls wird der Preis berechnet
                try {
                    calculator.setTime(Integer.parseInt(minutesField.getText()), Integer.parseInt(secondsField.getText()));
                    priceField.setText(calculator.calculatePrice());
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(windowFrame, "Bitte trage Minuten und Sekunden ein!", "Falsche Eingabe", JOptionPane.ERROR_MESSAGE);
                }
                
            }

        });
        lowerPanel.add(calculateButton);

        midPanel.add(minutesLabel);
        midPanel.add(minutesField);

        midPanel.add(secondsLabel);
        midPanel.add(secondsField);

        midPanel.add(priceLabel);
        priceField.setEditable(false);
        midPanel.add(priceField);

        // Fenster wird sichtbar gemacht
        windowFrame.setVisible(true);
    }
}
