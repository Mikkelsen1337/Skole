import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    public static void main(String[] args) {
        ArrayList<String> usernames = new ArrayList<>();
        ArrayList<String> passwords = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);


        //Her laver vi en løkke for at tilføje brugere dynamisk, da statisk er for kedeligt :)
        boolean addMoreUsers = true;
        while (addMoreUsers) {
            System.out.println("");
            System.out.println("1. Opret en ny bruger ");
            System.out.println("2. Login med eksisterende konto");
            System.out.println("3. Afslut");
            System.out.print("Vælg en handling: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                //Her tilføjer vi en bruger via vores metode
                addUser(usernames, passwords);
            } else if (choice == 2) {
                //Her kan brugeren logge ind med en eksisterende bruger
                loginFunction(usernames, passwords);
            } else if (choice == 3) {
                addMoreUsers = false;
            } else {
                System.out.println("Ugyldigt valg, prøv igen ");
            }
        }
    }

    //Her laver vi metoden til at oprette en ny bruger
    public static void addUser(ArrayList<String> usernames, ArrayList<String> passwords) {
        Scanner scanner = new Scanner(System.in);

        //Indtast username for brugeren
        System.out.println("Indtast venligst et brugernavn: ");
        String newUsername = scanner.nextLine();

        if (usernames.contains(newUsername)) {
            System.out.println("Brugernavnet findes allerede, prøv et andet.");
            return; // Afslut metoden
        }

        //Indtast password for brugeren
        System.out.println("Angiv et kodeord: ");
        String newPassword = scanner.nextLine();


        //Tilføjer til vores arraylister
        usernames.add(newUsername);
        passwords.add(newPassword);

        System.out.println("Brugeren er nu oprettet: " + newUsername);

    }

    //Her laver vi metoden til vores login
    public static void loginFunction(ArrayList<String> usernames, ArrayList<String> passwords) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 3; // Max forsøg
        while (attempts > 0) {
            System.out.print("Angiv dit brugernavn: ");
            String inputUsername = scanner.nextLine();

            System.out.print("Angiv dit kodeord: ");
            String inputPassword = scanner.nextLine();

            //validering af login
            boolean loginSuccess = false;
            for (int i = 0; i < usernames.size(); i++) {
                if (usernames.get(i).equals(inputUsername) && passwords.get(i).equals(inputPassword)) {
                    loginSuccess = true;
                    break;
                }
            }
        if (loginSuccess) {
            //Hvis logginnet lykkedes
            System.out.println("Login Vellykket! Velkommen " + inputUsername + "!");
            return;
        }   else {
            attempts--;
            if (attempts > 0) {
                System.out.println("Login fejlede, du har " + attempts + " forsøg tilbage. ");
            } else {
                System.out.println("For mange mislykkede forsøg, programmet afsluttes. ");
            }
        }

        }
    }
}
