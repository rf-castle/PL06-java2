import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Objects;


public class SimpleHTTPServer {

    private final int port;

    public SimpleHTTPServer(int port)
    {
        this.port = port;
    }

    public void start() {

        try {
            // Start a ServerSocker
            // wait for connection
            ServerSocket ss = new ServerSocket(port);
            while(true) {
                Socket s = null;
                try{
                    //Accept Incoming Requests
                    s = ss.accept();
                    // then send the corresponding socket to an instance of Handler
                    Handler handler = new Handler(s);
                    // and let it handle the request
                    handler.start();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                finally {
                    if (!Objects.isNull(s)){
                        s.close();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

class Handler {
    private final Socket connection;

    Handler(Socket connection) {
        this.connection = connection;
    }

    public void start() throws java.io.IOException {

        // Get InputStream and OutputStream from the socket.
        InputStream inputStream = this.connection.getInputStream();
        OutputStream outputStream = this.connection.getOutputStream();
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(inputStream));
        // 1. read the request from the client.
        String line = bufferedReader.readLine();
        // 2. if it is not starting by "GET" then ignore
        if(!line.startsWith("GET")){
            return;
        }
        // 3. otherwise, extract the file name from the request.
        // It will look like: "GET /filename.html HTTP/1.1"
        // You can split the string by whitespaces.
        String[] splited = line.split(" ");
        if(splited.length < 2){
            return;
        }
        String filename = splited[1].replace("/", "");
        if(Objects.equals(filename, "")){
            filename = "index.html";
        }
        // 4. open the file and reads its content
        File file = new File(filename); // to be initialized somewhere with the obtained filename
        byte[] content = {};
        String headerStr;
        try{
            content = Files.readAllBytes(file.toPath());
            headerStr = "HTTP/1.0 200 OK\r\n";

        }
        catch (NoSuchFileException e){
            headerStr = "HTTP/1.0 404 Not Found\r\n";
        }
        catch (Throwable e){
            headerStr = "HTTP/1.0 500 Internal Server Error\r\n";
            e.printStackTrace();
        }
        headerStr += "Server: SimpleHTTPServer\r\n"
                    + "Content-length: " + content.length + "\r\n"
                    + "Content-type: text/html"
                    + "; charset=utf-8" + "\r\n\r\n";

        // 5. create an HTTP header
        byte[] header = headerStr.getBytes(StandardCharsets.UTF_8);
        // 6. send the header then the content via the OutputStream
        outputStream.write(header);
        outputStream.write(content);
    }


    public static void main(String[] args) {
        final int DEFAULT_PORT = 8080;
        int port;
        try {
            port = Integer.parseInt(args[0]);
            if (port < 1024 || port > 65535){
                System.out.printf(
                    "given port %d is out of range(must be 1024 < port < 65535). set to default port 8080.%n",
                    port
                );
                port = DEFAULT_PORT;
            }
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            port = DEFAULT_PORT;
        }
        catch (NumberFormatException e){
            System.out.println("Usage: java SimpleHTTPServer [port]");
            System.exit(1);
            return;
        }

        SimpleHTTPServer server = new SimpleHTTPServer(port);
        server.start();
    }

}