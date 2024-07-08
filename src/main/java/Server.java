import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {

        try(ServerSocket waitClient = new ServerSocket(1010)){

            while (true){


                System.out.println("Сервер запущен и ожидает клиента!");
                Socket accept = waitClient.accept();
                Connection connection = new Connection(accept);
                new Thread(connection).start();

            }

        }catch (Exception e){
            System.err.println("Ошибка работы сервера: " + e.getMessage());
        }

    }




}
