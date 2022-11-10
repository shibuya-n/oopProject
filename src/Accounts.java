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
        System.out.println("WELCOME! LETS GET STARTED.");
        System.out.println("How much money would you like to deposit?");
        int userAnswer = Integer.parseInt(String.valueOf(scannerObject.nextLine()));

        oopProject.exit();


    }
    public static void deposit(){

    }


}
