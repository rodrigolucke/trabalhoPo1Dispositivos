/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import static java.lang.Math.random;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import trabalho1.Dispositivos.Dispositivo;
import trabalho1.Dispositivos.SensorDeLuminosidade;
import trabalho1.Dispositivos.SensorDeTemperatura;
import trabalho1.Dispositivos.Smartphone;
import trabalho1.Dispositivos.Tablet;
import trabalho1.MetodosAuxiliares;

/**
 *
 * @author home
 */
public class Regiao {
    
    private String nomeRegiao;
    private int tamanhoX;
    private int tamanhoY;
    private LinkedList<PontoRegiao> pontosRegiao;
    private LinkedList<Movimentacoes> movimentacoesRegiao = new LinkedList<Movimentacoes>();
    private LinkedList<MensagensEnviadas> mensagemEnviadaRergiao =new LinkedList<MensagensEnviadas>() ;
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
    
     public Regiao(int automatico) {
          
          this.nomeRegiao = "teste";
          MetodosAuxiliares m = new MetodosAuxiliares();
          int num = m.gerarNumero(5 ,10 );
          this.tamanhoX = num;
         
          this.tamanhoY = num;
          this.pontosRegiao = new LinkedList<>();
          this.gerarPontosNaRegiao();
    }

    public LinkedList<MensagensEnviadas> getMensagemEnviadaRergiao() {
        return mensagemEnviadaRergiao;
    }

    public void setMensagemEnviadaRergiao(LinkedList<MensagensEnviadas> mensagemEnviadaRergiao) {
        this.mensagemEnviadaRergiao = mensagemEnviadaRergiao;
    }
    public void addMensagemEnviadas(MensagensEnviadas msg ) {
        this.mensagemEnviadaRergiao.add(msg);
      
    }
     
    public LinkedList<Movimentacoes> getMovimentacoesRegiao() {
        return movimentacoesRegiao;
    }

    public void setMovimentacoesRegiao(LinkedList<Movimentacoes> MovimentacoesRegiao) {
        this.movimentacoesRegiao = MovimentacoesRegiao;
    }
    
     public void addMovimentoRegiao(Movimentacoes m ) {
        this.movimentacoesRegiao.add(m);
      
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
     
        double totalDePontosMatriz = (totalPontos /100.0) *totalPontos;
        int numPontosHachurados = (int)totalDePontosMatriz;
      
        int[] pontosHachurados = new int[numPontosHachurados];
        
    
        int x =0;   
       
        while(pontosHachurados.length > x) {
           int num = -1;
           while (num == -1){
              num = this.gerarRandomHachurado(pontosHachurados[x], totalPontos);
              //se retorna -1 quer dizer que o ponto nao pode ser utilizado
              if(num != -1){
                   pontosHachurados[x] = num;
                   x++;
              } 
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
        int totalPontos = numColuna* numLinha;
     
        double totalMatriz = (totalPontos /100.0) *totalPontos;
        int numPontosRecarga = (int)totalMatriz;
      
        int[] pontosRecarga = new int[numPontosRecarga];
       
        
       /* for (int i = 0; i < numPontosRecarga; i++) {
           int num = -1;
           while (num == -1){
              num = this.gerarRandomRecargaValido(pontosHachurados, pontosRecarga, totalPontos);               
           }  
           
        }*/
       
        int x =0;   
       
        while(pontosRecarga.length > x) {
           int num = -1;
           while (num == -1){
              num = this.gerarRandomPontosRecarga2(pontosRecarga[x], totalPontos);
              if(num != -1){ 
                    num = this.verificarSeEstaEmPontosHachurados(pontosHachurados, num);
                   //se retorna -1 quer dizer que o ponto nao pode ser utilizado
                    if(num != -1){
                         pontosRecarga[x] = num;                   
                         x++;
                    }
              }
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
       
        
         Random random = new Random(); 
         int num = random.nextInt(totalPontos);
         
        num = this.verificarSeEstaEmPontosHachurados(pontosHachurados,num);
        if(num != -1){
          
        }
        
       return num;
              
       
    }
    
    public int gerarRandomHachurado(int pontoAtual, int totalPontos) {
        int num = pontoAtual;
        Random random = new Random();
        while(pontoAtual == num){
             num = random.nextInt(totalPontos);
        }
        return num;
    }
    
     public int verificarSeEstaEmPontosHachurados(int[] pontosHachurados ,int num) {
       
        for (int i = 0; i < pontosHachurados.length; i++) {
            if(pontosHachurados[i] == num){
                num = -1 ;
            }
        }
       return num;        
    }
     
   
    
   public int gerarRandomPontosRecarga2(int pontoAtual, int totalPontos) {
        int num = pontoAtual;
        Random random = new Random();
        while(pontoAtual == num ){
             num = random.nextInt(totalPontos);             
        }
       
       return num;
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

  
    public String relatorioMovimentos() {
        return "Regiao{" + "nomeRegiao=" + nomeRegiao +" , MovimentacoesRegiao=" + movimentacoesRegiao + '}';
    }

    
    public String relatorioMgsEnviadasRegiao() {
        return "Regiao{" + "nomeRegiao=" + nomeRegiao + ", mensagemEnviadaRergiao=" + mensagemEnviadaRergiao + '}';
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
             
        return 1;
    }
     
     

  
    
/*    public void movimentarDispositivo2(Dispositivo d ,PontoRegiao p){
         
        PontoRegiao pontoRetorno = this.retornarCelulaDoDispositivo(d); 
        
       
        System.out.println("O Dispositivo encontra-se na celula : X=>" + pontoRetorno.getEnderecoX() +" - " + " Y>"+pontoRetorno.getEnderecoY() );
         PontoRegiao pontoAtual =this.retornarPosicaoDispositivo(d);     
        
        String opcoes = this.retornarOpcoesMovimento(d, pontoAtual); 
        //retorna as opóes de movimento  
        System.out.println(opcoes);   
        //escolhe uma das opçes do retorno
        int movimentar = s.nextInt();
        PontoRegiao novoPonto = new PontoRegiao();
        novoPonto = this.pegarNovoponto(pontoAtual ,movimentar);
            
        pontoAtual.removeDispositivo(d);
        novoPonto.addDispositivo(d);
      
        
    }*/
    
    
    public int[] pegarPontoDestinoDispositivo( PontoRegiao p){
         
    
        
        
       int indiceX = p.getEnderecoX();
       int indiceY = p.getEnderecoY();
       
       int novoIndiceX = indiceX;
       int novoIndiceY = indiceY;
      
      int[] retornos = new int[2];
       
  
        Random random = new Random();
        int numMovimento =  random.nextInt(4);    
        
        switch (numMovimento){
            case 0:
              if(this.verificarSePodeMovimentar45x( p )==1){
                  retornos = this.getPonto45x(indiceX , indiceY);
                
                 
            
                }
              break; 
            case 1:
                if( this.verificarSePodeMovimentar135(p)==1){
                   retornos = this.getPonto135(indiceX , indiceY);
                  
                  
                 }
                
                break;
            case 2:
               if( this.verificarSePodeMovimentar225( p)==1){
                     retornos = this.getPonto225(indiceX , indiceY);
                   
               }
                break;

            case 3:
                if( this.verificarSePodeMovimentar315( p)==1){
                    retornos = this.getPonto315(indiceX , indiceY);
                  
                }
                break;
             case 4:  
                  
                 break;
                 
        }       
       
      return retornos;
             
    }
    
    
    public void movimentarVariosDispositivos(){
    //continuar aqui
    int limitePontoRegiao = this.pontosRegiao.size() - 1;
          for (int i = 0; i < limitePontoRegiao; i++) {   
               int limiteDispositivos =  this.pontosRegiao.get(i).getDispositivos().size() - 1;
              
                int[] retorno = new int[2];
                //pega o ponto de destino para adicionar o dispositivo a ser movimentado nele
                
                
               for (int j = 0; j < limiteDispositivos; j++) {
                   retorno = this.pegarPontoDestinoDispositivo(this.pontosRegiao.get(i));
                    int indiceXNovoPonto = retorno[0];
                    int indiceYNovoPonto = retorno[1];
                    
                   if((indiceXNovoPonto !=  this.pontosRegiao.get(i).getEnderecoX()) /*||(indiceYNovoPonto !=  this.pontosRegiao.get(i).getEnderecoY())*/ && this.getPontosRegiao().get(i).getDispositivos().get(j).getEhMovel()==1){
                        int k = 0;
                         while (!(indiceXNovoPonto ==  this.pontosRegiao.get(k).getEnderecoX()) &&  !(indiceYNovoPonto ==  this.pontosRegiao.get(k).getEnderecoY()) ){
                                 k++;
                         }


                         this.pontosRegiao.get(k).addDispositivo(this.pontosRegiao.get(i).getDispositivos().get(j));                         
                         this.pontosRegiao.get(i).removeDispositivo(this.pontosRegiao.get(i).getDispositivos().get(j));
                         this.pontosRegiao.get(k).getDispositivos().get(j).consomeBateriaMovimento();
                         limiteDispositivos--;
                         Movimentacoes mov = new Movimentacoes(this.pontosRegiao.get(i), this.pontosRegiao.get(k), this.pontosRegiao.get(i).getDispositivos().get(j));
                         this.addMovimentoRegiao(mov);
                         
                         
                   }else{
                       
                       break;
                   }   
                }
                  
            }               
    }
    
          
    public int[] pegarIdsDispositivsoDestinoMsg( PontoRegiao p, Dispositivo dispostivoOrigem ){
         //aqui2
       int idDispositivoQueVaiEnviar = dispostivoOrigem.getIdDispositivo();
       String msgEnvio = dispostivoOrigem.toString();
       MetodosAuxiliares m = new MetodosAuxiliares();
       int alcanceDispositivoOrigem = dispostivoOrigem.getAlcanceComunicacao();
       int min = 0;
       int max = p.getEnderecoX();
       int[] indicesDispositivosParaComunicar = new int[alcanceDispositivoOrigem *8];
       
        for (int i = 0; i < indicesDispositivosParaComunicar.length ; i++) {
            //pega os dispositivos para a direita
            if(idDispositivoQueVaiEnviar + (alcanceDispositivoOrigem) >= 0){
                indicesDispositivosParaComunicar[i] = idDispositivoQueVaiEnviar + (alcanceDispositivoOrigem);
                i++;
            }
             //pega os dispositivos para a esquerda
             if(idDispositivoQueVaiEnviar-( alcanceDispositivoOrigem) >=0){
                indicesDispositivosParaComunicar[i] = idDispositivoQueVaiEnviar-( alcanceDispositivoOrigem);
                i++;
             }
            //pega os dispositivos para a baixo
            if(idDispositivoQueVaiEnviar + this.getTamanhoY() >=0){
                indicesDispositivosParaComunicar[i] = idDispositivoQueVaiEnviar + this.getTamanhoY();
                i++;
            }
             //pega os dispositivos para a cima
             if(idDispositivoQueVaiEnviar - this.getTamanhoY() >= 0){
                indicesDispositivosParaComunicar[i] = idDispositivoQueVaiEnviar - this.getTamanhoY();
                i++;
             }
             //pega os dispositivos para a 45graus
             if((idDispositivoQueVaiEnviar - this.getTamanhoY() + alcanceDispositivoOrigem)>=0){
                indicesDispositivosParaComunicar[i] = idDispositivoQueVaiEnviar - this.getTamanhoY() + alcanceDispositivoOrigem;
                i++;
             }
            //pega os dispositivos para a 135graus
            if((idDispositivoQueVaiEnviar - this.getTamanhoY() + alcanceDispositivoOrigem)>=0){
                indicesDispositivosParaComunicar[i] = idDispositivoQueVaiEnviar - this.getTamanhoY() + alcanceDispositivoOrigem;
                i++;
            }    
            //pega os dispositivos para a 225graus
            if((idDispositivoQueVaiEnviar + this.getTamanhoY() - alcanceDispositivoOrigem)>= 0){
                indicesDispositivosParaComunicar[i] = idDispositivoQueVaiEnviar + this.getTamanhoY() - alcanceDispositivoOrigem;
                i++;    
            }
            //pega os dispositivos para a 315graus
            if((idDispositivoQueVaiEnviar + this.getTamanhoY() + alcanceDispositivoOrigem) >=0){
                indicesDispositivosParaComunicar[i] = idDispositivoQueVaiEnviar + this.getTamanhoY() + alcanceDispositivoOrigem;
                i++; 
            }
        }
              
       
        /*direita = Id+(alcanceDispositivo)
        *esquerda = Id-( alcanceDispositivo)
       * baixo = id + tamanhoY
        *cima = id – tamanhoY
        *45graus = id – tamanho + alcanceDispositivo
       * 135graus = id – tamanho  - alcanceDispositivo
        *225graus = id + tamanho  - alcanceDispositivo
        315graus = id + tamanho  + alcanceDispositivo*/

       
       
       return indicesDispositivosParaComunicar;
             
    }
     public void envioMsgVariosDispositivos(){
    
          int limitePontoRegiao = this.pontosRegiao.size() - 1;
          for (int i = 0; i < limitePontoRegiao; i++) {   
               int limiteDispositivos =  this.pontosRegiao.get(i).getDispositivos().size() - 1;
               //percorre todos os dispositivos
               for (int j = 0; j < limiteDispositivos; j++) {
                   
                   //int[] retornos = new int[];
                   //continuarAqui
                int[] idsDespositivosDestinoMsg =  this.pegarIdsDispositivsoDestinoMsg(this.pontosRegiao.get(i), this.pontosRegiao.get(i).getDispositivos().get(j));
                   
                //percorre todos os dispositifos de destino para cada dispositivo
                
                int limiteDispositivosDestino =  idsDespositivosDestinoMsg.length - 1;
                
                for (int z = 0; z< idsDespositivosDestinoMsg.length; z++) {
                       int l = idsDespositivosDestinoMsg[z];                     
                       this.pontosRegiao.get(i).getDispositivos().get(l).setStorage(this.pontosRegiao.get(i).getDispositivos().get(j).getStorage()); 

                      //  MensagensEnviadas m = new MensagensEnviadas(this.getPontosRegiao().get(i).getDispositivos().get(j).getIdDispositivo(), l, this.pontosRegiao.get(i).getDispositivos().get(j).getStorage());
                        MensagensEnviadas msg = new MensagensEnviadas(this.pontosRegiao.get(i).getDispositivos().get(j), this.pontosRegiao.get(i).getDispositivos().get(l), this.pontosRegiao.get(i).getDispositivos().get(j).getStorage());
                        this.addMensagemEnviadas(msg);

                        
                }

                          
             }
                  
        }               
        
    }
    
    
      public PontoRegiao retornarCelulaDoDispositivo(Dispositivo d) {
      
       PontoRegiao pontoAtual = new PontoRegiao();
       int limitePontoRegiao = this.pontosRegiao.size() -1;
          for (int i = 0; i < limitePontoRegiao; i++) {              
            
                LinkedList DispositivosDoPontoDaRegiao  = new  LinkedList<>();
                DispositivosDoPontoDaRegiao = this.pontosRegiao.get(i).getDispositivos();
                int limiteDispositivos = this.pontosRegiao.get(i).getDispositivos().size() -1;
                for (int j = 0; j < limiteDispositivos ; j++) {
                    if(this.pontosRegiao.get(i).getDispositivos().get(j).getIdDispositivo()== d.getIdDispositivo()){
                        
                        pontoAtual.setEnderecoX(this.pontosRegiao.get(i).getEnderecoX());
                        pontoAtual.setEnderecoY(this.pontosRegiao.get(i).getEnderecoX());
                    }
                            

                }
            
        }
        return pontoAtual;
          
    }

/*    public String retornarOpcoesMovimento(Dispositivo d,PontoRegiao pontoAtual ) {
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
*/
   /* public int verificarSePodeMovimentar45(Dispositivo d , PontoRegiao pontoAtual) {
       
        PontoRegiao novoPonto = pontoAtual;

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
    }*/
    
    public int verificarSePodeMovimentar45x( PontoRegiao pontoAtual) {
      

       if(
            (pontoAtual.getEnderecoX() > 0  && pontoAtual.getEnderecoY() >=0)&&
           (pontoAtual.getEnderecoX()<= this.tamanhoX && pontoAtual.getEnderecoY() < this.tamanhoY)
           ){
           
           // pontoAtual = this.getPonto45x( pontoAtual);

            if(pontoAtual.getEhInvalido() != 0 && pontoAtual.calcularNumDispositivosNoPonto() < 11){
                return 1;
            }else{
                //pontoAtual = pontoAntigo;
                return 0 ;        
            }

        }
      return 0;
    }
    
    public int verificarSePodeMovimentar135(PontoRegiao pontoAtual) {
        
      // PontoRegiao pontoAntigo =new PontoRegiao();
      //  pontoAntigo =pontoAtual;
       if(
            (pontoAtual.getEnderecoX() > 0  && pontoAtual.getEnderecoY() >0)&&
           (pontoAtual.getEnderecoX()<= this.tamanhoX && pontoAtual.getEnderecoY() <= this.tamanhoY)
           ){
           /* novoPonto.setEnderecoX(pontoAtual.getEnderecoX() +1);
            novoPonto.setEnderecoY(pontoAtual.getEnderecoY()+1);*/
           // pontoAtual = this.getPonto135(pontoAtual);

            if(pontoAtual.getEhInvalido() != 0 && pontoAtual.calcularNumDispositivosNoPonto() < 11){
                return 1;
            }else{
                // pontoAtual = pontoAntigo;
                return 0 ;        
            }

        }
        return 0;
    }

    public int verificarSePodeMovimentar225(PontoRegiao pontoAtual) {
      // PontoRegiao pontoAntigo =new PontoRegiao();
     //  pontoAntigo =pontoAtual;
        if(
            (pontoAtual.getEnderecoX() > 0  && pontoAtual.getEnderecoY() >=0)&&
           (pontoAtual.getEnderecoX()<= this.tamanhoX && pontoAtual.getEnderecoY() < this.tamanhoY)
           ){
            
           // pontoAtual = this.getPonto225(pontoAtual);
            if(pontoAtual.getEhInvalido() != 0 && pontoAtual.calcularNumDispositivosNoPonto() < 11){
                return 1;
            }else{
              //   pontoAtual = pontoAntigo;
                return 0 ;        
            }

        }
        return 0;
    }

    public int verificarSePodeMovimentar315(PontoRegiao pontoAtual ) {
      //  PontoRegiao pontoAntigo =new PontoRegiao();
      //  pontoAntigo =pontoAtual;

        if(
            (pontoAtual.getEnderecoX() >= 0  && pontoAtual.getEnderecoY() >=0)&&
           (pontoAtual.getEnderecoX()< this.tamanhoX && pontoAtual.getEnderecoY() < this.tamanhoY)
           ){
         //   pontoAtual =this.getPonto315( pontoAtual);

            if(pontoAtual.getEhInvalido() != 0 && pontoAtual.calcularNumDispositivosNoPonto() < 11){
                return 1;
            }else{
           //      pontoAtual = pontoAntigo;
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

    /*public PontoRegiao pegarNovoponto( PontoRegiao pontoAtual, int movimentar) {
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
    }*/
    
     public PontoRegiao getPonto45(PontoRegiao novoPonto ,PontoRegiao pontoAtual) {
        novoPonto.setEnderecoX(pontoAtual.getEnderecoX() -1);
        novoPonto.setEnderecoY(pontoAtual.getEnderecoY()+1);
        return novoPonto;
    }
     
     public int[] getPonto45x(int x, int y) {
         
        int xRetorno =x -1;
        int yRetorno = y+1;
       
        int[] retorno = new int[2];
        retorno[0] = xRetorno;
        retorno[1] = yRetorno;
        
        return retorno;
    }
    
     public int[] getPonto135(int x, int y) {
        
         
         int xRetorno = x -1;
         int yRetorno = y-1;      
       
        int[] retorno = new int[2];
        retorno[0] = xRetorno; 
        retorno[1] = yRetorno;
        
        return retorno;
        
    }

     public int[] getPonto225(int x, int y) {
        
        
         int xRetorno = x +1;
         int yRetorno = y-1;  
         
          int[] retorno = new int[2];
        retorno[0] = xRetorno; 
        retorno[1] = yRetorno;
        
        return retorno;
       
    }
     
    public int[] getPonto315(int x, int y) {
       
        int xRetorno = x +1;
        int yRetorno = y+1;  
         
        int[] retorno = new int[2];
        retorno[0] = xRetorno; 
        retorno[1] = yRetorno;
        
        return retorno;
    }

    
    
    public int retornarDistanciaEntrePontos(PontoRegiao pontoOrigem, PontoRegiao pontoDestino ) {
       int distancia = 0;
       int xPonto1  = pontoOrigem.getEnderecoX();
       int yPonto1 = pontoOrigem.getEnderecoY();
       int xPonto2  = pontoDestino.getEnderecoX();
       int yPonto2 = pontoDestino.getEnderecoY();    
         
        
        for (int i = xPonto1; i <  xPonto2; i++) {
            distancia++;
            for (int j = yPonto1; i <  yPonto2; j++) {
                 distancia++;

            }
        }
      return distancia;        
    }
    
    public void gerarDspositivos(){
        
           
                  for (PontoRegiao pontoRegiao : this.getPontosRegiao()) {
                      for (int k = 0; k < 2; k++) {
                          Smartphone smartphone = new Smartphone(1, this);
                          Tablet tablet = new Tablet(1, this);
                          SensorDeLuminosidade sensorLuminosidade = new SensorDeLuminosidade(1, this);
                          SensorDeTemperatura sensorDetemperatura = new SensorDeTemperatura(1, this);

                          pontoRegiao.addDispositivo(smartphone);
                          pontoRegiao.addDispositivo(sensorLuminosidade);
                          pontoRegiao.addDispositivo(sensorDetemperatura);
                          pontoRegiao.addDispositivo(tablet);
                        }
                      
                    }

              
    }
    
  
  
    
}
