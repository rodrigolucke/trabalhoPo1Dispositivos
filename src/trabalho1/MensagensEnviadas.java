/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import java.util.LinkedList;
import trabalho1.Dispositivos.Dispositivo;

/**
 *
 * @author rodrigolucke
 */
public class MensagensEnviadas {
   private Dispositivo dispositivoOrigem;
   private Dispositivo dispositivosDestino ;
   private String msg;

    public MensagensEnviadas(Dispositivo dispositivoOrigem, Dispositivo dispositivosDestino, String msg) {
        this.dispositivoOrigem = dispositivoOrigem;
        this.dispositivosDestino = dispositivosDestino;
        this.msg = msg;
    }

    public MensagensEnviadas() {
    }

    
    @Override
    public String toString() {
        return "MensagensEnviadas{" + "dispositivoOrigem=" +", msg=" + msg + dispositivosDestino +  dispositivoOrigem + ", dispositivosDestino=" + '}';
    }

  

   
    
    
}
