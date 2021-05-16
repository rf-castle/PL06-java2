import java.util.Arrays;

public class Bank {
    private final int[] accounts;
    private final int num_accounts;
    public Bank(int num_accounts, int init_balance) {
        accounts = new int[num_accounts];
        this.num_accounts = num_accounts;
        Arrays.fill(accounts, init_balance);
    }

    synchronized void transfer(int from, int to, int amount) {
        try {
            System.out.printf(
                    "from: %d to: %d amount: %d%n",
                    from, to, amount
            );
            if (accounts[from] < amount) {
                return;
            }
            accounts[from] -= amount;
            Thread.sleep((int)(100 * Math.random()));
            accounts[to] += amount;
            System.out.println("Total balance: " + totalBalance());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int totalBalance() {
        int total = 0;
        for (int v : accounts) {
            total = total + v;
        }
        return total;
    }

    public int getNumberAccounts() {
        return num_accounts;
    }
}
