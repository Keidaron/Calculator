import tools.NuvoUtils;
import userInterface.StartUp;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        StartUp start = new StartUp(NuvoUtils.getScreenResolution());
        start.initStartUp(NuvoUtils.getScreenResolution());
    }
}
