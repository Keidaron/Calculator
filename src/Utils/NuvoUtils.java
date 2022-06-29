package Utils;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.*;

import javax.swing.JComponent;

public class NuvoUtils {


    // (this.getWidth() / 2) - (rentButton.getWidth() / 2), (this.getHeight() / 2) - (rentButton.getHeight() / 2)
    public static Dimension getScreenResolution()
    {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    public static Dimension getMiddlePointOfComponents(Component parentComponent, Component childComponent)
    {
        return new Dimension((parentComponent.getWidth() / 2) - (childComponent.getWidth() / 2), (parentComponent.getHeight() / 2) - (childComponent.getHeight() / 2));
    }
    
    public static Dimension getMiddlePointOfValues(Point parentPosition, Point childPosition)
    {
        return new Dimension((parentPosition.x / 2) - (childPosition.x / 2), (parentPosition.y / 2) - (childPosition.x / 2));
    }
}
