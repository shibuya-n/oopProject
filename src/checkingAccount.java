import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class checkingAccount extends Accounts{

    public checkingAccount(int balance){
        super(balance);
        minBalance = 20;

    }
    public static void menu(){
        Scanner scannerObject = new Scanner(System.in);
        System.out.println("WELCOME! LET'S GET STARTED.");
        System.out.println("What would you like to do? (new/back)");
        String userAnswer = scannerObject.nextLine().trim().toLowerCase();

        if (userAnswer.equals("deposit")) {
            deposit();
        }
        else if (userAnswer.equals("back")) {
            oopProject.ask();
        }
        else {
            System.out.println("[ERROR. PLEASE TRY AGAIN]");
            menu();
        }
    }
    public static void deposit(){
        checkingAccount initObj = new checkingAccount(minBalance);
        System.out.println("-----DEPOSIT-----");
        Scanner depositAsk = new Scanner(System.in);
        System.out.println("How much money would you like to deposit?" + " (minimum: " + minBalance + ")");

        String depositResponse = depositAsk.nextLine();
        Pattern sortNum = Pattern.compile("^\\d+$");
        Matcher matcher = sortNum.matcher(depositResponse);
        boolean depositFound = matcher.find();

        if (depositFound) {
            int depositAmount = Integer.parseInt(depositResponse);
            checkingAccount obj = new checkingAccount(depositAmount);

            if (depositAmount < minBalance) {
                System.out.println("Sorry! You deposited too little money!" + " (minimum: " + minBalance + ")");
                deposit();
            } else {
                System.out.println(" ");
                System.out.println("New Checking Account Successfully Created!");
                checkingList.add(obj);
                oopProject.ask();
            }
        } else {
            System.out.println("[ERROR. PLEASE TRY AGAIN]");
            deposit();
        }

    }
}
