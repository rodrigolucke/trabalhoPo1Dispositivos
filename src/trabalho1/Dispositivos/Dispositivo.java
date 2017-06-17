/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.Dispositivos;

import static java.lang.Math.exp;
import java.util.Random;
import java.util.Scanner;
import trabalho1.MetodosAuxiliares;
import trabalho1.Regiao;

/**
 *
 * @author home
 */
public abstract class  Dispositivo {
    private int idDispositivo;    
    private int cargaBateria;
    private int tamanhoMaximoBateria;
    private int status;//0 desligado 1 Ativo
    private int ehMovel;
    private int peso;
    private String cor;
    private String storage;
    private int tamStorage;
    private int alcanceComunicacao;
    Scanner s = new Scanner(System.in);
    MetodosAuxiliares m = new MetodosAuxiliares();

    

    public Dispositivo( ) {
        this.cargaBateria = cargaBateria;
       // this.cargaBateria = setCargaBateria(cargaBateria);
        this.alcanceComunicacao = 1;
        this.tamanhoMaximoBateria =500 ;
        this.peso = 10;
        System.out.println("Digite a cor para o Dispositivo: \n");
        this.cor = s.next();
        this.ehMovel = 1;//1 - movel 0 -imovel
    }
    
     public Dispositivo( int automatico , Regiao r) {
        this.cargaBateria = cargaBateria;        
        this.alcanceComunicacao = 10;       
        this.peso = m.gerarNumero(5, 100);  
        this.status = 1;
        this.cor = m.retornaCor();
        this.tamStorage=1000;
      
        this.gerarIdValidoDispositivo(r);
    }

    public int getCargaBateria() {
        return cargaBateria;
    }

    public void setEhMovel( int ehMOvel) {
        this.ehMovel = ehMovel;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setCargaBateria(int cargaBateria) {
        this.cargaBateria = cargaBateria;
    }

  

    /*public void setConsumoPorHora(int consumoBateria) {
        this.consumoBateria = consumoBateria;
    }*/

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getTamanhoMaximoBateria() {
        return tamanhoMaximoBateria;
    }

    public void setTamanhoMaximoBateria(int tamanhoMaximoBateria) {
        this.tamanhoMaximoBateria = tamanhoMaximoBateria;
    }

    public int getTamStorage() {
        return tamStorage;
    }

    public void setTamStorage(int tamStorage) {
        this.tamStorage = tamStorage;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public int getAlcanceComunicacao() {
        return alcanceComunicacao;
    }

    public void setAlcanceComunicacao(int alcanceComunicacao) {
        this.alcanceComunicacao = alcanceComunicacao;
    }


    

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
        return "{" + "idDispositivo=" + idDispositivo + ", cargaBateria=" + cargaBateria + ", ehMovel=" + ehMovel + ", peso=" + peso + ", cor=" + cor + ", storage=" + storage + ", alcanceComunicacao=" + alcanceComunicacao + '}'+"\n";
    }
    
     public String getTextoStrage(Regiao r) {
         
        return "{" + "idDispositivo=" + idDispositivo + r.retornarCelulaDoDispositivo(this) + '}'+"\n";
    }

   
    
    public void gerarIdValidoDispositivo(Regiao r){
     // Random random = new Random(); 
      int valido = -1;
      int numId  =0;
      
         
      while(valido == -1){
        
        int max = 99999999;
        int min = 10000000;
        numId = (int) Math.floor(Math.random() * (max - min + 1) + min);
        valido = r.verificarPercorrerMatriz(numId);
        
      }  
      
      this.setIdDispositivo(numId);
         
    }
    
    public void consomeBateria(){
        this.cargaBateria = this.cargaBateria - 100;
    }

    public void consomeBateriaMovimento() {
       
        this.cargaBateria = this.cargaBateria - 50;
    }
    
    public void restaurarBateria(){
        this.setCargaBateria(getTamanhoMaximoBateria());
        
    }
   
   
}
