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
import java.net.Socket;

/**
 *
 * @author sadik
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("localhost",5000);
        System.out.println("Client is connected at server's handshaking port : "+socket.getPort());
        System.out.println("Client's communication port : "+socket.getLocalPort());
        
        DataInputStream is=new DataInputStream(socket.getInputStream());
        DataOutputStream os=new DataOutputStream(socket.getOutputStream());
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in)); 
        String str="";
        String str1="";
       
        while(!str1.equals("stop")) //if the client sends 'stop' then after the response of server connection will be closed
        {   // input from client
            System.out.print("Your text : ");
            str1=bf.readLine();
            os.writeUTF(str1);
            
            // read from server
            str=is.readUTF();
            System.out.println("Server text: "+str);
        }
        
        System.out.println("Closing the connection..");
        
        os.close();
        is.close();
        socket.close();
        
        
    }
}
