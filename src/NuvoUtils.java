import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.*;

public class NuvoUtils {

    // Holt sich die Auflösung des Bildschirmes
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
}
