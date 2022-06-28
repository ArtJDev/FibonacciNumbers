import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 25000);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {
            String line;
            while (true) {
                System.out.println("Введите n-е число Фибоначчи");
                line = scanner.nextLine();
                out.println(line);
                if ("end".equals(line)) {
                    break;
                }
                System.out.println("SERVER: " + in.readLine());
            }
        }
    }
}
