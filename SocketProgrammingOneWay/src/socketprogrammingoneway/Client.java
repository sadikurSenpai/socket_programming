/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socketprogrammingoneway;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author sadik
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("localhost",49153);
        System.out.println("Client connected at server's handshaking port : "+socket.getPort());
        System.out.println("Client's communication port : "+socket.getLocalPort());
        System.out.println("Client is connected");
        System.out.println("Enter the message you want to send ");
        
        DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String str="";
        while(!str.equals("stop"))
        {
            str=bf.readLine();
            outStream.writeUTF(str);
            
        }
        
        System.out.println("Closing the connection....");
        bf.close();
        outStream.close();
        socket.close();
    }
    
   
    
}
