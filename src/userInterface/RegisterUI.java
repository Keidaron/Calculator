package userInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tools.NuvoUtils;

//TODO Implementierung der Registrierung von Nutzern
public class RegisterUI extends JDialog {
    
    private Dimension size = new Dimension(200, 35);
    private JPanel panel = new JPanel();
    private JLabel message = new JLabel("Not implemented!");
    private JButton button = new JButton("OK");
    private RegisterUI instance;

    // Erstellt ein kleines Popup mit der Nachricht, dass es noch nicht implementiert ist
    public void initWindow()
    {
        this.setSize(size);
        this.setUndecorated(true);
        this.setLocation(NuvoUtils.getCenter(NuvoUtils.getScreenResolution(), this.getSize()));
        this.add(panel);

        message.setForeground(Color.red);
        message.setFont(new Font("SansSerif", Font.BOLD, 16));
        panel.add(message);

        button.setSize(25, 25);
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                instance.dispose();
            }
        });
        panel.add(button);

        instance = this;
        this.setModal(true);
        this.setVisible(true);
    }
}
