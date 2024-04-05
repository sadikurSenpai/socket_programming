/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socketprogrammingtwoway;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author sadik
 */
public class Server {
    public static void main(String[] args) throws IOException {
      ServerSocket serverSocket = new ServerSocket(5000, 0, InetAddress.getByName("0.0.0.0"));
        System.out.println("Server is connected at port no : "+serverSocket.getLocalPort());
        System.out.println("Waiting for client...");
        Socket socket=serverSocket.accept();
        System.out.println("Client is connected");
        System.out.println("Client is connected at port number : "+ socket.getPort());
        System.out.println("Server's communication port : "+socket.getLocalPort());
        
        DataInputStream is=new DataInputStream(socket.getInputStream());
        DataOutputStream os=new DataOutputStream(socket.getOutputStream());
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        
        String str="";
        String str1="";
        while(!str.equals("stop"))
        {
            str=is.readUTF();
            System.out.println("Client text: "+str);
            System.out.print("Your text : ");
            str1=bf.readLine();
            os.writeUTF(str1);
        }
        
        
        System.out.println("Closing the connection..");
        bf.close();
        os.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
    
}
