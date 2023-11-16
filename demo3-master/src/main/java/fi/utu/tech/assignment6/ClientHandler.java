package fi.utu.tech.assignment6;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {

    Socket s;
    Hub hub;
    private BufferedReader reader;
    private PrintWriter writer;
    public ClientHandler(Socket s, Hub hub) throws IOException {
        this.s = s;
        this.hub = hub;
        this.reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        this.writer = new PrintWriter(s.getOutputStream(), true);

    }
    @Override
    public void run(){
        try {
            String message = "";
            while((message = reader.readLine()) != null){
                String[] parts = message.split(";");

                if (parts[1].equals("ON")){
                    hub.turnOnLight(Integer.parseInt(parts[2]));
                } else if (parts[1].equals("OFF")){
                    hub.turnOffLight(Integer.parseInt(parts[2]));
                } else if (parts[1].equals("QUERY")){
                    String text = "";

                    for (Light light : hub.getLights()){
                        if (light.isPowerOn()){
                            text += light.getId() + ":ON;";
                        } else {
                            text += light.getId() + ":OFF;";
                        }
                    }

                }
            }
        } catch (Exception e){

        }
    }
}
