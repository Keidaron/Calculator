import java.util.Scanner;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.println("Bitte gib die Minuten der Fahrzeit ein:");
        int inputMin = scanner.nextInt();
        System.out.println("Bitte gib die Sekunden der Fahrzeit ein:");
        int inputSec = scanner.nextInt();

        calc.SetPrice(inputMin, inputSec);
        calc.CalcPrice();
        scanner.close();

    }
}
