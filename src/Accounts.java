import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Accounts {
    public double balance;
    public String accountName;
    public static String depositResponse = " ";
    public static boolean depositFound = false;
    public static double minBalance;

    public static ArrayList<Accounts> checkingList = new ArrayList<>();
    public static ArrayList<Accounts> savingsList = new ArrayList<>();

    public Accounts(double balance, String accountName){
        this.balance = balance;
        this.accountName = accountName;
        this.minBalance = 0;
    }
    public static void menu(){
        Scanner scannerObject = new Scanner(System.in);
        System.out.println("WELCOME! LET'S GET STARTED.");
        System.out.println("What would you like to do? (new/back)");
        String userAnswer = scannerObject.nextLine().trim().toLowerCase();

        if (userAnswer.equals("new")) {
            checkingAccount newAccount = new checkingAccount(0,"");
            newAccount.deposit();
        }
        else if (userAnswer.equals("back")) {
            oopProject.ask();
        }
        else {
            System.out.println("[ERROR. PLEASE TRY AGAIN]");
            menu();
        }
    }
    public static void depositAsk() {
        System.out.println("-----DEPOSIT-----");
        Scanner depositAsk = new Scanner(System.in);
        System.out.println("How much money would you like to deposit?" + " (minimum: " + minBalance + ")");

        depositResponse = depositAsk.nextLine();
        Pattern sortNum = Pattern.compile("[0-9]{1,13}(\\\\.[0-9]*)?");
        Matcher matcher = sortNum.matcher(depositResponse);
        depositFound = matcher.find();
    }
    public void deposit() {
        if (depositFound) {
            double depositAmount = Double.parseDouble(depositResponse);
            balance += depositAmount;

            if (depositAmount < minBalance) {
                errorMessage();
            } else {
                successMessage();
            }
        } else {
            syntaxError();
        }

    }
    public void syntaxError(){
        System.out.println("[ERROR. PLEASE TRY AGAIN]");
        depositAsk();
    }
    public void errorMessage() {
        System.out.println("Sorry! You deposited too little money!" + " (minimum: " + minBalance + ")");
        depositAsk();
    }
    public void successMessage() {
        System.out.println(" ");
        System.out.println("New Checking Account Successfully Created!");
        oopProject.ask();

    }




}
