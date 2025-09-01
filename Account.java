import java.util.Date;

public class Account {
    // Data fields
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;  // In percentage
    private Date dateCreated;

    // No-arg constructor
    public Account() {
        dateCreated = new Date();
    }

    // Constructor with id and initial balance
    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        dateCreated = new Date();
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    // Monthly interest rate
    public double getMonthlyInterestRate() {
        return (annualInterestRate / 100) / 12;
    }

    // Monthly interest earned
    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }

    // Withdraw
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    // Deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
}