import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Connection implements Runnable{

    private Socket accept;

    public Connection(Socket accept) {
        this.accept = accept;
    }

    @Override
    public void run() {
        System.out.println("Подключен новый клиент");

        try(Scanner read = new Scanner(accept.getInputStream());
            PrintWriter write = new PrintWriter(accept.getOutputStream(), true)){
            System.out.println("Новый клиент подключился к серверу");
            write.println("Вы подключились к серверу");

            while (true){
                String messageFromClient = read.nextLine();
                System.out.println("Сообщение от клиента: " + messageFromClient);
                if("exit".equals(messageFromClient)){
                    System.out.println("Клиент отключился");
                    break;
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
