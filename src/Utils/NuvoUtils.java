package Utils;
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

    public static Dimension getMiddlePointOfComponents(Component parentComponent, Component childComponent)
    {
        return new Dimension((parentComponent.getWidth() / 2) - (childComponent.getWidth() / 2), (parentComponent.getHeight() / 2) - (childComponent.getHeight() / 2));
    }

    public static Point getMiddlePointOfValues(Dimension parentPosition, Dimension childPosition)
    {
        return new Point((parentPosition.width / 2) - (childPosition.width / 2), (parentPosition.height / 2) - (childPosition.height / 2));
    }

    public static Point getMiddleOfScreen()
    {
        Point _p = new Point(getScreenResolution().width / 2, getScreenResolution().height / 2);
        return _p;
    }
}
