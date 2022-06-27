public class TimeStruct 
{
    private int minutes;
    private int seconds;
    
    public TimeStruct(int min, int sec)
    {
        minutes = min;
        seconds = sec;

        // Wenn die Sekunden größer/gleich 60 sein sollten werden die Minuten 
        // hochgezählt und die Sekunden abgezogen
        while(seconds >= 60)
        {
            minutes = minutes + 1;
            seconds = seconds - 60;
        }
    }

    public int getMinutes()
    {
        return minutes;
    }

    public int getSeconds()
    {
        return seconds;
    }

    // Gibt die Variablen des Objekts als
    // wunderschönen String zurück
    public String toString()
    {
        return minutes + ":" + seconds;
    }
}
