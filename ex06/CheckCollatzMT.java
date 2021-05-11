import java.math.BigInteger;
import java.util.Date;


// The implementation of CheckCollatz.check() will be extremely slow
// if we try very large values for n.
// It is actually easy to share the computation on multiple threads,
// by spawning as many threads as cores and running the checks
// for an interval [lower, upper] on 1 core.
//
public class CheckCollatzMT {

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

    }
}