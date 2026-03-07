## Đoạn mã
````java 
public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance = 0.0;

    public void openAccount(String accNum, String owner) {
        this.accountNumber = accNum;
        this.ownerName = owner;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public boolean withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount();
        myAccount.openAccount("101202303", "Nguyen Van A");
        myAccount.deposit(500.0);
        myAccount.withdraw(150.0);
    }
````
## 1. Trạng thái (State)

```java
private String accountNumber;
private String ownerName;
private double balance = 0.0;
```

Trạng thái của đối tượng gồm:

- `accountNumber`
- `ownerName`
- `balance`

---

## 2. Hành vi (Behavior)


```java
public void openAccount(String accNum, String owner)
public void deposit(double amount)
public boolean withdraw(double amount)
```

Trong đó:

- `openAccount()` → mở tài khoản
- `deposit()` → nạp tiền
- `withdraw()` → rút tiền

---

## 3. Định danh (Identity)

```java
BankAccount myAccount = new BankAccount();
```

Định danh của đối tượng là:

```
myAccount
```

---


# Phân tích Object – SmartFan

```java
public class SmartFan {

    // ===== 1. TRẠNG THÁI (STATE) =====
    private String brand = "Xiaomi";
    private boolean isPowerOn = false;
    private int speedLevel = 0;

    // ===== 2. HÀNH VI (BEHAVIOR) =====
    public void turnOn() {
        this.isPowerOn = true;
    }

    public void turnOff() {
        this.isPowerOn = false;
        this.speedLevel = 0;
    }

    public void setSpeed(int newSpeed) {
        if (this.isPowerOn == true) {
            this.speedLevel = newSpeed;
        }
    }

    public static void main(String[] args) {

        // ===== 3. ĐỊNH DANH (IDENTITY) =====
        SmartFan livingRoomFan = new SmartFan();
        SmartFan bedroomFan = new SmartFan();
    }
}
```

---