import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client3 {
    public static void main(String[] args) {



        try(Socket server = new Socket("127.0.0.1", 1010)){
            Scanner scanner = new Scanner(System.in);
            try(Scanner read = new Scanner(server.getInputStream());
                PrintWriter write = new PrintWriter(server.getOutputStream(), true)){
                String messageFromServer = read.nextLine();

                System.out.println("Сообщение со стороны сервера: " + messageFromServer);

                while (true){
                    String yourMessage = scanner.nextLine();
                    write.println(yourMessage);
                }

            }


        }catch (Exception e){
            System.err.println("Ошибка подключения к серверу: " + e.getMessage());
        }


    }
}
