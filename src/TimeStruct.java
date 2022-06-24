public class TimeStruct 
{
    private int minutes;
    private int seconds;
    
    public TimeStruct(int min, int sec)
    {
        minutes = min;
        seconds = sec;

        if(seconds >= 60)
        {
            minutes = minutes + 1;
            seconds = seconds - 60;
        }
    }

    public String GetTime()
    {
        String _temp = minutes + "," + seconds;
        return _temp;
    }

    public int GetMinutes()
    {
        return minutes;
    }
    public int GetSeconds()
    {
        return seconds;
    }
}
