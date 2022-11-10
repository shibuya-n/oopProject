import java.util.Scanner;

public class Accounts {
    public int balance;
    public String accountType;

    public Accounts(int balance, String accountType){
        this.balance = balance;
        this.accountType = accountType;

    }
    public static void menu(){
        Scanner scannerObject = new Scanner(System.in);
        System.out.println("[What kind of account would you like to make?] (CHECKING/SAVINGS/EXIT)");
        String userAnswer = scannerObject.nextLine().trim().toLowerCase();

        oopProject.exit();
        if (userAnswer.equals("checking")){
            System.out.println("Checking");
        }

        else if (userAnswer.equals("savings")){
            System.out.println("Savings");
        }
        else {
            System.out.print("[ERROR. PLEASE TRY AGAIN]");
            menu();
        }
    }
    public static void deposit(){

    }


}
