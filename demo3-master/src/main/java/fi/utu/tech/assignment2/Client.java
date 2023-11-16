package fi.utu.tech.assignment2;

import javax.sql.rowset.serial.SQLInputImpl;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {


        String address = "localhost";
        try (Socket s = new Socket(address, 12345);){


            InputStream input = s.getInputStream();
            OutputStream output = s.getOutputStream();

            String message = "Hello";
            output.write(message.getBytes());

            s.close();


        } catch (Exception e){

        }


    }

}
