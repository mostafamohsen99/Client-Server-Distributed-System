/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientserverproj;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
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
                //3.create I/O streams
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                  Socket s2 = new Socket("127.0.0.1", 1235);
            //2. Create I/O streams
            DataInputStream dis2 = new DataInputStream(s2.getInputStream());
            DataOutputStream dos2 = new DataOutputStream(s2.getOutputStream());
                //4.perform IO with client
                while (true)
                {
                    //a. request account number
                    dos.writeUTF("Enter your current location:");
                    dos.flush();
                    String loc = dis.readUTF();
                    dos2.writeUTF(loc);
                    dos2.flush();
                    System.out.println(loc);
                    String ok=dis2.readUTF();
                    dos.writeUTF(ok);
                    dos.flush();
                    dos.writeUTF("Enter where you want to go:");
                    dos.flush();
                    String loc2 = dis.readUTF();
                    dos2.writeUTF(loc2);
                    dos2.flush();
                    String OK2=dis2.readUTF();
                    dos.writeUTF(OK2);
                    dos.flush();
                    dos2.writeUTF("Make your Calculations");
                    dos2.flush();
                    String rec=dis2.readUTF();
                    dos.writeUTF(rec);
                    dos.flush();
                    dos.writeUTF("The bestway will be displayed on the screen, another location? (n/y)");
                    dos.flush();
                    String usr_choice = dis.readUTF();
//                    boolean checker=true;
//                    //apply checks
//                    if(usr_choice.equals("y"))
//                    {
//                        dos2.writeUTF("y");
//                    }
//                    while(!usr_choice.equals("y"))
//                    {
//                         if (usr_choice.equals("n"))
//                          {
//                        checker=false;
//                        dos2.writeUTF("n");
//                        dos2.flush();
//                        dos.writeUTF("bye");
//                        dos.flush();
//                        break;
//                          }
//                        dos2.writeUTF("a");
//                        dos.writeUTF("In Correct Result");
//                        usr_choice = dis.readUTF();
//                       
//                    }
//                    if(checker==false)
//                        break;
                     if(usr_choice.equals("n"))
                     {
                        dos.writeUTF("bye");
                        dos.flush();
                        dos2.writeUTF("n");
                        dos2.flush();
                        break;
                     }
                }

                //5.close connection
                dis.close();
                dos.close();
                s.close();
                   dis2.close();
                dos2.close();
                s2.close();
            }

            //6.close server
            //sv.close();
        } catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

}
     
    

