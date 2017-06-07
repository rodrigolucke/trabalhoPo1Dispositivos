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
import trabalho1.Dispositivos.Dispositivo;

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

    public LinkedList<PontoRegiao> getPontosRegiao() {
        return pontosRegiao;
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
            
             return -1;
           }
        }  
        return -1;
    }
     
     

  
    
    public void movimentarDispositivo(Dispositivo d){
         
        String posicao = this.retornarCelulaDoDispositivo(d); 
        
       
        System.out.println("O Dispositivo encontra-se na celula : " + posicao +"." );
         PontoRegiao pontoAtual =this.retornarPosicaoDispositivo(d);     
        
        String opcoes = this.retornarOpcoesMovimento(d, pontoAtual); 
        //retorna as opóes de movimento  
        System.out.println(opcoes);   
        //escolhe uma das oóes do retorno
        int movimentar = s.nextInt();
        PontoRegiao novoPonto = new PontoRegiao();
        novoPonto = this.pegarNovoponto(pontoAtual ,movimentar);
            
        pontoAtual.removeDispositivo(d);
        novoPonto.addDispositivo(d);
      
        
    }
    
      private String retornarCelulaDoDispositivo(Dispositivo d) {
       String posicao = "Dispositivo não encontrado.";
       int limitePontoRegiao = this.pontosRegiao.size() -1;
          for (int i = 0; i < limitePontoRegiao; i++) {              
            
                LinkedList DispositivosDoPontoDaRegiao  = new  LinkedList<>();
                DispositivosDoPontoDaRegiao = this.pontosRegiao.get(i).getDispositivos();
                int limiteDispositivos = this.pontosRegiao.get(i).getDispositivos().size() -1;
                for (int j = 0; j < limiteDispositivos ; j++) {
                    if(this.pontosRegiao.get(i).getDispositivos().get(j).getIdDispositivo()== d.getIdDispositivo()){
                        posicao = "Endereço X => "+this.pontosRegiao.get(i).getEnderecoX();
                        posicao += " "+ "Endereço Y => "+this.pontosRegiao.get(i).getEnderecoX()+" .";
                    }
                            

                }
            
        }
        return posicao;
          
    }

    private String retornarOpcoesMovimento(Dispositivo d,PontoRegiao pontoAtual ) {
        String opcoesMovimento = "Dispositivo não pode ser movimentado! /n";
        
        int i= 1;
        if( this.verificarSePodeMovimentar45(d,pontoAtual) == 1){
            opcoesMovimento = i +" - Movimentar 45◘ \n .";
            i++;
        }
        if( this.verificarSePodeMovimentar135(d,pontoAtual) == 1){
            opcoesMovimento += i+ " - Movimentar 135◘ \n";
            i++;
        }
        if( this.verificarSePodeMovimentar225(d,pontoAtual) == 1){
            opcoesMovimento += i+ " - Movimentar 225◘ \n";
            i++;
        }
        if( this.verificarSePodeMovimentar315(d,pontoAtual) == 1){
            opcoesMovimento += i+ " - Movimentar 315◘ \n";
            i++;
        }
     return opcoesMovimento;
   }

    private int verificarSePodeMovimentar45(Dispositivo d , PontoRegiao pontoAtual) {
       
        PontoRegiao novoPonto = new PontoRegiao();

       if(
            (pontoAtual.getEnderecoX() > 0  && pontoAtual.getEnderecoY() >0)&&
           (pontoAtual.getEnderecoX()< this.tamanhoX && pontoAtual.getEnderecoY() < this.tamanhoY)
           ){
           
            novoPonto = this.getPonto45(novoPonto, pontoAtual);

            if(novoPonto.getEhInvalido() != 0 && novoPonto.calcularNumDispositivosNoPonto() < 11){
                return 1;
            }else{
                return 0 ;        
            }

        }
        return 0;
    }
    
    private int verificarSePodeMovimentar135(Dispositivo d, PontoRegiao pontoAtual) {
        PontoRegiao novoPonto = new PontoRegiao();

       if(
            (pontoAtual.getEnderecoX() > 0  && pontoAtual.getEnderecoY() >0)&&
           (pontoAtual.getEnderecoX()< this.tamanhoX && pontoAtual.getEnderecoY() < this.tamanhoY)
           ){
           /* novoPonto.setEnderecoX(pontoAtual.getEnderecoX() +1);
            novoPonto.setEnderecoY(pontoAtual.getEnderecoY()+1);*/
           novoPonto =this.getPonto135(novoPonto, pontoAtual);

            if(novoPonto.getEhInvalido() != 0 && novoPonto.calcularNumDispositivosNoPonto() < 11){
                return 1;
            }else{
                return 0 ;        
            }

        }
        return 0;
    }

    private int verificarSePodeMovimentar225(Dispositivo d, PontoRegiao pontoAtual) {
        PontoRegiao novoPonto = new PontoRegiao();

        if(
            (pontoAtual.getEnderecoX() > 0  && pontoAtual.getEnderecoY() >0)&&
           (pontoAtual.getEnderecoX()< this.tamanhoX && pontoAtual.getEnderecoY() < this.tamanhoY)
           ){
            
            novoPonto = this.getPonto225(novoPonto, pontoAtual);

            if(novoPonto.getEhInvalido() != 0 && novoPonto.calcularNumDispositivosNoPonto() < 11){
                return 1;
            }else{
                return 0 ;        
            }

        }
        return 0;
    }

    private int verificarSePodeMovimentar315(Dispositivo d, PontoRegiao pontoAtual ) {
        PontoRegiao novoPonto = new PontoRegiao();

        if(
            (pontoAtual.getEnderecoX() > 0  && pontoAtual.getEnderecoY() >0)&&
           (pontoAtual.getEnderecoX()< this.tamanhoX && pontoAtual.getEnderecoY() < this.tamanhoY)
           ){
            novoPonto =this.getPonto315(novoPonto, pontoAtual);

            if(novoPonto.getEhInvalido() != 0 && novoPonto.calcularNumDispositivosNoPonto() < 11){
                return 1;
            }else{
                return 0 ;        
            }

        }
        return 0;
    }
    
    public PontoRegiao retornarPosicaoDispositivo(Dispositivo d){
        int limitePontoRegiao = this.pontosRegiao.size() -1;
        for (int i = 0; i < limitePontoRegiao; i++) {

          if(this.pontosRegiao.get(i).getEhInvalido() != 0){
              LinkedList DispositivosDOPontoDaRegiao  = new  LinkedList<>();
              DispositivosDOPontoDaRegiao = this.pontosRegiao.get(i).getDispositivos();
              int limiteDispositivos = this.pontosRegiao.get(i).getDispositivos().size() -1;
              for (int j = 0; j < limiteDispositivos ; j++) {
                  if(this.pontosRegiao.get(i).getDispositivos().get(j).getIdDispositivo()== d.getIdDispositivo()){
                      return this.pontosRegiao.get(i);
                  }
              }
          }
        }
        return null;
    }

    private PontoRegiao pegarNovoponto( PontoRegiao pontoAtual, int movimentar) {
            PontoRegiao novoPonto = new PontoRegiao();
            if(movimentar ==1 ){
                novoPonto =  this.getPonto45(novoPonto, pontoAtual);
            }else if(movimentar ==2){
               novoPonto =  this.getPonto135(novoPonto, pontoAtual);
                
            } else if(movimentar ==3){
                novoPonto =  this.getPonto225(novoPonto, pontoAtual);
            }else if(movimentar ==4){
                 novoPonto =  this.getPonto315(novoPonto, pontoAtual);
            }
           
            
            return novoPonto;
    }
    
     private PontoRegiao getPonto45(PontoRegiao novoPonto ,PontoRegiao pontoAtual) {
        novoPonto.setEnderecoX(pontoAtual.getEnderecoX() -1);
        novoPonto.setEnderecoY(pontoAtual.getEnderecoY()+1);
        return novoPonto;
    }
    
     private PontoRegiao getPonto135(PontoRegiao novoPonto ,PontoRegiao pontoAtual) {
        novoPonto.setEnderecoX(pontoAtual.getEnderecoX() +1);
        novoPonto.setEnderecoY(pontoAtual.getEnderecoY()+1);
        return novoPonto;
    }

     private PontoRegiao getPonto225(PontoRegiao novoPonto ,PontoRegiao pontoAtual) {
        novoPonto.setEnderecoX(pontoAtual.getEnderecoX()+1);
        novoPonto.setEnderecoY(pontoAtual.getEnderecoY()-1);
        return novoPonto;
    }
     
    private PontoRegiao getPonto315(PontoRegiao novoPonto ,PontoRegiao pontoAtual) {
        novoPonto.setEnderecoX(pontoAtual.getEnderecoX()-1);
        novoPonto.setEnderecoY(pontoAtual.getEnderecoY()-1);
        return novoPonto;
    }

    

  
}