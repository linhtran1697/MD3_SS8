public class BankAccount implements IBank {
    private String accountId;
    private double balance;
    private String userName;
    private String phoneNumber;

    // Constructor không tham số
    public BankAccount() {
    }

    // Constructor đầy đủ tham số
    public BankAccount(
            String accountId,
            double balance,
            String userName,
            String phoneNumber
    ) {
        this.accountId = accountId;
        this.userName = userName;
        this.phoneNumber = phoneNumber;

        if (balance >= 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
            System.out.println(
                    "Số dư ban đầu không hợp lệ, số dư được đặt thành 0."
            );
        }
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println(
                    "Số tiền nhận phải lớn hơn 0."
            );
            return;
        }

        balance += amount;

        System.out.printf(
                "Tài khoản %s đã nhận %,.2f VNĐ.%n",
                accountId,
                amount
        );
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println(
                    "Số tiền rút phải lớn hơn 0."
            );
            return;
        }

        if (amount > balance) {
            System.out.println(
                    "Số dư không đủ để thực hiện giao dịch."
            );
            return;
        }

        balance -= amount;

        System.out.printf(
                "Tài khoản %s đã rút %,.2f VNĐ.%n",
                accountId,
                amount
        );
    }

    public void displayBalance() {
        System.out.println("--------------------------------");
        System.out.println("Mã tài khoản: " + accountId);
        System.out.println("Tên người dùng: " + userName);
        System.out.println("Số điện thoại: " + phoneNumber);
        System.out.printf("Số dư: %,.2f VNĐ%n", balance);
    }

    // Getter và Setter
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
