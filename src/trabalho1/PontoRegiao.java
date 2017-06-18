/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import trabalho1.Dispositivos.Dispositivo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
/**
 *
 * @author home
 */
public class PontoRegiao {
    private int enderecoX;
    private int enderecoY;
    private int tipoPOnto;////2 para recarga 1 para válido 0 para inválido
    private int numMaximoDispositivos;
    private LinkedList<Dispositivo> dispositivos;
    private int coordenada;
    private int temperatura ;
    private int luminosidade;
    private int umidade;
    
    Scanner s = new Scanner(System.in);   
    MetodosAuxiliares m = new MetodosAuxiliares();

    public PontoRegiao() {
        
    }
    
    

    public LinkedList<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(LinkedList<Dispositivo> dispositivos) {
        this.dispositivos = dispositivos;
    }
    
    public PontoRegiao(int enderecoX, int enderecoY) {
        this.enderecoX = enderecoX;
        this.enderecoY = enderecoY;
        this.tipoPOnto = 1;//1 para válido 0 para inválido
        this.numMaximoDispositivos = 10;    
        this.dispositivos = new LinkedList<>();
        this.umidade = m.gerarNumero(20, 60);
        this.temperatura = m.gerarNumero(0, 35);
        this.luminosidade = m.gerarNumero(20, 80);
    } 

    public int getEnderecoX() {
        return enderecoX;
    }

    public void setEnderecoX(int enderecoX) {
        this.enderecoX = enderecoX;
    }

    public int getTipoPOnto() {
        return tipoPOnto;
    }

    public void setTipoPOnto(int tipoPOnto) {
        this.tipoPOnto = tipoPOnto;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public int getLuminosidade() {
        return luminosidade;
    }

    public void setLuminosidade(int luminosidade) {
        this.luminosidade = luminosidade;
    }

    public int getUmidade() {
        return umidade;
    }

    public void setUmidade(int umidade) {
        this.umidade = umidade;
    }
    

    public int getEnderecoY() {
        return enderecoY;
    }

    public void setEnderecoY(int enderecoY) {
        this.enderecoY = enderecoY;
    }

    public int getEhInvalido() {
        return tipoPOnto;
    }

    public void setTipoPontoInvalido() {
        this.tipoPOnto = 0;
    }
    
   public void setTipoPontoValido() {
        this.tipoPOnto = 1;
    }
    public void setTipoPontoRecarga() {
        this.tipoPOnto = 2;
    }

    public int getNumMaximoDispositivos() {
        return numMaximoDispositivos;
    }

    public void setNumMaximoDispositivos(int numMaximoDispositivos) {
        this.numMaximoDispositivos = numMaximoDispositivos;
    }

    @Override
    public String toString() {
        return "PontoRegiao{" + "enderecoX=" + enderecoX + ", enderecoY=" + enderecoY + ",\n tipoPOnto=" + tipoPOnto + ", \n numMaximoDispositivos=" + numMaximoDispositivos + ", dispositivos=" + dispositivos +"nn"+ '}';
    }

    
    
    public String addDispositivo(Dispositivo d) {
        if(verificarSePodeAdicionar() == 1 ){
            dispositivos.add(d);
        }else{
             return "pontoRegiao{" + "enderecoX=" + enderecoX + ", enderecoY=" + enderecoY + "possui "+ calcularNumDispositivosNoPonto() + " e é permitido apenas 10" +'}';
        }
        return null;
    }
    
    public void removeDispositivo(Dispositivo d) {
        dispositivos.remove(d);
    }

    
    public int calcularNumDispositivosNoPonto() {
        int numDispositivos = 0;
        for (Dispositivo dispositivos : dispositivos) {
            numDispositivos ++;
        }
        return numDispositivos;
    }
    
     public void careegarDispositivosNoPonto() {
        
         if(this.getTipoPOnto() == 2){
            for (Dispositivo dispositivo : dispositivos) {
                    
                  dispositivo.restaurarBateria();
            }
         }
      
    }

    public int verificarSePodeAdicionar() {
        if ( this.calcularNumDispositivosNoPonto() < 10 ){
            return 1;
        }else{
            return 0;
        }
    }

    public int verificarSeIdExiste(int id) {
       int existeDispositivo = this.calcularNumDispositivosNoPonto();
       
       if(existeDispositivo > 0){
           
            for (Dispositivo dispositivo : dispositivos) {
                if(dispositivo.getIdDispositivo() == id){
                   return -1;
                }
            }
       }
      return 1;
    }
    
      

}
