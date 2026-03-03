
public class BankAccount {
    private final String accountNumber;
    private double balance = 0;
    private String ownerName;
    
    BankAccount(String a, String c) {
        accountNumber = a;
        ownerName = c;
        balance = 0;
    }

    BankAccount(String a, double b, String c) {
        accountNumber = a;
        if (b < 0) {
            balance = 0;
            System.out.println("Lỗi: Số dư không hợp lệ");
        }
        else
            balance = b;
        ownerName = c;
    }

    public void deposit(double amount) {
        if (amount > 0)
            balance += amount;
        else
            System.out.println("Số tiền nạp phải > 0");
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void getBalance() {
        System.out.println(balance);
    }
    
    public static void main(String[] args) {
        BankAccount Long = new BankAccount(("208207"), 1000000, "NGUYEN KIM LE LONG");
        Long.deposit(-300000);
        Long.deposit(300000);
        Long.withdraw(2000000);
        Long.getBalance();
        Long.withdraw(1000000);
        Long.getBalance();
    }

}
