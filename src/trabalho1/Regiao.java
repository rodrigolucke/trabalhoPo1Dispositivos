/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

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
          this.gerarPontosRegiaoHachuradosAleatorios();
          this.gerarPontosRegiaoRecarga();
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

    public void gerarPontosRegiaoHachuradosAleatorios(){
       
       
        int numColuna = this.getTamanhoX();
        int numLinha = this.getTamanhoY();
        int totalPontos = numColuna* numLinha;
        
        System.out.println("Digite o numero de  pontos HACHURADOS QUE VOCE DESEJA: ");
        int numPontosHachurados = s.nextInt();
        int[] pontosRachurados = new int[numPontosHachurados];
        for (int i = 0; i < numPontosHachurados; i++) {
           Random random = new Random();          
           pontosRachurados[i]= random.nextInt(totalPontos);
          
        }
         
        int limite = pontosRegiao.size();
        for (int j = 0; j < pontosRachurados.length; j++) {
            for (int i = 0; i< limite ; i++) {  
                if(this.pontosRegiao.indexOf(pontosRegiao.get(i)) == pontosRachurados[j]){

                    this.pontosRegiao.get(i).setTipoPontoInvalido();
                }  
            }

        }
    }
         public void gerarPontosRegiaoRecarga(){
       
       
        int numColuna = this.getTamanhoX();
        int numLinha = this.getTamanhoY();
        int totalPontos = 0;
        
        System.out.println("Digite o numero de  pontos de recarga que desseja: ");
        int numPontosRecarga = s.nextInt();
        int[] pontosRecarga = new int[numPontosRecarga];
       
       
        System.out.println("Gerar aleatoriamente ou quer escolher os locais? "+ " \n" + "Tecle 1 para aleatório. "+"\n"+" Tecle 0 para manual.");
        int aleatorioManual = s.nextInt();
        if(aleatorioManual == 0){
            for (int i = 0; i < numPontosRecarga; i++) {
               Random random = new Random();                    
               pontosRecarga[i]= random.nextInt(totalPontos);
           }
           int limite = pontosRegiao.size();
          
           for (int j = 0; j < pontosRecarga.length; j++) {
                for (int i = 0; i< limite ; i++) {      
                    if(this.pontosRegiao.indexOf(pontosRegiao.get(i)) == pontosRecarga[j]){
                        this.pontosRegiao.get(i).setTipoPontoRecarga();
                    } 
                }
           }
             
        }else{
          
            int x = 0;
           while( x>0){
               
                System.out.println("Digite a lin ");
                 
                int linha = s.nextInt();
                int coluna =s.nextInt();
               
               
                }
            }      
       
         
             
        }
    

    public void gerarPontosNaRegiao(){
        
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

    
    private int calcularNumPontosNaRegiao() {
        int numPontos = 0;
        for (PontoRegiao pontoRegiao : pontosRegiao) {
            numPontos ++;
        }
        return numPontos;
    }

    private int verificarSePodeAdicionar() {
        if ( this.calcularNumPontosNaRegiao() < calcularTamanhoRegiao() ){
            return 1;
        }else{
            return 0;
        }
    }

    private int calcularTamanhoRegiao() {
        int tamanhoRegiao = 0;
        
        for (int i = 0; i < this.tamanhoX; i++) {
            for (int j = 0; j < this.tamanhoY; j++) {
                tamanhoRegiao ++;
            }
        }
        return tamanhoRegiao;
    }
}
