/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientserverproj;

/**
 *
 * @author dell
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class Client
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        try
        {
            //1.create socket and connect to the server
            //with IP:127.0.0.1(localhost)
            //and with portnumber: 1234
            Socket s = new Socket("127.0.0.1", 1234);
            //2. Create I/O streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            
            //3.perform IO with server 
            while (true)
            {
                //a. receive server command & print to user
                String srvr_msg = dis.readUTF();                
                if(srvr_msg.equals("bye"))
                {
                    System.out.println("Session ended");
                    break;
                }
                System.out.println(srvr_msg);
                if(srvr_msg.equals("Enter your current location:")||srvr_msg.equals("Enter where you want to go:")||srvr_msg.equals("The bestway will be displayed on the screen, another location? (n/y)")||srvr_msg.equals("In Correct Result"))
                {
                String usr_msg = sc.next();
                dos.writeUTF(usr_msg);
                dos.flush();
                }
            }
            //4.close connections
            dis.close();
            dos.close();
            s.close();
            
        } 
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }   
}
