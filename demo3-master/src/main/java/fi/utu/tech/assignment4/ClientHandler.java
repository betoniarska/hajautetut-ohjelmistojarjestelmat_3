package fi.utu.tech.assignment4;
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
                if (message.equals("Hello")){
                    writer.println("Ack");
                    writer.flush();

                } else if (message.equals("quit")){
                    s.close();
                }


            }

        } catch (Exception e){

        }
    }
}

