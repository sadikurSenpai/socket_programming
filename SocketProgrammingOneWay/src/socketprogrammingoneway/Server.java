/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socketprogrammingoneway;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author sadik
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(49153);
        System.out.println("Server is connected at port no : "+serverSocket.getLocalPort()); 
        System.out.println("Waiting for client...");
        Socket socket=serverSocket.accept();
        System.out.println("Client is connected at port no : "+socket.getPort());
        System.out.println("Server's communication port : "+socket.getLocalPort());
        
        DataInputStream is=new DataInputStream(socket.getInputStream());
        String str="";
        while(!str.equals("stop"))
        {
            str=is.readUTF();
            System.out.println("Client says : "+str);
        }
        
        System.out.println("Closing the connection of this client");
        is.close();
        socket.close();
        serverSocket.close();

    }
}
