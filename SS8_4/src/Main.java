public class Main {
    public static void main(String[] args) {
        // Khởi tạo tài khoản A
        BankAccount accountA = new BankAccount(
                "TK001",
                5_000_000,
                "Nguyễn Văn A",
                "0912345678"
        );

        // Khởi tạo tài khoản B
        BankAccount accountB = new BankAccount(
                "TK002",
                2_000_000,
                "Trần Thị B",
                "0987654321"
        );

        System.out.println("SỐ DƯ TRƯỚC KHI CHUYỂN TIỀN");

        accountA.displayBalance();
        accountB.displayBalance();

        // Chuyển 1.000.000 VNĐ từ A sang B
        double transferAmount = 1_000_000;

        transferMoney(accountA, accountB, transferAmount);

        System.out.println("\nSỐ DƯ SAU KHI CHUYỂN TIỀN");

        accountA.displayBalance();
        accountB.displayBalance();
    }

    public static void transferMoney(
            BankAccount sender,
            BankAccount receiver,
            double amount
    ) {
        System.out.println("\n--- THỰC HIỆN CHUYỂN TIỀN ---");

        if (amount <= 0) {
            System.out.println(
                    "Số tiền chuyển phải lớn hơn 0."
            );
            return;
        }

        if (sender.getBalance() < amount) {
            System.out.println(
                    "Chuyển tiền thất bại: số dư không đủ."
            );
            return;
        }

        sender.withdraw(amount);
        receiver.deposit(amount);

        System.out.printf(
                "Chuyển %,.2f VNĐ từ tài khoản %s sang tài khoản %s thành công.%n",
                amount,
                sender.getAccountId(),
                receiver.getAccountId()
        );
    }
}