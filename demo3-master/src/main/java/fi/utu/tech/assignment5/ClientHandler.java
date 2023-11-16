package fi.utu.tech.assignment5;
import java.net.*;
import java.io.*;

public class ClientHandler extends Thread {
    private Socket s;
    private BufferedReader reader;
    private PrintWriter writer;
    public ClientHandler(Socket s) throws IOException{
        this.s = s;
        this.reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        this.writer = new PrintWriter(s.getOutputStream(), true);

    }
    @Override
    public void run(){
        try {
            String message = "";
            while((message = reader.readLine()) != null){
                String[] parts = message.split(";");
                String msg = "";
                if (parts[1].equals("ON") && parts.length == 3){
                    System.out.println("Kytketään lamppu " + parts[2] + " PÄÄLLE");
                } else if (parts[1].equals("OFF") && parts.length == 3){
                    System.out.println("Kytketään lamppu " + parts[2] + " POIS");
                } else {
                    System.out.println("Kyselykomento vastaanotettu");
                }
            }

        } catch (Exception e){

        }
    }
}

