import java.util.*;
import java.util.regex.*;
public class oopProject {
    public static String userAnswer = " ";
    public static int menuAnswer = 0;

    public static int carouselAnswer = 0;
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

                    System.out.println("Request Complete!");
                    System.out.println(" ");
                    accountCarousel();
                    ask();
                }
                else {
                    noCheckingAsk();
                }
            }
            else if (menuAnswer == 2) {
                if (Accounts.savingsList.size() > 0){

                    System.out.println("Request Complete!");
                    System.out.println(" ");
                    accountCarousel();

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

        for (int i = 0; i < useList.size(); i++) {
            int x = i + 1;
            System.out.println(x + ".");
            System.out.println("Account Name: " + useList.get(i).accountName);
            System.out.println("Balance: " + useList.get(i).balance);
            System.out.println(" ");
        }

        Scanner carouselAsk = new Scanner(System.in);
        System.out.println("Which account would you like to select? (TYPE EXIT TO EXIT)");
        String menuResponse = carouselAsk.nextLine().trim().toLowerCase();

        for (int i = 0; i < useList.size(); i++) {
            if (menuResponse.equals(useList.get(i).accountName)) {
                Accounts.depositAsk();
                useList.get(i).deposit();
            }
            else if (menuResponse.equals("exit")) {
                ask();
            }
            else {
                System.out.println("No matches found. Please try again.");
                accountCarousel();
            }

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


