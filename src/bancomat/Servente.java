/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancomat;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rolandosucco
 */
public class Servente extends Thread {
private Socket s;
private Protocollo p;
private Tipo t;
private ObjectInputStream inp=null;
private ObjectOutputStream out=null;
    public Servente(Socket s) {
        this.s=s;
    }
    public void run(){
    p= new Protocollo();
    p.tipo=t.PIN;
    try {
        out=new ObjectOutputStream(s.getOutputStream());
        inp=new ObjectInputStream(s.getInputStream());
        while(true){
         out.writeObject(p);
         out.flush();
         p=(Protocollo)inp.readObject();
         switch(p.tipo){
            case PIN:
               if(p.getPin()==1234){
               
               }
              
         }
        }
    } catch (IOException ex) {
        Logger.getLogger(Servente.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Servente.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }
    
}
