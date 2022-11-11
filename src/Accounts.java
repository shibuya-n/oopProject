import java.util.Scanner;

public class Accounts {
    public int balance;
    public String accountType;

    public Accounts(int balance, String accountType){
        this.balance = balance;
        this.accountType = accountType;

    }
    public void menu(){
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
    public void deposit(){
        System.out.println("-----DEPOSIT-----");
        Scanner depositAsk = new Scanner(System.in);
        System.out.println("How much money would you like to deposit?");
        int depositAmount = Integer.parseInt(String.valueOf(depositAsk.nextLine()));


    }


}
