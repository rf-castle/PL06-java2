
import java.rmi.RemoteException;

public class  CallbackServer {

    private String say(Callback callback, String lang, String content) throws RemoteException {
        String message;

        if(lang.equals("JAPANESE")) {
            message = callback.speakJapanese(content);
            System.out.println("In CallbackServer, " + message);
            return message;
        } else {
            message = callback.speakEnglish(content);
            System.out.println("In CallbackServer, " + message);
            return message;

        }
    }

     public String sayHello(Callback callback, String lang) throws RemoteException {
        return say(callback, lang, "Hello");
     }

    public String sayThanks(Callback callback, String lang) throws RemoteException {
        return say(callback, lang, "Thanks");
    }

}