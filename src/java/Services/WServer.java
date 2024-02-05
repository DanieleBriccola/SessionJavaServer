/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.io.IOException;
import javax.websocket.*;
import javax.websocket.server.*;

/**
 * ws://localhost:8080/provaws/ws
 * @author DAN.BRICCOLA
 */
@ServerEndpoint("/ws")
public class WServer {
    
    @OnOpen
    public void onOpen(Session sessione) throws IOException{
        System.out.println("Qualcuno ha richiesto una connesione " + sessione.getId());
        sessione.getBasicRemote().sendText("La connesione è attiva");
    }
    
    @OnClose
    public void chiudoConnesione(Session sessione){
        System.out.println("Qualcuno ha richiesto di chiudere una connesione " + sessione.getId());
    }
   
    @OnMessage
    public void onMessage(Session sessione, String message) throws IOException, InterruptedException {
        System.out.println("ho ricevuto il messaggio" + message + "da " + sessione.getId());
        sessione.getBasicRemote().sendText("Benvenuto " + message);
        inviaNumeriDa1_a_100(sessione);
    }

    private void inviaNumeriDa1_a_100(Session sessione) throws IOException, InterruptedException {
        for(int i=1; i<=100; i++){
            sessione.getBasicRemote().sendText(""+i);
            Thread.sleep(500);
        }
    }
    
}
