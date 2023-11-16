package fi.utu.tech.assignment6;



import javax.sql.rowset.serial.SQLInputImpl;
import java.io.*;
import java.net.Socket;
import java.util.Random;


public class Client {

    public static void main(String[] args) {

        String address = "localhost";
        Random r = new Random();

        try {
            Socket s = new Socket(address, 12345);

            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter writer = new PrintWriter(s.getOutputStream(), true);

            boolean j = false;
            int test = 0;


            for (int i = 0; i < 100000; i++){

                test = r.nextInt(5);
                j = r.nextBoolean();

                String text = "";
                if (j){
                    text = "LIGHT;ON;" + test;
                } else {
                    text = "LIGHT;OFF;" + test;
                }


                writer.println(text);
            }


            s.close();

        } catch (Exception e) {

        }
    }
}
