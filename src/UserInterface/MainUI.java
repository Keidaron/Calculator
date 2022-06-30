package userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import functions.Calculator;
import tools.NuvoUtils;

/**
 * MainUI
 * Hier wird alles anzeigt was interessant ist
 */
public class MainUI extends JFrame{
    
    //[Variables]
    Dimension screenResolution;
    Dimension textFieldSize = new Dimension(80, 25);
    BufferedImage logo;

    //[Objects]
    // Das obere Panel mit seinen Komponenten
    private JPanel mainPanel = new JPanel(new BorderLayout());
    private JPanel upperPanel = new JPanel();
        private JLabel logoLabel = new JLabel();        

    // Das mittlere Panel mit seinen Komponenten
    private JPanel midPanel = new JPanel();
        private JLabel timeLabel = new JLabel("Gefahrene Zeit");
        private JLabel minuteLabel = new JLabel("Minuten:");
        private JTextField minutesField = new JTextField();
        private JLabel secondsLabel = new JLabel("Sekunden:");
        private JTextField secondsField = new JTextField();
        private JLabel priceLabel = new JLabel("Fahrtpreis");
        private JTextField priceField = new JTextField();

    // Das untere Panel mit seinen Komponenten
    private JPanel lowerPanel = new JPanel();
        private JButton endAndCalculate = new JButton("Fahrt beenden!");

    //[References]
    private MainUI _instance;

    // Initialisiert das Hauptfenster der GUI
    public MainUI() throws IOException
    {
        // Bildschirmauflösung wird bestimmt
        screenResolution = NuvoUtils.getScreenResolution();
        InputStream input = new FileInputStream("src\\pictures\\templateLogo.jpg");
        logo = ImageIO.read(input);
        _instance = this;

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
        this.setSize(400, 250);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
            timeLabel.setFont(new Font("SansSerif", Font.BOLD, 16));

            midPanel.add(minuteLabel);
            midPanel.add(minutesField);
            minutesField.setPreferredSize(textFieldSize);
            minutesField.setText("Minuten");

            midPanel.add(secondsLabel);
            midPanel.add(secondsField);
            secondsField.setPreferredSize(textFieldSize);
            secondsField.setText("Sekunden");

            midPanel.add(priceLabel);
            priceField.setPreferredSize(textFieldSize);
            priceField.setText("Preis");
            midPanel.add(priceField);
        //#endregion

        //#region Unteres Panel
            endAndCalculate.setSize(100, 25);
            endAndCalculate.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(validInput(getMinutes()))
                    {
                        if(validInput(getSeconds()))
                        {
                            Calculator calc = new Calculator(0.18f);
                            calc.setTime(Integer.parseInt(getMinutes()), Integer.parseInt(getSeconds()));
                            priceField.setText(new DecimalFormat("##.##").format(Float.parseFloat(calc.calculatePrice())));
                            return;
                        }
                    }

                    //JOptionPane op = new JOptionPane();
                    JOptionPane.showMessageDialog(_instance, "Es wurden keine Sekunden oder Minuten eingegeben.");
                }
                
            });
            lowerPanel.add(endAndCalculate);
        //#endregion
    }

    private void initPictures()
    {
        ImageIcon _icon = new ImageIcon(logo.getScaledInstance(64, 64, Image.SCALE_SMOOTH));
        logoLabel.setIcon(_icon);
    }


    // Prüft ob der Input eine Zahl ist
    private boolean validInput(String input)
    {
        try {
            if(input.equals(""))
            {
                input = "0";
            }
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String getMinutes()
    {
        return minutesField.getText();
    }

    private String getSeconds()
    {
        return secondsField.getText();
    }
}