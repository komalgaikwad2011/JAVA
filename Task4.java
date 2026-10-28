package cogni;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Temperature Converter ===");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Choose conversion direction (1 or 2): ");

        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter temperature in Celsius (°C): ");
            double celsius = scanner.nextDouble();
            double fahrenheit = (celsius * 9.0 / 5.0) + 32.0;
            System.out.printf("%.2f°C = %.2f°F\n", celsius, fahrenheit);
        } else if (choice == 2) {
            System.out.print("Enter temperature in Fahrenheit (°F): ");
            double fahrenheit = scanner.nextDouble();
            double celsius = (fahrenheit - 32.0) * 5.0 / 9.0;
            System.out.printf("%.2f°F = %.2f°C\n", fahrenheit, celsius);
        } else {
            System.out.println("Invalid selection. Please choose 1 or 2.");
        }

        scanner.close();
    }
}