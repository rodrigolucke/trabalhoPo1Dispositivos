/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.Dispositivos;

import static java.lang.Math.exp;
import java.util.Random;
import trabalho1.Regiao;

/**
 *
 * @author home
 */
public abstract class  Dispositivo {
    private int idDispositivo;    
    private int cargaBateria;
    //private int consumoBateria;
    private int ehMovel;
    private int peso;
    private String cor;
    private int tamanhoStorage;
    private int alcanceComunicacao;
    

    public Dispositivo() {
    }

    public Dispositivo(int cargaBateria) {
        this.cargaBateria = cargaBateria;    
        this.gerarIdValidoDispositivo();
    }

    public int getCargaBateria() {
        return cargaBateria;
    }

    public void setCargaBateria(int cargaBateria) {
        this.cargaBateria = cargaBateria;
    }

   /* public int getConsumoPorHora() {
        return consumoBateria;
    }*/

    /*public void setConsumoPorHora(int consumoBateria) {
        this.consumoBateria = consumoBateria;
    }*/

    public int getEhMovel() {
        return ehMovel;
    }

    public int getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(int idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    @Override
    public String toString() {
        return "Dispositivo{" + "cargaBateria=" + cargaBateria + ", ehMovel=" + ehMovel + '}';
    }
    
    public void gerarIdValidoDispositivo(){
     // Random random = new Random(); 
      int valido = -1;
      int numId  =0;
      Regiao regiao = new Regiao();
         
      while(valido == -1){
        
        int max = 99999999;
        int min = 10000000;
        numId = (int) Math.floor(Math.random() * (max - min + 1) + min);
        regiao.verificarPercorrerMatriz(numId);
        
      }  
      
      this.setIdDispositivo(numId);
         
    }
    
     
}
