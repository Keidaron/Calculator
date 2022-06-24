
public class Calculator 
{
    public float pricePerMinute = 0.18f;
    public TimeStruct useTime;

    public void SetPrice(int minutes, int seconds)
    {
        useTime = new TimeStruct(minutes, seconds);
    }

    public void CalcPrice()
    {
        float pricePerSecond = pricePerMinute / 60;
        float price = useTime.GetMinutes() * pricePerMinute + useTime.GetSeconds() * pricePerSecond;
        System.out.println(Math.floor(price * 100) / 100);
    }
}
