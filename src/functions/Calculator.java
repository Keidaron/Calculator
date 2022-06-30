package functions;

public class Calculator 
{
    private float pricePerMinute = 0.18f;
    private float pricePerSecond;
    private TimeStruct useTime;

    private float totalPrice;

    // Setzt bei Erstellung des Objektes den Preis pro Minute
    public Calculator(float pricePerMinute)
    {
        this.pricePerMinute = pricePerMinute;
        this.pricePerSecond = pricePerMinute / 60;
    }

    // Erstellt ein TimeStruct Objekt mit der Nutzungszeit des Scooters
    public void setTime(int minutes, int seconds)
    {
        useTime = new TimeStruct(minutes, seconds);
    }

    // Berechnet den Preis der Nutzungszeit
    public String calculatePrice()
    {
        totalPrice = useTime.getMinutes() * pricePerMinute + useTime.getSeconds() * pricePerSecond;

        // Rundung des Preises auf 2 Kommastellen
        totalPrice = (float)Math.floor(totalPrice * 100) / 100;
        return "" + totalPrice;
    }

    public TimeStruct getUseTime()
    {
        return useTime;
    }

    public float getPricePerMinute()
    {
        return pricePerMinute;
    }

    public float getTotalPrice()
    {
        return totalPrice;
    }
}
