import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class checkingAccount extends Accounts{

    public static boolean depositFound = false;

    public static double minBalance = 20;
    public checkingAccount(double balance, String accountName, String accountType){
        super(balance, accountName, accountType);
        this.accountType = "CHECKING";
    }
    public static void menu(){
        Scanner scannerObject = new Scanner(System.in);
        System.out.println("WELCOME! LET'S GET STARTED.");
        System.out.println("What would you like to do? (new/back)");
        String userAnswer = scannerObject.nextLine().trim().toLowerCase();

        if (userAnswer.equals("new")) {

            checkingAccount newAccount = new checkingAccount(0,"","CHECKING");
            checkingList.add(newAccount);
            newAccount.deposit();
            newAccount.setName();

            System.out.println("Success!!");
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
    public void withdraw() {
        System.out.println("-----WITHDRAW-----");
        Scanner withdrawAsk = new Scanner(System.in);
        System.out.println("How much money would you like to withdraw?");

        withdrawResponse = withdrawAsk.nextLine().trim();
        Pattern sortNum = Pattern.compile("^(0|[1-9]\\d*)?(\\.\\d+)?(?<=\\d)$");
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

    public void errorMessage() {
        System.out.println("Sorry! You deposited too little money!" + " (minimum: " + minBalance + ")");
        System.out.println(" ");
        deposit();
    }

}
