import UserInterface.MainUI;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        MainUI ui = new MainUI("ScooTeq Dings");
    }

    /*
     * // Initialisierung benötiger Objekte
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator(0.18f);

        // Userinput für Minuten und Sekunden
        System.out.println("Bitte gib die Minuten der Fahrzeit ein:");
        int inputMin = scanner.nextInt();
        System.out.println("Bitte gib die Sekunden der Fahrzeit ein:");
        int inputSec = scanner.nextInt();

        // Method-Calls für das Calculator-Objekt
        calc.setTime(inputMin, inputSec);
        calc.calculatePrice();

        System.out.println(calc.getTotalPrice() + " Euro für " + calc.getUseTime().toString() + " Minuten.");

        scanner.close();
     */
}
