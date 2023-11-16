package fi.utu.tech.assignment3;
import java.net.*;
import java.io.*;

public class ClientHandler extends Thread {
    private Socket s;
    private BufferedReader reader;


    public ClientHandler(Socket s) throws IOException{
        this.s = s;
        this.reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }
    @Override
    public void run(){
        try {
            String message = "";
            while((message = reader.readLine()) != null){
                System.out.println(message);


            }
            
        } catch (Exception e){

        }
    }
}
