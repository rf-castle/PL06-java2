import java.math.BigInteger;
import java.util.ArrayList;


// The implementation of CheckCollatz.check() will be extremely slow
// if we try very large values for n.
// It is actually easy to share the computation on multiple threads,
// by spawning as many threads as cores and running the checks
// for an interval [lower, upper] on 1 core.
//
public class CheckCollatzMT extends Thread{
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage:");
            System.out.println("java CheckCollatzMT n num_threads");
            System.out.println("where positive integers i: 1<= i <= n will be checked");
            System.out.println("and num_threads is the number of threads to use");
            System.exit(1);
        }

        // TODO complete
        // Spawn num_threads,
        // each of them will verify the conjecture for i in [lower, upper]
        // where lower and upper are determined such that each thread has
        // approximately the same amount of work to perform.
        //
        BigInteger n = new BigInteger(args[0]);
        int num_threads = Integer.parseInt(args[1]);
        if(num_threads < 1){
            System.out.println("num_threads must be 1 or more");
            System.exit(2);
        }
        ArrayList<CheckCollatzThreads> threads = new ArrayList<>();
        BigInteger[] tmp = n.divideAndRemainder(BigInteger.valueOf(num_threads));
        BigInteger count = tmp[0];
        BigInteger mod = tmp[1];
        BigInteger lower = BigInteger.ONE;
        BigInteger upper = count;
        for (int i = 0; i < num_threads; i++) {
            if(mod.compareTo(BigInteger.valueOf(i)) > 0){
                upper = upper.add(BigInteger.ONE);
            }
            CheckCollatzThreads thread = new CheckCollatzThreads(lower, upper);
            thread.start();
            threads.add(thread);
            lower = upper.add(BigInteger.ONE);
            upper = upper.add(count);
        }
        for(CheckCollatzThreads thread: threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Thread is Interrupted!");
                e.printStackTrace();
                System.exit(3);
            }
            if (!thread.getResult()){
                System.out.println("The conjecture is not valid");
                return;
            }
        }
        System.out.println("The conjecture seems valid up to n=" + args[0]);
    }
}

class CheckCollatzThreads extends Thread{
    final private BigInteger lower;
    final private BigInteger upper;
    private Boolean result;
    CheckCollatzThreads(BigInteger lower, BigInteger upper){
        this.lower = lower;
        this.upper = upper;
    }

    public Boolean getResult(){
        return this.result;
    }

    @Override
    public void run() {
        BigInteger i = this.lower;
        while (i.compareTo(upper) <= 0){
            Result result = Collatz.check(upper);
            if(!result.valid){
                this.result = false;
                return;
            }
            i = i.add(BigInteger.ONE);
        }
        this.result = true;
    }
}