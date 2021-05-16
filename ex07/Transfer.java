import java.util.Random;
// TODO COMPLETE
//
// "Transfer" threads select a random amount of money in [0, max_amount]
// and transfer it to a random account in the bank.
//

public class Transfer extends Thread {
    private final Bank bank;
    private final int from;
    private final int max;
    public Transfer(Bank bank, int from, int max_amount) {
        this.bank = bank;
        this.from = from;
        this.max = max_amount;
    }

    @Override
    public void run() {
        Random random = new Random();
        int amount = random.nextInt(this.max + 1);
        int to = this.from;
        while(from == to){
            to = random.nextInt(this.bank.getNumberAccounts());
        }
        this.bank.transfer(this.from, to, amount);
    }
}
