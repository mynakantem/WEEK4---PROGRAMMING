import java.util.*;

class BankingSystem {
    private HashMap<String, Double> accounts = new HashMap<>();
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    static class WithdrawalRequest {
        String accountNumber;
        double amount;

        public WithdrawalRequest(String accountNumber, double amount) {
            this.accountNumber = accountNumber;
            this.amount = amount;
        }
    }

    public void addAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
    }

    public void requestWithdrawal(String accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("❌ Account not found: " + accountNumber);
            return;
        }
        withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
        System.out.println("✅ Withdrawal request added for " + accountNumber + ": ₹" + amount);
    }

    public void processWithdrawals() {
        System.out.println("\n🏦 Processing Withdrawals:");
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest req = withdrawalQueue.poll();
            double balance = accounts.get(req.accountNumber);

            if (balance >= req.amount) {
                accounts.put(req.accountNumber, balance - req.amount);
                System.out.println("✅ Withdrawal successful for " + req.accountNumber + ": ₹" + req.amount);
            } else {
                System.out.println("❌ Insufficient balance for " + req.accountNumber + ": Requested ₹" + req.amount + ", Available ₹" + balance);
            }
        }
    }

    public void displayAllAccounts() {
        System.out.println("\n📄 All Accounts:");
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            System.out.println("Account: " + entry.getKey() + " | Balance: ₹" + entry.getValue());
        }
    }

    public void displayAccountsSortedByBalance() {
        TreeMap<Double, List<String>> sorted = new TreeMap<>(Collections.reverseOrder()); // high to low

        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            double balance = entry.getValue();
            sorted.putIfAbsent(balance, new ArrayList<>());
            sorted.get(balance).add(entry.getKey());
        }

        System.out.println("\n💰 Accounts Sorted by Balance (High to Low):");
        for (Map.Entry<Double, List<String>> entry : sorted.entrySet()) {
            for (String acc : entry.getValue()) {
                System.out.println("Account: " + acc + " | Balance: ₹" + entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.addAccount("ACC001", 5000);
        bank.addAccount("ACC002", 8000);
        bank.addAccount("ACC003", 3000);

        bank.requestWithdrawal("ACC001", 2000);
        bank.requestWithdrawal("ACC002", 9000);
        bank.requestWithdrawal("ACC003", 1000);

        bank.processWithdrawals();

        bank.displayAllAccounts();

        bank.displayAccountsSortedByBalance();
    }
}
