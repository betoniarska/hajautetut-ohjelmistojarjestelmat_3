package fi.utu.tech.assignment1;

import javax.sql.rowset.serial.SQLInputImpl;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        // TODO: Asiakasohjelma

        String address = "localhost";
        try{
            Socket s = new Socket(address, 12345);

        } catch (Exception e){

        }


    }

}
