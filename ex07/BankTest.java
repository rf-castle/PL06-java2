import java.util.Random;

public class BankTest {
    public static final int N_ACCOUNTS = 5;
    public static final int INIT_BALANCE = 1000;


    public static void main(String[] args) {
        Random random = new Random();
        Bank bank = new Bank(N_ACCOUNTS, INIT_BALANCE);
        for (int i = 0; i < 100; i++) {
            Thread thread = new Transfer(
                    bank,
                    random.nextInt(N_ACCOUNTS),
                    1000
            );
            thread.start();
        }

    }
}
