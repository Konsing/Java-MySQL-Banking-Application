# Java MySQL Banking Application

## Project Overview
This project demonstrates a simple banking application using Java and MySQL. The project includes connecting to a MySQL database, performing basic CRUD (Create, Read, Update, Delete) operations, and running the application using a MySQL server and client.

## Files in the Repository
- **SQL_Bank_Main.java**: Main class for the banking application.
- **SQL_Bank_Methods.java**: Class containing methods for database operations.
- **JdbcInsertTest.java**: Test class for inserting data into the database.
- **JdbcSelectTest.java**: Test class for selecting data from the database.
- **JdbcUpdateTest.java**: Test class for updating data in the database.
- **long command.txt**: Instructions for running the project.
- **Launch Database.jpg**: Screenshot showing how to launch the MySQL database server.
- **Launch Client.jpg**: Screenshot showing how to launch the MySQL client.

## How to Use

### Prerequisites
- Java Development Kit (JDK)
- MySQL Server
- MySQL Connector/J (JDBC driver for MySQL)

### Setting Up MySQL Server and Client

1. **Launch MySQL Database Server**:
   Open a new CMD shell and navigate to MySQL's binary directory. Start the MySQL database server.
   ```sh
   cd c:\myWebProject\mysql\bin
   mysqld --console
   ```

2. **Launch MySQL Client**:
   Open another CMD shell, navigate to MySQL's binary directory, and start the MySQL client as the root user.
   ```sh
   cd c:\myWebProject\mysql\bin
   mysql -u root -p
   ```
   Enter the root password when prompted.

### Setting Up the Java Application

1. **Compile Java Files**:
   Compile the Java source files. Open a new CMD window and navigate to the location of your Java files.
   ```sh
   javac SQL_Bank_Main.java SQL_Bank_Methods.java JdbcInsertTest.java JdbcSelectTest.java JdbcUpdateTest.java
   ```

2. **Run the Java Application**:
   Run the Java application using the following command. Make sure to include the path to the MySQL Connector/J jar file.
   ```sh
   java -cp .;C:\users\manyu\Desktop\School\myWebProject\mysql-connector-java-8.0.28\mysql-connector-java-8.0.28.jar SQL_Bank_Main
   ```

### Running Tests

1. **Insert Test**:
   Run the JdbcInsertTest class to insert data into the database.
   ```sh
   java -cp .;C:\users\manyu\Desktop\School\myWebProject\mysql-connector-java-8.0.28\mysql-connector-java-8.0.28.jar JdbcInsertTest
   ```

2. **Select Test**:
   Run the JdbcSelectTest class to select data from the database.
   ```sh
   java -cp .;C:\users\manyu\Desktop\School\myWebProject\mysql-connector-java-8.0.28\mysql-connector-java-8.0.28.jar JdbcSelectTest
   ```

3. **Update Test**:
   Run the JdbcUpdateTest class to update data in the database.
   ```sh
   java -cp .;C:\users\manyu\Desktop\School\myWebProject\mysql-connector-java-8.0.28\mysql-connector-java-8.0.28.jar JdbcUpdateTest
   ```

### Long Command
Refer to the `long command.txt` file for a detailed command sequence to run the project.

```sh
cd Desktop/CIS 36B/Connect4 Final
java -cp .;C:\users\manyu\Desktop\School\myWebProject\mysql-connector-java-8.0.28\mysql-connector-java-8.0.28.jar Connect4
cd Desktop/myWebProject/mysql/bin/
```

## Screenshots
- **Launch Database**:
  ![Launch Database](Launch%20Database.jpg)

- **Launch Client**:
  ![Launch Client](Launch%20Client.jpg)

## Conclusion
This project provides a basic framework for a banking application using Java and MySQL. By following the steps outlined, users can set up their environment, run the application, and perform basic database operations.

If you have any questions or encounter any issues, please feel free to reach out for further assistance.