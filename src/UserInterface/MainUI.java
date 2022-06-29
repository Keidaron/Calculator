package userInterface;

import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tools.NuvoUtils;

/**
 * MainUI
 * Hier wird alles anzeigt was interessant ist
 */
public class MainUI extends JFrame{
    
    //[Variables]
    Dimension screenResolution;
    BufferedImage logo;

    //[Objects]
    // Das obere Panel mit seinen Komponenten
    private JPanel mainPanel = new JPanel(new BorderLayout());
    private JPanel upperPanel = new JPanel();
        private JLabel logoLabel = new JLabel();        

    // Das mittlere Panel mit seinen Komponenten
    private JPanel midPanel = new JPanel();
        private JLabel timeLabel = new JLabel("Gefahrene Zeit");
        private JTextField timeField = new JTextField();
        private JLabel priceLabel = new JLabel("Fahrtpreis");
        private JTextField priceField = new JTextField();

    // Das untere Panel mit seinen Komponenten
    private JPanel lowerPanel = new JPanel();
        private JButton endAndCalculate = new JButton("Fahrt beenden!");

    //[References]

    // Initialisiert das Hauptfenster der GUI
    public MainUI() throws IOException
    {
        // Bildschirmauflösung wird bestimmt
        screenResolution = NuvoUtils.getScreenResolution();
        InputStream input = new FileInputStream("src\\pictures\\templateLogo.jpg");
        logo = ImageIO.read(input);

        initWindow();
        initPanels();
        initComponents();
        initPictures();

        // Fenster wird sichtbar gemacht
        this.setVisible(true);
    }

    private void initWindow()
    {
        // Einstellung des Fensters
        this.setUndecorated(true);
        this.setSize(400, 250);
        this.setLocation(NuvoUtils.getCenter(NuvoUtils.getScreenResolution(), this.getSize()));

        // Anderer Dekokram
    }

    private void initPanels()
    {
        // Panel des Fensters
        this.add(mainPanel);

        upperPanel.setBackground(Color.cyan);
        mainPanel.add(upperPanel, BorderLayout.NORTH);

        midPanel.setBackground(Color.lightGray);
        mainPanel.add(midPanel, BorderLayout.CENTER);

        lowerPanel.setBackground(Color.cyan);
        mainPanel.add(lowerPanel, BorderLayout.SOUTH);
    }

    private void initComponents()
    {
        //#region Oberes Panel
            upperPanel.add(logoLabel);
        //#endregion

        //#region Mittleres Panel
            midPanel.add(timeLabel);
            midPanel.add(timeField);
            midPanel.add(priceLabel);
            midPanel.add(priceField);
        //#endregion

        //#region Unteres Panel
            endAndCalculate.setSize(100, 25);
            lowerPanel.add(endAndCalculate);
        //#endregion
    }

    private void initPictures()
    {
        ImageIcon _icon = new ImageIcon(logo.getScaledInstance(64, 64, Image.SCALE_SMOOTH));
        logoLabel.setIcon(_icon);
    }
}