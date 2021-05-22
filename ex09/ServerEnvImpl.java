import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerEnvImpl
        extends UnicastRemoteObject
        implements ServerEnv {

    public ServerEnvImpl() throws RemoteException {
        super();
    }

    public static void main(String[] args) {

        // Create and install a security manager
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            ServerEnvImpl obj = new ServerEnvImpl();
            // Bind this object instance to the name "HelloServer"
            // RMI uses 1099 as a default port
            Naming.rebind("//localhost/ServerEnvServer", obj);
            System.out.println("HelloServer bound in registry");
        } catch (Exception e) {
            System.out.println("HelloImpl err: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public String getOS() throws RemoteException {
        try {
            return String.format(
                    "Server Env: OS of %s is %s",
                    InetAddress.getLocalHost().getHostName(),
                    System.getProperty("os.name")
            );
        } catch (UnknownHostException e) {
            e.printStackTrace();
            throw new RemoteException(e.getMessage());
        }
    }
}
