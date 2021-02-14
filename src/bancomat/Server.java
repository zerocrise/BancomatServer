/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancomat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author rolandosucco
 */
public class Server {
    public static void main(String[] argas) throws IOException{
        int porta=11234;
        ServerSocket socket=new ServerSocket(porta);
        while(true){
        Socket s=socket.accept();
        new Servente(s).start();
        }
        
    }
    
}
