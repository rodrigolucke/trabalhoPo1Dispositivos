/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import static java.lang.Math.exp;
import java.util.Random;

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

    public Dispositivo(int cargaBateria, int consumoBateria, int ehMovel) {
        this.cargaBateria = cargaBateria;
      //  this.consumoBateria = consumoBateria;
        this.ehMovel = ehMovel;
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

    public void setEhMovel(int ehMovel) {
        this.ehMovel = ehMovel;
    }

    @Override
    public String toString() {
        return "Dispositivo{" + "cargaBateria=" + cargaBateria + ", ehMovel=" + ehMovel + '}';
    }
    
    public void gerarIdValidoDispositivo(){
      Random random = new Random(); 
      int valido = -1;
      Regiao regiao = new Regiao();
      
            
      int num = -1;
      while(valido == -1){
        // valido = this.verificarSeIdJaExiste( regiao);
          for (int i = 0; i < 9; i++) {
               num *= exp(10) + random.nextInt(9);
          }
        
         
         regiao.verificarPercorrerMatriz(num);
      }  
      
      this.setIdDispositivo(num);
         
    }

   
}
