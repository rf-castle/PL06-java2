import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Callback extends Remote {
    String speakJapanese(String s) throws RemoteException;
    String speakEnglish(String s) throws RemoteException;
    String greeting(String s) throws RemoteException;
    String thanks(String s) throws RemoteException;
} 