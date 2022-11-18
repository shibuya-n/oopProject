import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Accounts {
    public double balance;
    public String accountName;
    //variables for depositing
    public static String depositResponse = " ";
    public static boolean depositFound = false;
    public static double depositAmount = 0;

    //variables for withdrawing
    public static String withdrawResponse = " ";
    public static boolean withdrawFound = false;
    public static double minBalance;

    public static String nameTemp = " ";
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
            depositAsk();
            newAccount.deposit();
            getName();
            newAccount.setName();

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
        System.out.println("How much money would you like to deposit?" + " (minimum initial deposit: " + minBalance + ")");

        depositResponse = depositAsk.nextLine();
        Pattern sortNum = Pattern.compile("[0-9]{1,13}(\\\\.[0-9]*)?");
        Matcher matcher = sortNum.matcher(depositResponse);
        depositFound = matcher.find();
    }
    public static void withdrawAsk() {
        System.out.println("-----DEPOSIT-----");
        Scanner withdrawAsk = new Scanner(System.in);
        System.out.println("How much money would you like to withdraw?");

        withdrawResponse = withdrawAsk.nextLine();
        Pattern sortNum = Pattern.compile("[0-9]{1,13}(\\\\.[0-9]*)?");
        Matcher matcher = sortNum.matcher(withdrawResponse);
        withdrawFound = matcher.find();
    }

    public static void getName() {
        Scanner nameAsk = new Scanner(System.in);
        System.out.println("What would you like to name this account?");
        nameTemp = nameAsk.nextLine().trim().toLowerCase();
    }
    public void setName() {
        accountName = nameTemp;
    }
    public void deposit() {
        if (depositFound) {
            balance = Double.parseDouble(depositResponse);
            balance += depositAmount;

            if (balance < minBalance) {
                errorMessage();
            } else {
                successMessage();
            }
        } else {
            syntaxError();
        }
    }
    public void withdraw() {
        if (withdrawFound) {
            balance -= Double.parseDouble(withdrawResponse);
            successMessage();
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
        System.out.println("Success!!");



    }




}
