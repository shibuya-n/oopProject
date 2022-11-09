import java.util.*;

public class oopProject {
    public static void main(String[] args){
        ask();
    }

    public static void ask(){
            System.out.println("[WELCOME TO BaNK]");
            Scanner scannerObject = new Scanner(System.in);
            System.out.println("[What kind of account would you like to make?] (CHECKING/SAVINGS/EXIT)");
            String userAnswer = scannerObject.nextLine().trim().toLowerCase();

            if (userAnswer.equals("checking")){
                System.out.println("Checking");
            }

            else if (userAnswer.equals("savings")){
                System.out.println("Savings");
            }

            else if (userAnswer.equals("exit")){
                System.out.println("Thank you for banking with BaNK");
                System.exit(0);
            }
            else {
                System.out.print("[ERROR. PLEASE TRY AGAIN]");
                ask();
            }
        }


    }


