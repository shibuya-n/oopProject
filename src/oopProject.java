import java.util.*;
import java.util.regex.*;
public class oopProject {
    public static String userAnswer = " ";
    public static int menuAnswer = 0;
    public static void main(String[] args){
        System.out.println("[WELCOME TO BaNK]");
        ask();
    }

    public static void ask() {
        Scanner menuAsk = new Scanner(System.in);
        System.out.println("[What would you like to do today?]");
        System.out.println("1. Enter Checking Account(s)");
        System.out.println("2. Enter Savings Account(s)");
        System.out.println("3. Make a new account");
        System.out.println("4. Exit");
        String menuResponse = menuAsk.nextLine();

        Pattern sortNum = Pattern.compile("^\\d+$");
        Matcher matcher = sortNum.matcher(menuResponse);
        boolean matchFound = matcher.find();

        if (matchFound) {
            menuAnswer = Integer.parseInt(menuResponse);
            if (menuAnswer == 1) {
                if (Accounts.checkingList.size() > 0){
                    accountCarousel();
                    System.out.println("Checking");
                    System.out.println("Request Complete!");
                    System.out.println(Accounts.checkingList);
                    System.out.println(" ");
                    ask();
                }
                else {
                    noCheckingAsk();
                }
            }
            else if (menuAnswer == 2) {
                if (Accounts.savingsList.size() > 0){
                    accountCarousel();
                    System.out.println("Checking");
                    System.out.println("Request Complete!");
                    System.out.println(Accounts.savingsList);
                    System.out.println(" ");
                    ask();
                }
                else {
                    noCheckingAsk();
                }
            }
            else if (menuAnswer == 3) {
                accountCreate();
            }
            else if (menuAnswer == 4) {
                System.out.println("Thank you for banking with BaNK");
                System.exit(0);
            }
            else {
                System.out.println("[ERROR. PLEASE TRY AGAIN]");
                ask();

            }
        }
        else {
            System.out.println("[ERROR. PLEASE TRY AGAIN]");
            ask();
            }
        }

    public static void accountCarousel() {
        ArrayList<Accounts> useList;
        if (menuAnswer == 1) {
            useList = Accounts.checkingList;
        }
        else {
            useList = Accounts.savingsList;
        }

        for (Accounts accounts : useList) {
            System.out.println(accounts);
        }

    }
    public static void noCheckingAsk() {
        System.out.println("No accounts found. :( ");

        Scanner newAccountAsk = new Scanner(System.in);
        System.out.println("Make a new account? (yes/no)");
        String askResponse = newAccountAsk.nextLine().trim().toLowerCase();

        if (askResponse.equals("yes")){
            checkingAccount.menu();
        }
        else if (askResponse.equals("no")){
            ask();
        }
        else{
            System.out.println("[ERROR. PLEASE TRY AGAIN]");
        }
    }
    public static void noSavingsAsk() {
        System.out.println("No accounts found. :( ");

        Scanner newAccountAsk = new Scanner(System.in);
        System.out.println("Make a new account? (yes/no)");
        String askResponse = newAccountAsk.nextLine().trim().toLowerCase();

//        if (askResponse.equals("yes")){
//            checkingAccount.menu();
//        }
//        else if (askResponse.equals("no")){
//            ask();
//        }
//        else{
//            System.out.println("[ERROR. PLEASE TRY AGAIN]");
//        }
    }

    public static void accountCreate() {
        Scanner accountAsk = new Scanner(System.in);
        System.out.println("[What kind of account would you like to make?] (CHECKING/SAVINGS/EXIT)");
        userAnswer = accountAsk.nextLine().trim().toLowerCase();

        switch (userAnswer) {
            case "checking" -> {
                userAnswer = " ";
                checkingAccount.menu();
            }
            case "savings" -> {
                userAnswer = " ";
                System.out.println("Savings");
            }
            case "exit" -> {
                userAnswer = " ";
                ask();
            }
            default -> {
                System.out.println("[ERROR. PLEASE TRY AGAIN]");
                userAnswer = " ";
                accountCreate();
            }
        }
    }
}


