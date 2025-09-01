public class TestAccount {
    public static void main(String[] args) {
        // Create Account with id=1122 and balance=20000
        Account account = new Account(1122, 20000);
        account.setAnnualInterestRate(4.5);

        // Withdraw $2,500
        account.withdraw(2500);

        // Deposit $3,000
        account.deposit(3000);

        // Print results
        System.out.println("Balance: $" + account.getBalance());
        System.out.println("Monthly Interest: $" + account.getMonthlyInterest());
        System.out.println("Date Created: " + account.getDateCreated());
    }
}
