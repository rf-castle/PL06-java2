import java.rmi.Naming;

public class ServerEnvClient {

    public static void main(String[] args) {

        // "obj" is the identifier that we'll use to refer
        // to the remote object that implements the "Hello"
        // interface
        ServerEnv obj;

        try {
            obj = (ServerEnv)Naming.lookup("//" + "/ServerEnvServer");
            String message = obj.getOS();
            System.out.println(message);
        } catch (Exception e) {
            System.out.println("ServerEnvClient exception: " +
                    e.getMessage());
            e.printStackTrace();
        }
    } // end of main
} // end of HelloClient
