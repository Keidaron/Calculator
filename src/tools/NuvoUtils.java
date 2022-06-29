package tools;

import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.*;

public class NuvoUtils {

    // (this.getWidth() / 2) - (rentButton.getWidth() / 2), (this.getHeight() / 2) - (rentButton.getHeight() / 2)
    public static Dimension getScreenResolution()
    {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    // Berechnet den Punkt um ein Objekt innerhalb eines anderen zu Zentrieren
    // Warum ? -> Oben Links einer jeden Komponente sind die Koordinaten 0
    public static Point getCenter(Point objectToWhereCenter, Dimension objectToCenter)
    {
        Point _p = new Point((objectToWhereCenter.x / 2) - (objectToCenter.width / 2), (objectToWhereCenter.y / 2) - (objectToCenter.height / 2));
        return _p;
    }

    public static Point getCenter(Dimension objectToWhereCenter, Dimension objectToCenter)
    {
        Point _p = new Point((objectToWhereCenter.width / 2) - (objectToCenter.width / 2), (objectToWhereCenter.height / 2) - (objectToCenter.height / 2));
        return _p;
    }

    // Berechnet den Mittelpunkt des Bildschirmes
    public static Point getScreenMidpoint()
    {
        Point _p = new Point(getScreenResolution().width / 2, getScreenResolution().height / 2);
        return _p;
    }

    // Berechnet den Mittelpunkt einer Komponente
    public static Point getMidPointOfComponent(Component component)
    {
        Point _p = new Point(component.getSize().width / 2, component.getSize().height / 2);
        return _p;
    }
}
