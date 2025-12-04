import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Customer> customer = createCustomerList("customersList.csv");
        ArrayList<Tech> tech = createTechList("techList.csv");

        int amountTech = getValidIntInput("Amount of techs: ", 0, 50);
        int initialCustomerCount = getValidIntInput("Initial customer count: ", 0, 1000);
        int hours = getValidIntInput("Total hours: ");
        int interval = getValidIntInput("What is the interval: ");
        int callRate = getValidIntInput("Call rate: ");
        double meanCallTime = getValidDoubleInput("Mean Call Time: ");
        double sDiveCallTime = getValidDoubleInput("Standard Deviation Call: ");
        Simulation simulation = new Simulation(amountTech, initialCustomerCount, hours, interval,
                callRate, meanCallTime, sDiveCallTime, tech, customer);
        simulation.start();
    }

    public static int getValidIntInput(String prompt) {
        return getValidIntInput(prompt, 0, Integer.MAX_VALUE);
    }

    public static int getValidIntInput(String prompt, int minRange, int maxRange) {
        int save = minRange - 1;
        do {
            Scanner input = new Scanner(System.in);
            System.out.print(prompt);
            if (input.hasNextInt()) {
                save = input.nextInt();
            }
        }
        while (!(save > minRange && save < maxRange));
        return save;
    }

    public static double getValidDoubleInput(String prompt) {
        return getValidDoubleInput(prompt, 0, Double.MAX_VALUE);
    }

    public static double getValidDoubleInput(String prompt, double minRange, double maxRange) {
        double save = minRange - 1.0;
        do {
            Scanner input = new Scanner(System.in);
            System.out.print(prompt);
            if (input.hasNextDouble()) {
                save = input.nextDouble();
            }
        }
        while (!(save > minRange && save < maxRange));
        return save;
    }

    public static ArrayList<Customer> createCustomerList(String fileName) throws FileNotFoundException {
        ArrayList<Customer> arr = new ArrayList<>();

        Scanner scanner;
        File file = new File(fileName);
        scanner = new Scanner(file);

        scanner.nextLine(); // skip header

        String[] saveData;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            saveData = line.split(",");

            String id = saveData[0];
            String firstName = saveData[1];
            String lastName = saveData[2];
            String email = saveData[3];
            String phoneNumber = saveData[4];

            Customer customer = new Customer(id, firstName, lastName, email, phoneNumber);
            arr.add(customer);
        }
        return arr;
    }

    public static ArrayList<Tech> createTechList(String fileName) throws FileNotFoundException {
        ArrayList<Tech> arr = new ArrayList<>();

        Scanner scanner;
        File file = new File(fileName);
        scanner = new Scanner(file);

        scanner.nextLine(); // skip header

        String[] saveData;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            saveData = line.split(",");

            String id = saveData[0];
            String firstName = saveData[1];
            String lastName = saveData[2];
            String userId = saveData[3];

            Tech tech = new Tech(id, firstName, lastName, userId);
            arr.add(tech);
        }
        return arr;
    }
}