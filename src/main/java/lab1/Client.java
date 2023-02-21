package lab1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Client {


  public static void main(String[] args) {

    Socket clientSocket = null;
    ObjectInputStream in = null;
    try {
      clientSocket = new Socket("localhost", 1500);
      in = new ObjectInputStream(clientSocket.getInputStream());
      DateAndTime dateAndTime = (DateAndTime) in.readObject();
      System.out.println("LocalDate = " + dateAndTime.getLocalDate());
      System.out.println("LocalTime = " + dateAndTime.getLocalTime());
    } catch (IOException | ClassNotFoundException ex) {
      throw new RuntimeException(ex);
    } finally {
      try {
        assert in != null;
        in.close();
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }
      try {
        clientSocket.close();
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }
    }
  }
}

