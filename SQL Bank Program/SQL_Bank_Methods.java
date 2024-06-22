//used by SQL_Bank_Main.java
import java.util.*;
import java.io.*;
import java.sql.*;

class SQL_Bank_Methods {
    private ArrayList<Double> numbersArrayList;
    private int rowCount = 0;

    SQL_Bank_Methods(){ //constructor
        numbersArrayList = new ArrayList<Double>();

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bank?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "myuser", "xxxx");
            Statement stmt = conn.createStatement();)   
            {
                String strSelect = "SELECT * FROM transactions";      
                System.out.println("The SQL statement is: " + strSelect); // Echo For debugging
                ResultSet rset = stmt.executeQuery(strSelect);

                while(rset.next()) {  
                    double amount = rset.getDouble("amount");
                    
                    numbersArrayList.add(amount);

                    ++this.rowCount;
                }

                System.out.println("Total number of records = " + rowCount);
         
            } catch(SQLException ex) {
                ex.printStackTrace();
            } 

        System.out.println("Total transactions in history: " + numbersArrayList.size());
    }

    public void deposit(double depositAmount){ //deposit method
        numbersArrayList.add(depositAmount);
    }

    public boolean withdraw(double withdrawAmount){ //withdraw method
        if(getBalance() - withdrawAmount >= 0){
            numbersArrayList.add(-withdrawAmount);

            return true;
        }
        return false;
    }

    public double getBalance(){ //get balance
        double sum = 0;
        int size = numbersArrayList.size();

        for(int i = 0; i < size; i++){
            sum += numbersArrayList.get(i);
        }

        return Math.round(sum * 100.0)/100.0;
    }

    public void writeToSQL(){ //writes the array list to file
        try (Connection conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/bank?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
               "myuser", "xxxx");
            Statement stmt = conn.createStatement();) 
            {     
                int size = numbersArrayList.size();
                for(int i = this.rowCount; i < size; i++){
                    String sqlInsert = "INSERT INTO transactions values(" + numbersArrayList.get(i) + ")";
                    System.out.println("The SQL statement is: " + sqlInsert);  // Echo for debugging
                    int countInserted = stmt.executeUpdate(sqlInsert);
                    System.out.println(countInserted + " records inserted.");
                }
            } catch(SQLException ex) {
                ex.printStackTrace();
            } 
    }

    public void depositHistory(){ //deposit history
        int size = numbersArrayList.size();

        for(int i = 0; i < size; i++){
            if(numbersArrayList.get(i) > 0){
                System.out.println("Deposit of: $" + numbersArrayList.get(i));
            }
        }
    }

    public void withdrawalHistory(){ //withdraw history
        int size = numbersArrayList.size();

        for(int i = 0; i < size; i++){
            if(numbersArrayList.get(i) < 0){
                System.out.println("Withdraw of: $" + numbersArrayList.get(i));
            }
        }
    }
}