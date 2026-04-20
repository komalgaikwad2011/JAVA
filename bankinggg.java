package banking;
import java.sql.*;
import java.util.Scanner;

    			public class bankinggg {
    			    // Database credentials
    			   
    			    public static void main(String[] args) {
    			        Scanner sc = new Scanner(System.in);
    			        try (    			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb","root","");
) {
    			            while (true) {
    			                System.out.println("\n--- BANKING SYSTEM MENU ---");
    			                System.out.println("1. Create Account\n2. Deposit\n3. Withdraw\n4. Check Balance\n5. Display Account Info\n6. Exit");
    			                System.out.print("Select an option: ");
    			                int choice = sc.nextInt();

    			                switch (choice) {
    			                    case 1: createAccount(conn, sc); break;
    			                    case 2: deposit(conn, sc); break;
    			                    case 3: withdraw(conn, sc); break;
    			                    case 4: checkBalance(conn, sc); break;
    			                    case 5: displayInfo(conn, sc); break;
    			                    case 6: System.exit(0);
    			                    default: System.out.println("Invalid choice!");
    			                }
    			            }
    			        } catch (Exception e) {
    			            e.printStackTrace();
    			        }
    			    }

    			    // a. Create an account
    			    private static void createAccount(Connection conn, Scanner sc) throws SQLException {
    			        System.out.print("Enter Holder Name: ");
    			        sc.nextLine(); // consume newline
    			        String name = sc.nextLine();
    			        System.out.print("Enter Initial Deposit: ");
    			        double bal = sc.nextDouble();
    			        
    			        String sql = "INSERT INTO accounts (holder_name, balance) VALUES (?, ?)";
    			        PreparedStatement pstmt = conn.prepareStatement(sql);
    			        pstmt.setString(1, name);
    			        pstmt.setDouble(2, bal);
    			        pstmt.executeUpdate();
    			        System.out.println("Account created successfully!");
    			    }

    			    // b. Deposit money
    			    private static void deposit(Connection conn, Scanner sc) throws SQLException {
    			        System.out.print("Enter Account Number: ");
    			        int accNo = sc.nextInt();
    			        System.out.print("Enter Amount to Deposit: ");
    			        double amt = sc.nextDouble();

    			        String sql = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";
    			        PreparedStatement pstmt = conn.prepareStatement(sql);
    			        pstmt.setDouble(1, amt);
    			        pstmt.setInt(2, accNo);
    			        if (pstmt.executeUpdate() > 0) System.out.println("Deposit Successful!");
    			    }

    			    // c & d. Withdraw money & Honor daily limit
    			    private static void withdraw(Connection conn, Scanner sc) throws SQLException {
    			        System.out.print("Enter Account Number: ");
    			        int accNo = sc.nextInt();
    			        System.out.print("Enter Amount to Withdraw: ");
    			        double amt = sc.nextDouble();

    			        // Check daily limit and balance first
    			        String checkSql = "SELECT balance, daily_limit, withdrawn_today FROM accounts WHERE account_number = ?";
    			        PreparedStatement checkStmt = conn.prepareStatement(checkSql);
    			        checkStmt.setInt(1, accNo);
    			        ResultSet rs = checkStmt.executeQuery();

    			        if (rs.next()) {
    			            double currentBal = rs.getDouble("balance");
    			            double limit = rs.getDouble("daily_limit");
    			            double spent = rs.getDouble("withdrawn_today");

    			            if (amt > currentBal) {
    			                System.out.println("Insufficient Balance!");
    			            } else if ((spent + amt) > limit) {
    			                System.out.println("Withdrawal denied! Exceeds Daily Limit of " + limit);
    			            } else {
    			                String sql = "UPDATE accounts SET balance = balance - ?, withdrawn_today = withdrawn_today + ? WHERE account_number = ?";
    			                PreparedStatement pstmt = conn.prepareStatement(sql);
    			                pstmt.setDouble(1, amt);
    			                pstmt.setDouble(2, amt);
    			                pstmt.setInt(3, accNo);
    			                pstmt.executeUpdate();
    			                System.out.println("Withdrawal Successful!");
    			            }
    			        }
    			    }

    			    // e. Check the balance
    			    private static void checkBalance(Connection conn, Scanner sc) throws SQLException {
    			        System.out.print("Enter Account Number: ");
    			        int accNo = sc.nextInt();
    			        String sql = "SELECT balance FROM accounts WHERE account_number = ?";
    			        PreparedStatement pstmt = conn.prepareStatement(sql);
    			        pstmt.setInt(1, accNo);
    			        ResultSet rs = pstmt.executeQuery();
    			        if (rs.next()) System.out.println("Current Balance: " + rs.getDouble("balance"));
    			    }

    			    // f. Display Account information
    			    private static void displayInfo(Connection conn, Scanner sc) throws SQLException {
    			        System.out.print("Enter Account Number: ");
    			        int accNo = sc.nextInt();
    			        String sql = "SELECT * FROM accounts WHERE account_number = ?";
    			        PreparedStatement pstmt = conn.prepareStatement(sql);
    			        pstmt.setInt(1, accNo);
    			        ResultSet rs = pstmt.executeQuery();
    			        if (rs.next()) {
    			            System.out.println("\n--- Account Details ---");
    			            System.out.println("ID: " + rs.getInt("account_number"));
    			            System.out.println("Name: " + rs.getString("holder_name"));
    			            System.out.println("Balance: " + rs.getDouble("balance"));
    			            System.out.println("Daily Limit: " + rs.getDouble("daily_limit"));
    			            System.out.println("Today's Spent: " + rs.getDouble("withdrawn_today"));
    			        } else {
    			            System.out.println("Account not found.");
    			        }
    			    }
    			}