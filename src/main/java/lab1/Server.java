package lab1;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;

public class Server extends Thread {

  ServerSocket serverSocket;

  public Server() {
    try {
      serverSocket = new ServerSocket(1500);
      System.out.println("Starting the server");
      start();

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void run() {
    ObjectOutputStream out = null;
    try {
      Socket clientSocket = serverSocket.accept();
      System.out.println(
          "Connection accepted from " + clientSocket.getInetAddress().getHostAddress());
      out = new ObjectOutputStream(
          clientSocket.getOutputStream());

      DateAndTime dateAndTime = new DateAndTime(LocalDate.now(), LocalTime.now());
      out.writeObject(dateAndTime);
      out.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      try {
        assert out != null;
        out.close();
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  public static void main(String[] args) {
    new Server();
  }
}
