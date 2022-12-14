import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Accounts {
    public double balance;
    public String accountName;
    public String accountType;
    //variables for depositing
    public static String depositResponse = " ";
    public static boolean depositFound = false;
    public static double depositAmount = 0;

    //variables for withdrawing
    public static String withdrawResponse = " ";
    public static boolean withdrawFound = false;

    public static ArrayList<Accounts> checkingList = new ArrayList<>();
    public static ArrayList<Accounts> savingsList = new ArrayList<>();

    public static ArrayList<Accounts> nameList = new ArrayList<>();

    public static double minBalance;

    public Accounts(double balance, String accountName, String accountType){
        this.balance = balance;
        this.accountName = accountName;
        this.accountType = accountType;
    }
    public static void menu(){
        Scanner scannerObject = new Scanner(System.in);
        System.out.println("WELCOME! LET'S GET STARTED.");
        System.out.println("What would you like to do? (new/back)");
        String userAnswer = scannerObject.nextLine().trim().toLowerCase();

        if (userAnswer.equals("new")) {
            checkingAccount newAccount = new checkingAccount(0,"","");
            newAccount.deposit();
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
    public void setName() {
        Scanner nameAsk = new Scanner(System.in);
        System.out.println("What would you like to name this account?");
        String nameTemp = nameAsk.nextLine().trim().toLowerCase();

        if (nameList.size() > 0) {
            for (int i = 0; i < nameList.size(); i++) {
                if (nameTemp.equals(nameList.get(i).accountName)) {
                    System.out.println("Account name already used. Please try again.");
                    setName();
                }
            }
            accountName = nameTemp;
            successMessage();
            oopProject.ask();
        }
        else {
            accountName = nameTemp;
            successMessage();
            oopProject.ask();
        }
    }

    public void deposit() {
        System.out.println("-----DEPOSIT-----");
        Scanner depositAsk = new Scanner(System.in);
        System.out.println("How much money would you like to deposit?" + " (minimum: " + minBalance + ")");

        depositResponse = depositAsk.nextLine().trim();
        Pattern sortNum = Pattern.compile("^(0|[1-9]\\d*)?(\\.\\d+)?(?<=\\d)$");
        Matcher matcher = sortNum.matcher(depositResponse);
        depositFound = matcher.find();

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
            deposit();
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
    public void syntaxError(){
        System.out.println("[ERROR. PLEASE TRY AGAIN]");
    }
    public void errorMessage() {
        System.out.println("Sorry! You deposited too little money!" + " (minimum: " + minBalance + ")");
        deposit();
    }
    public void successMessage() {
        System.out.println(" ");
        System.out.println("Success!!");
        System.out.println(" ");



    }
    public void interest() {
    }
}
