import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class checkingAccount extends Accounts{

    public static String depositResponse = " ";
    public static boolean depositFound = false;

    public static String nameTemp = " ";


    public checkingAccount(double balance, String accountName){
        super(balance, accountName);
        minBalance = 20;

    }
    public static void menu(){
        Scanner scannerObject = new Scanner(System.in);
        System.out.println("WELCOME! LET'S GET STARTED.");
        System.out.println("What would you like to do? (new/back)");
        String userAnswer = scannerObject.nextLine().trim().toLowerCase();

        if (userAnswer.equals("new")) {

            checkingAccount newAccount = new checkingAccount(0,"");
            checkingList.add(newAccount);
            depositAsk();
            newAccount.deposit();

            System.out.println("New account successfully created!");
            System.out.println("Returning to HoME...");
            System.out.println(" ");



            oopProject.ask();
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

        Scanner nameAsk = new Scanner(System.in);
        System.out.println("What would you like to name this account?");
        nameTemp = nameAsk.nextLine().trim().toLowerCase();
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
        accountName = nameTemp;


    }
    public void errorMessage() {
        System.out.println("Sorry! You deposited too little money!" + " (minimum: " + minBalance + ")");
        depositAsk();
    }

}
