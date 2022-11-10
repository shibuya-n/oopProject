import java.util.*;
public class oopProject {
    public static String userAnswer = " ";
    public static void main(String[] args){
        ask();
    }

    public static void ask() {
        System.out.println("[WELCOME TO BaNK]");
        Scanner menuAsk = new Scanner(System.in);
        System.out.println("[What would you like to do today?");
        System.out.println("1. Enter Checking Account");
        System.out.println("2. Enter Savings Account");
        System.out.println("3. Make a new account");
        System.out.println("4. Exit");
        int menuAnswer = Integer.parseInt(String.valueOf(menuAsk.nextLine()));

        exit();
        if (menuAnswer == 1) {
            System.out.println("Checking");
        } else if (menuAnswer == 2) {
            System.out.println("Savings");
        } else if (menuAnswer == 3) {
            System.out.println("New Account");
            accountCreate();
        } else {
            ask();
        }
    }

    public static void accountCreate() {
        Scanner accountAsk = new Scanner(System.in);
        System.out.println("[What kind of account would you like to make?] (CHECKING/SAVINGS/EXIT)");
        userAnswer += accountAsk.nextLine().trim().toLowerCase();

        if (userAnswer.equals("checking")) {
            userAnswer = " ";
            System.out.println("Checking");
        }

        else if (userAnswer.equals("savings")){
            userAnswer = " ";
            System.out.println("Savings");
        }
        else if (userAnswer.equals("exit")) {
            userAnswer = " ";
            ask();
        }
        else {
            System.out.print("[ERROR. PLEASE TRY AGAIN]");
            userAnswer = " ";
        }

        }
    public static void exit() {
        if (userAnswer.equals("exit")) {
            userAnswer = " ";
            System.out.println("Thank you for banking with BaNK");
            System.exit(0);
        }
    }

    }


