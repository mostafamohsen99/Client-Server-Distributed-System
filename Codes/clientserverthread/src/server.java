/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dell
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class ClientHandler implements Runnable
{

    Socket s;

    public ClientHandler(Socket s)
    {
        this.s = s;
    }

    @Override
    public void run()
    {
        try
        {
            //3.create I/O streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            //4.perform IO with client
            while (true)
            {
                //a. request account number
                dos.writeUTF("Enter your current location:");
                dos.flush();
                String loc = dis.readUTF();
                    //apply checks
                //----------------------
                //b. if correct accnum request password
                dos.writeUTF("Enter where you want to go:");
                dos.flush();
                String loc2 = dis.readUTF();
                    //apply checks
                //----------------------
                //c. if correct password request payment amount
                dos.writeUTF("The bestway will be displayed on the screen, another location? (n/y)");
                dos.flush();
                String usr_choice = dis.readUTF();
                //apply checks
                if (usr_choice.equals("n"))
                {
                    dos.writeUTF("bye");
                    dos.flush();
                    break;
                }
            }

            //5.close connection
            dis.close();
            dos.close();
            s.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}

public class server
{

    public static void main(String[] args)
    {
        try
        {
            //1.open server socket
            ServerSocket sv = new ServerSocket(1234);
            System.out.println("Server Running...");
            while (true)
            {
                //2.accept connection
                Socket s = sv.accept();
                System.out.println("Client Accepted...");
                //3. open thread for this client (s)
                ClientHandler ch = new ClientHandler(s);
                Thread t = new Thread(ch);
                t.start();

            }

            //6.close server
            //sv.close();
        } catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

}
