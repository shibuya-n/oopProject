import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class savingsAccount extends Accounts {

    public static boolean interestFound = false;

    public static String interestResponse = "";
    public static double minBalance = 100;


    public savingsAccount(double balance, String accountName, String accountType) {
        super(balance, accountName, accountType);
        this.accountType = "SAVINGS";


    }

    public static void menu() {
        Scanner scannerObject = new Scanner(System.in);
        System.out.println("WELCOME! LET'S GET STARTED.");
        System.out.println("What would you like to do? (new/back)");
        String userAnswer = scannerObject.nextLine().trim().toLowerCase();

        if (userAnswer.equals("new")) {

            savingsAccount newAccount = new savingsAccount(0, "", "SAVINGS");
            savingsList.add(newAccount);
            newAccount.deposit();
            newAccount.setName();

            System.out.println("Success!!");
            System.out.println("Returning to HoME...");
            System.out.println(" ");

            oopProject.ask();
        } else if (userAnswer.equals("back")) {
            oopProject.ask();
        } else {
            System.out.println("[ERROR. PLEASE TRY AGAIN]");
            menu();
        }
    }

    public void deposit() {
        System.out.println("-----DEPOSIT-----");
        Scanner depositAsk = new Scanner(System.in);
        System.out.println("How much money would you like to deposit?" + " (minimum: " + minBalance + ")");

        depositResponse = depositAsk.nextLine().trim();
        Pattern sortNum = Pattern.compile("^[0-9]*$");
        Matcher matcher = sortNum.matcher(depositResponse);
        depositFound = matcher.find();

        if (depositFound) {
            if ((Double.parseDouble(depositResponse) >= minBalance) || (balance >= minBalance)) {
                balance += Double.parseDouble(depositResponse);
                successMessage();
            } else {
                errorMessage();

            }
        } else {
            syntaxError();
            deposit();
        }
    }

    public static void interestCarousel() {
        System.out.println("-----INTEREST-----");
        Scanner accountAsk = new Scanner(System.in);

        for (int i = 0; i < savingsList.size(); i++) {
            int x = i + 1;
            System.out.println(x + ".");
            System.out.println("Account Name: " + savingsList.get(i).accountName);
            System.out.println("Account Type: " + savingsList.get(i).accountType);
            System.out.println("Balance: " + savingsList.get(i).balance);
            System.out.println(" ");
        }

        System.out.println("Which account would you like to select? (TYPE exit TO EXIT)");
        String accResponse = accountAsk.nextLine().trim().toLowerCase();

        if (accResponse.equals("exit")) {
            oopProject.ask();
        }

        for (int i = 0; i < savingsList.size(); i++) {
            if (accResponse.equals(savingsList.get(i).accountName)) {
                Scanner actionAsk = new Scanner(System.in);
                System.out.println("Simulate Interest? (YES/NO)");
                String actionResponse = actionAsk.nextLine().trim().toLowerCase();
                switch (actionResponse) {
                    case "yes" -> {
                        savingsList.get(i).interest();
                        interestCarousel();
                    }
                    case "no" -> {
                        interestCarousel();
                    }
                    default -> {
                        System.out.println("[ERROR. PLEASE TRY AGAIN]");
                        interestCarousel();
                    }
                }
                i = 0;

            }
        }
        System.out.println("No matches found. Please try again.");
        interestCarousel();

    }
    public void interest() {
        Scanner interestAsk = new Scanner(System.in);
        System.out.println("How many years would you like to fast forward? (interest rate: 3% a year)");
        interestResponse = interestAsk.nextLine().trim();
        Pattern sortNum = Pattern.compile("^[0-9]*$");
        Matcher matcher = sortNum.matcher(interestResponse);
        interestFound = matcher.find();

        if (interestFound) {
            double interest = (balance * 0.03) * Double.parseDouble(interestResponse);
            balance += interest;
            System.out.println("Success! Amount of interest: " + interest);

        }
    }
    public void withdraw() {
        System.out.println("-----WITHDRAW-----");
        Scanner withdrawAsk = new Scanner(System.in);
        System.out.println("How much money would you like to withdraw?");

        withdrawResponse = withdrawAsk.nextLine().trim();
        Pattern sortNum = Pattern.compile("^[0-9]*$");
        Matcher matcher = sortNum.matcher(withdrawResponse);
        withdrawFound = matcher.find();

        if (withdrawFound && (minBalance <= (balance - Double.parseDouble(withdrawResponse)))) {
            balance -= Double.parseDouble(withdrawResponse);
            successMessage();
        } else {
            System.out.println("Your balance is too low to withdraw this amount of money. Please first deposit more money.");
            oopProject.accountCarousel();
        }
    }


        public void errorMessage () {
            System.out.println("Sorry! You deposited too little money!" + " (minimum: " + minBalance + ")");
            System.out.println(" ");
            deposit();
        }
    }



