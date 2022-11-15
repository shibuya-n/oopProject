import java.util.Scanner;

public class checkingAccount extends Accounts{

    public checkingAccount(int balance){
        super(balance);
        minBalance = 20;

    }
    public static void menu(){
        Scanner scannerObject = new Scanner(System.in);
        System.out.println("WELCOME! LET'S GET STARTED.");
        System.out.println("What would you like to do? (deposit/exit)");
        String userAnswer = scannerObject.nextLine().trim().toLowerCase();

        if (userAnswer.equals("deposit")) {
            deposit();
        }
        else if (userAnswer.equals("exit")) {
            oopProject.ask();
        }
        else {
            System.out.println("[ERROR. PLEASE TRY AGAIN]");
        }
    }
    public static void deposit(){
        checkingAccount depositTest = new checkingAccount(minBalance);
        System.out.println("-----DEPOSIT-----");
        Scanner depositAsk = new Scanner(System.in);
        System.out.println("How much money would you like to deposit?" + " (minimum: " + minBalance + ")");
        int depositAmount = Integer.parseInt(String.valueOf(depositAsk.nextLine()));
        checkingAccount obj = new checkingAccount(depositAmount);


        if (depositAmount < minBalance) {
            System.out.println("Sorry! You deposited too little money!" + " (minimum: " + minBalance + ")");
            deposit();
        }
        else {
            checkingList.add(obj);
        }

    }
}
