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
import java.net.ServerSocket;
import java.net.Socket;

public class Server2
{

    public static void main(String[] args)
    {
        try
        {
            //1.open server socket
            ServerSocket sv = new ServerSocket(1235);
            System.out.println("Server 2 Running...");
            while (true)
            {
                //2.accept connection
                Socket s = sv.accept();
                System.out.println("Server Accepted...");
                //3.create I/O streams
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                //4.perform IO with client
                while (true)
                {
                   System.out.println("new loop");
                    String loc = dis.readUTF();
                    System.out.println(loc);
                    dos.writeUTF("location1 read");
                    dos.flush();
                    String loc2 = dis.readUTF();
                    dos.writeUTF("location2 read");
                    dos.flush();
                    String calc=dis.readUTF();
                    dos.writeUTF("The Recommendation will be displayed on screen");
                    dos.flush();
                  //  boolean checker=false;
                    String usr_choice = dis.readUTF();
                    if(usr_choice.equals("n"))
                    {     
                        break;
                    }
//                    while((!usr_choice.equals('n'))&&(!usr_choice.equals('y')))
//                    {
//                        if(usr_choice.equals('n'))
//                        {
//                            checker=true;
//                            break;
//                        }
//                            usr_choice=dis.readUTF();
//                            
//                    }
//                    if(checker)
//                        break;
                }

                //5.close connection
                dis.close();
                dos.close();
                s.close();
            }

            //6.close server
            //sv.close();
        } catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

}
     