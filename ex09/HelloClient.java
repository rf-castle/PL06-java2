import java.rmi.Naming;

public class HelloClient {

    public static void main(String[] args) {
        String message = "Hello: This is my test meaage";

        // "obj" is the identifier that we'll use to refer
        // to the remote object that implements the "Hello"
        // interface
        Hello obj;

        try {
            obj = (Hello) Naming.lookup("//" + "/HelloServer");
            message = obj.sayHello();
        } catch (Exception e) {
            System.out.println("HelloClient exception: " +
                    e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Message = " + message);
    } // end of main
} // end of HelloClient
