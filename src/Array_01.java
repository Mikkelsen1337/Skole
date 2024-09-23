import java.util.Scanner;

public class Array_01 {
    public static void main(String[] args) {
        // Opret et array med plads til 10 heltal
        int[] numbers = new int[10];
        Scanner scanner = new Scanner(System.in);

        // Indlæs 10 heltal i arrayet
        System.out.println("Indtast 10 heltal:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Udskriv alle heltal i arrayet
        System.out.println("Heltal i arrayet:");
        printArray(numbers);

        // Læg 2 til alle tal i arrayet
        addTwo(numbers);

        // Udskriv alle heltal i arrayet igen
        System.out.println("Array efter at have lagt 2 til hvert tal:");
        printArray(numbers);

        // Beregn og udskriv gennemsnittet
        double avg = average(numbers);
        System.out.println("Gennemsnittet af tallene er: " + avg);

        // Find og udskriv det største tal
        int highestNumber = max(numbers);
        System.out.println("Det største tal er: " + highestNumber);

        // Find og udskriv det mindste tal
        int lowestNumber = findLowest(numbers);
        System.out.println("Det mindste tal er: " + lowestNumber);

        // Indtast 10 navne og udskriv dem
        String[] names = namesPrinter();
        System.out.println("De indtastede navne er:");
        printArray(names);

        int namecounter = overFive(names);
        System.out.println("Antallet af navne med mere end 5 bogstaver: " + namecounter);


    }

    // Metode til at tilføje 2 til hvert element
    public static void addTwo(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] += 2;
        }
    }

    // Metode til at udskrive int-arrayet
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.println(value);
        }
    }

    // Metode til at udskrive String-arrayet
    public static void printArray(String[] array) {
        for (String value : array) {
            System.out.println(value);
        }
    }

    // Metode til at beregne gennemsnittet
    public static double average(int[] array) {
        int total = 0;
        for (int value : array) {
            total += value;
        }
        return (double) total / array.length; // Bruger array.length direkte
    }

    // Metode til at finde det største tal
    public static int max(int[] array) {
        int highestNumber = array[0]; // Antag, at det første element er det største
        for (int i = 1; i < array.length; i++) {
            if (array[i] > highestNumber) {
                highestNumber = array[i];
            }
        }
        return highestNumber; // Returner det største tal
    }

    // Metode til at finde det mindste tal
    public static int findLowest(int[] array) {
        int lowestNumber = array[0]; // Antag, at det første element er det mindste
        for (int i = 1; i < array.length; i++) {
            if (array[i] < lowestNumber) {
                lowestNumber = array[i];
            }
        }
        return lowestNumber; // Returner det mindste tal
    }

    // Metode til at indtaste navne
    public static String[] namesPrinter() {
        Scanner input = new Scanner(System.in);
        String[] names = new String[10];
        int count = 0;

        while (count < names.length) {
            System.out.println("Indtast et navn, hvis færdig tast 'afslut':");
            String name = input.nextLine();

            if (name.equalsIgnoreCase("Afslut")) {
                break; // Stop hvis brugeren skriver "Afslut"
            }

            names[count] = name; // Gem navnet i arrayet
            count++;
        }
        return names; // Returner de indtastede navne
    }
    public static int overFive(String[] names) {
        int namecounter = 0;
        //udskriv navne med mere end 5 bogstaver
        for (String name : names) {
            if (name != null && name.length() > 5) {
            namecounter++;
            }
        }
        return namecounter;
    }
}

