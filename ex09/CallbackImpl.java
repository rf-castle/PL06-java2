import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;

public class CallbackImpl extends UnicastRemoteObject implements Callback {

    public CallbackImpl() throws RemoteException {
        super();
    }

    public String greeting(String lang) throws RemoteException {
        CallbackServer server = new CallbackServer();
        return server.sayHello(this, lang);
    }

    @Override
    public String thanks(String lang) throws RemoteException {
        CallbackServer server = new CallbackServer();
        return server.sayThanks(this, lang);
    }


    public String speakJapanese(String content){
        switch (content){
            case "Hello":
                return "Konnichiwa!";
            case "Thanks":
                return "Arigatou gozaimasu!";
            default:
                return "";
        }
    }
    public String speakEnglish(String content){
        switch (content){
            case "Hello":
                return "How are you!";
            case "Thanks":
                return "Thank you!";
            default:
                return "";
        }
    }

    public static void main(String[] args) {

        // Create and install a security manager 
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            CallbackImpl obj = new CallbackImpl();
            // Bind this object instance to the name "MyCallbackServer"
            Naming.rebind("MyCallbackServer", obj);
            System.out.println("MyCallbackServer bound in registry");
        } catch (Exception e) {
            System.out.println("CallbackImpl err: " + e.getMessage());
            e.printStackTrace();
        }
    }
}