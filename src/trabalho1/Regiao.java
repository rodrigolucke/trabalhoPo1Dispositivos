/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author home
 */
public class Regiao {
    
    private String nomeRegiao;
    private int tamanhoX;
    private int tamanhoY;
    private LinkedList<PontoRegiao> pontosRegiao;
    Scanner s = new Scanner(System.in);
    
    //private int numPontosHachuradas;

    public Regiao() {
          System.out.println("Digite o nome da Região: ");
          this.nomeRegiao = s.nextLine();
          System.out.println("Digite o numero de linhas para montar a matriz da região:");
          this.tamanhoX = s.nextInt();
          System.out.println("Digite o numero de colunas para montar a matriz da região: ");
          this.tamanhoY = s.nextInt();
          this.pontosRegiao = new LinkedList<>();
          this.gerarPontosNaRegiao();
         
    }
    
   
     
    public Regiao(String nomeRegiao, int tamanhoX, int tamanhoY) {
        this.nomeRegiao = nomeRegiao;
        this.tamanhoX = tamanhoX;
        this.tamanhoY = tamanhoY;
    }

    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    
    public int getTamanhoX() {
        return tamanhoX;
    }

    public void setTamanhoX(int tamanhoX) {
        this.tamanhoX = tamanhoX;
    }

    public int getTamanhoY() {
        return tamanhoY;
    }

    public void setTamanhoY(int tamanhoY) {
        this.tamanhoY = tamanhoY;
    }

    public int[] gerarPontosRegiaoHachuradosAleatorios(){
        
        int numColuna = this.getTamanhoX();
        int numLinha = this.getTamanhoY();
        int totalPontos = numColuna* numLinha;
     
        double totalMatriz = (totalPontos /100.0) *totalPontos;
        int numPontosHachurados = (int)totalMatriz;
      
        int[] pontosHachurados = new int[numPontosHachurados];
        
       /* for (int i = 0; i < numPontosHachurados; i++) {
           Random random = new Random();          
           pontosHachurados[i]= random.nextInt(totalPontos);
        }*/
              
        for (int i = 0; i < pontosHachurados.length; i++) {
           int num = -1;
           while (num == -1){
              num = this.gerarRandomHachuradoValido(pontosHachurados, totalPontos);
               
           }  
           
        }
         
        int limite = pontosRegiao.size();
        for (int j = 0; j < pontosHachurados.length; j++) {
            for (int i = 0; i< limite ; i++) {  
                if(this.pontosRegiao.indexOf(pontosRegiao.get(i)) == pontosHachurados[j]){

                    this.pontosRegiao.get(i).setTipoPontoInvalido();
                }  
            }
        }
        return pontosHachurados;
    }
    
    public void gerarPontosRegiaoRecarga(int[] pontosHachurados){
       
       
        int numColuna = this.getTamanhoX();
        int numLinha = this.getTamanhoY();
        int totalPontos = 0;
        
        /*System.out.println("Digite o numero de  pontos de recarga que desseja: ");
        int numPontosRecarga = s.nextInt();
        int[] pontosRecarga = new int[numPontosRecarga];*/
        int numPontosRecarga = s.nextInt();
        int[] pontosRecarga = new int[numPontosRecarga];
        double totalMatriz = (totalPontos /100.0) *totalPontos;
        int numPontosHachurados = (int)totalMatriz;
       
       
        for (int i = 0; i < numPontosRecarga; i++) {
           int num = -1;
           while (num == -1){
              num = this.gerarRandomRecargaValido(pontosHachurados, pontosRecarga, totalPontos);
               
           }  
           
        }
        int limite = pontosRegiao.size();

        for (int j = 0; j < pontosRecarga.length; j++) {
             for (int i = 0; i< limite ; i++) {      
                 if(this.pontosRegiao.indexOf(pontosRegiao.get(i)) == pontosRecarga[j]){
                     this.pontosRegiao.get(i).setTipoPontoRecarga();
                 } 
             }
        }
    } 
    
    public int gerarRandomRecargaValido(int[] pontosHachurados, int[] pontosRecarga, int totalPontos) {
        int num = -1;
        
         Random random = new Random(); 
         num = random.nextInt(totalPontos);
         
         num = this.verificarSeEstaEmPontosRecarga(pontosRecarga,num);
         if(num != -1){
             num = this.verificarSeEstaEmPontosHachurados(pontosHachurados,num);
         }else 
             return -1;
        
        
       return num;
    }
    
    public int gerarRandomHachuradoValido(int[] pontosHachurados, int totalPontos) {
        int num = -1;
        
         Random random = new Random(); 
         num = random.nextInt(totalPontos);
         
         //num = this.verificarSeEstaEmPontosRecarga(pontosHachurados,num);
         if(num != -1){
            num = this.verificarSeEstaEmPontosRecarga(pontosHachurados,num);
         }else 
             return -1;
        
        
       return num;
    }

    public int verificarSeEstaEmPontosRecarga(int[] pontosRecarga ,int num) {
       
        for (int i = 0; i < pontosRecarga.length; i++) {
            if(pontosRecarga[i] == num){
                return -1;
            }
        }
       return 1;
        
    }
    
    public int verificarSeEstaEmPontosHachurados(int[] pontosHachurados ,int num) {
       
        for (int i = 0; i < pontosHachurados.length; i++) {
            if(pontosHachurados[i] == num){
                return -1;
            }
        }
       return 1;
        
    }
    
    /*private int verificarSePodeAdicionarPontoRecarga(int[] pontosHachurados , int[] pontosRecarga) {
        int permite = 0;
         for (int j = 0; j < pontosHachurados.length; j++) {
            for (int i = 0; i< pontosRecarga.length ; i++) {  
                if(pontosHachurados[j] != pontosRecarga[i]){
                     permite ++;
                }  
            }
        }
        return 0;
           
    }*/
    
    public void gerarPontosNaRegiao(){
        
            
          this.gerarPontosAtivosNaRegiao();
          int[] pontosRachurados =  this.gerarPontosRegiaoHachuradosAleatorios();
          this.gerarPontosRegiaoRecarga( pontosRachurados);
        
    }

    public void gerarPontosAtivosNaRegiao(){
        
        for (int i = 0; i < this.tamanhoX; i++) {
            for (int j = 0; j < this.tamanhoY; j++) {
               this.addPontoNaRegiao( new PontoRegiao(i, j),-1);
            }
        }
    }
    
    
    @Override
    public String toString() {
        return "Regiao{" + "nomeRegiao=" + nomeRegiao + ", tamanhoX=" + tamanhoX + ", tamanhoY=" + tamanhoY + ", pontoRegiao=" + pontosRegiao + '}';
    }
    
    
     public String addPontoNaRegiao(PontoRegiao p , int testa) {
         
        if( testa == -1 || (verificarSePodeAdicionar() == 1 && testa == 1) ){
            this.pontosRegiao.add(p);
            
        }else{
            //descomentar
              //return "Regiao{" + "nomeRegiao=" + nomeRegiao + ",tem tamanho de " +calcularTamanhoRegiao()+",e ja possui o numero maximo de celulas" +'}';
        }
        return null;
    }
     
    public void removePontoNaRegiao(PontoRegiao p) {
        pontosRegiao.remove(p);
    }

    
    public int calcularNumPontosNaRegiao() {
        int numPontos = 0;
        for (PontoRegiao pontoRegiao : pontosRegiao) {
            numPontos ++;
        }
        return numPontos;
    }

    public int verificarSePodeAdicionar() {
        if ( this.calcularNumPontosNaRegiao() < calcularTamanhoRegiao() ){
            return 1;
        }else{
            return 0;
        }
    }

    public int calcularTamanhoRegiao() {
        int tamanhoRegiao = 0;
        
        for (int i = 0; i < this.tamanhoX; i++) {
            for (int j = 0; j < this.tamanhoY; j++) {
                tamanhoRegiao ++;
            }
        }
        return tamanhoRegiao;
    }
    
     public int verificarPercorrerMatriz(int id ) {
         
        
               
        for (PontoRegiao pontoRegiao : pontosRegiao) {

           if(pontoRegiao.verificarSeIdExiste(id)== -1){
            
             return-1;
           }
        }  
        return -1;
    }
 

    
}
