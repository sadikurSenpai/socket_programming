/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socketprogrammingthread_lab_report;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author sadik
 */
public class Server {
    public static int count;
    public static void main(String[] args) throws IOException {
        
        ServerSocket serverSocket=new ServerSocket(5101);
        System.out.println("Waiting for clients");
        count=0;
        while(count<5){
            Socket socket=serverSocket.accept();
            DataInputStream is=new DataInputStream(socket.getInputStream());
            DataOutputStream os=new DataOutputStream(socket.getOutputStream());
            System.out.println("A new client has arrived :  "+socket);
            Thread tunnel=new ClientHandler(socket,is,os);
            tunnel.start();
            count++;
        }
        System.out.println("Maximum 5 clients\nClosing the connection..");
        serverSocket.close();
        
    }
 
}
