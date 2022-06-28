import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket servSocket = new ServerSocket(25000);

        while (true) {
            try (Socket socket = servSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String line;
                while ((line = in.readLine()) != null) {
                    int num = fibNumber(Integer.parseInt(line));
                    out.println(num);
                    if (line.equals("end")) {
                        break;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    private static int fibNumber(int n) {
        if (n <= 2) {
            return 1;
        } else {
            return fibNumber(n - 1) + fibNumber(n - 2);
        }
    }
}