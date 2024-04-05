/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socketprogrammingthread_lab_report;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author sadik
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("192.168.1.99",5101);
        System.out.println("Handshaking port connected to : "+socket.getPort());
        System.out.println("Your communication port : "+socket.getLocalPort());
        
        DataInputStream is=new DataInputStream(socket.getInputStream());
        DataOutputStream os=new DataOutputStream(socket.getOutputStream());
        Scanner scan=new Scanner(System.in);
        
        int firstNumber,secondNumber;
        
        String str="";
        while(true)
        {
            String opCode="";
            str=is.readUTF();
            System.out.println(str);
            opCode=scan.nextLine();
            os.writeUTF(opCode+"");
            if(opCode.equals("ENDS"))
            {
                str=is.readUTF();
                System.out.println(str);
                break;
            }
            str=is.readUTF();
            System.out.println(str);
            firstNumber=scan.nextInt();
            os.writeUTF(firstNumber+"");
            
            str=is.readUTF();
            System.out.println(str);
            secondNumber=scan.nextInt();
            os.writeUTF(secondNumber+"");
            
            str=is.readUTF();
            System.out.println(str);
            scan.nextLine();
            
        }
        
        is.close();
        os.close();
        socket.close();
        
    }
}
