/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socketprogrammingthread_lab_report;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sadik
 */
public class ClientHandler extends Thread {
    final Socket tunnel;
    final DataInputStream is;
    final DataOutputStream os;
    
    int firstNumber,secondNumber;
    
    public ClientHandler(Socket tunnel, DataInputStream is, DataOutputStream os) {
        this.tunnel = tunnel;
        this.is = is;
        this.os = os;
    }
    
    public void run()
    {
        while(true)
        {
            String opCode="";
            
            try {
                os.writeUTF("(+).Addition\n(-).Subtraction\n(*).Multiplication\n(/).Division\n(%).Modules\nEnter the operation ");
                opCode=is.readUTF();
                if(opCode.equals("ENDS"))
                {
                    os.writeUTF("Closing the connection..");
                    Server.count--;
                    break;
                }
                os.writeUTF("Enter the first number ");
                firstNumber=Integer.parseInt(is.readUTF());
                
                os.writeUTF("Enter the second number ");
                secondNumber=Integer.parseInt(is.readUTF());
                
                int ans;
                switch(opCode)
                {
                    case "+":
                        ans=firstNumber+secondNumber;
                        os.writeUTF("The answer is : "+ans+"");
                        break;
                    case "-":
                        ans=firstNumber-secondNumber;
                        os.writeUTF("The answer is : "+ans+"");
                        break;
                    case "*":
                        ans=firstNumber*secondNumber;
                        os.writeUTF("The answer is : "+ans+"");
                        break;
                    case "/":
                        if(secondNumber==0)
                        {
                            os.writeUTF("Divisior can't be 0");
                        }
                        else
                        {
                            ans=firstNumber/secondNumber;
                            os.writeUTF("The answer is : "+ans+"");
                        }
                        break;
                    case "%":
                        if(secondNumber==0)
                        {
                            os.writeUTF("Divisior can't be 0");
                        }
                        else
                        {
                            ans=firstNumber%secondNumber;
                            os.writeUTF("The answer is : "+ans+"");
                        }
                        break;  
                    default:
                        os.writeUTF("Invalid operation");
                        break;
                }
                
                
            } catch (IOException ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        try {
            this.is.close();
            this.os.close();
            this.tunnel.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
