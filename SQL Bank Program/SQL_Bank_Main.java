//driver program for SQL_Bank_Methods.java
import java.util.*;
import java.lang.Math;

public class SQL_Bank_Main {
    public static void main(String[] args) {
        SQL_Bank_Methods bankAccount = new SQL_Bank_Methods();
        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            System.out.println();
            System.out.println("***** Menu *****");

            System.out.println("1. Make a deposit.");
            System.out.println("2. Make a withdrawal.");
            System.out.println("3. To view balance.");
            System.out.println("4. To view deposit history.");
            System.out.println("5. To view withdrawal history.");
            System.out.println("6. To view all deposits and withdrawals.");
            System.out.println("E. Exit");
            System.out.print("Choose an option. (note, your response will be truncated to 1 digit input): ");

            choice = scanner.next().charAt(0);
            System.out.println();

            switch (choice) { //switch case for deposit, withdraw, balance, and exit
                case '1': { //Deposit choice
                    double depositUSD = 0;
                    boolean notValidDeposit = true;

                    do { //do while that waits for correct deposit amount
                        try {
                            System.out.println();
                            System.out.print("Deposit amount: $");
                            depositUSD = Double.parseDouble(scanner.next());

                            bankAccount.deposit(depositUSD);
                            System.out.println("Depost done.");
                            System.out.println("New balance: $" + bankAccount.getBalance());
                            notValidDeposit = false;
                        } catch (Exception e) {
                            System.out.println("Wrong input given.");
                        }  
                    } while(notValidDeposit);    

                    break;
                }

                case '2': { //Withdraw choice
                    double withdrawUSD = 0;
                    boolean notValidWithdraw = true;

                    do { //do while statement that waits for correct withdrawal amount
                        try {
                            System.out.println();
                            System.out.print("How much do you want to withdraw?: $");
                            withdrawUSD = Double.parseDouble(scanner.next());

                            boolean canWithdraw = bankAccount.withdraw(withdrawUSD);

                            if (canWithdraw) { //if else statement that checks for correct withdrawal amount
                                System.out.println("Withdrawal done.");
                                System.out.println("New balance: $" + bankAccount.getBalance());
                            } else {
                                System.out.println("Insufficient funds.");
                            }

                            notValidWithdraw = false;
                        } catch (Exception e) {
                            System.out.println("Wrong input given.");
                        }
                    } while(notValidWithdraw);  

                    break;
                }

                case '3': //Balance choice
                    System.out.println("Your account balance is: $" + bankAccount.getBalance());
                    break;

                case '4': //Deposit history
                    System.out.println("Here is the deposit history:\n");
                    bankAccount.depositHistory();
                    break;

                case '5': //Withdrawal history
                    System.out.println("Here is the withdrawal history:\n");
                    bankAccount.withdrawalHistory();
                    break;

                case '6': //All deposit/withdrawal history
                    System.out.println("Here is the deposit history:\n");
                    bankAccount.depositHistory();

                    System.out.println("\nHere is the withdrawal history:\n");
                    bankAccount.withdrawalHistory();

                    break;
                    
                case 'E': //Exit choice 
                    bankAccount.writeToSQL();
                    System.out.println("History updated. Balance is: $" + bankAccount.getBalance());
                    break;

                default:
                    System.out.println("Please use one of the options such as: '1' or '2' or '3' or 'E'");
                    break;
            }

        } while('E' != choice); //while not choosing to exit program, repeat menu loop
    }
}