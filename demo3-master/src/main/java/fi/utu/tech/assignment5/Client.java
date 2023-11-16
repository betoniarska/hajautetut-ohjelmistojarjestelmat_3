package fi.utu.tech.assignment5;


import javax.sql.rowset.serial.SQLInputImpl;
import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {


        String address = "localhost";


        try {
            Socket s = new Socket(address, 12345);

            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter writer = new PrintWriter(s.getOutputStream(), true);

            // testaillaan

            String m1 = "LIGHT;ON;2";
            String m2 = "LIGHT;OFF;1";
            String m3 = "LIGHT;QUERY";

            writer.println(m1);
            writer.println(m2);
            writer.println(m3);


            s.close();

        } catch (Exception e) {

        }
    }
}