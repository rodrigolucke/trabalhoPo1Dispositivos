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
import trabalho1.Dispositivos.Automoveis;
import trabalho1.Dispositivos.Dispositivo;
import trabalho1.Dispositivos.Geladeira;
import trabalho1.Dispositivos.Sensor;
import trabalho1.Dispositivos.SensorDeUmidade;
import trabalho1.Dispositivos.SensorDeLuminosidade;
import trabalho1.Dispositivos.SensorDeTemperatura;
import trabalho1.Dispositivos.Smartphone;
import trabalho1.Dispositivos.Tablet;
import trabalho1.Dispositivos.Vants;
import trabalho1.MetodosAuxiliares;
import trabalho1.Leituras;

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
    private LinkedList<Leituras> leitura = new LinkedList<Leituras>();
    private int ativa;
    Scanner s = new Scanner(System.in);
    MetodosAuxiliares m = new MetodosAuxiliares();
    
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
          int num = m.gerarNumero(4 ,7 );
          this.tamanhoX = num;         
          this.tamanhoY = num;
          this.pontosRegiao = new LinkedList<>();
          this.gerarPontosNaRegiao();
          this.ativa = 1;
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
     
     public void addLeitura(Leituras l ) {
        this.leitura.add(l);
      
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

    public LinkedList<Leituras> getLeitura() {
        return leitura;
    }

    public void setLeitura(LinkedList<Leituras> leitura) {
        this.leitura = leitura;
    }

    public int getAtiva() {
        return ativa;
    }

    public void setAtiva(int ativa) {
        this.ativa = ativa;
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
        return "Regiao{" + "nomeRegiao=" + nomeRegiao + ", tamanhoX=" + tamanhoX + ", tamanhoY=" + tamanhoY + ", pontosRegiao=" + pontosRegiao +  ", ativa=" + ativa + '}';
    }
    
    
   

  
   

    public String relatorioMovimenacoes() {
       
        String movimentacoes = "";
        for (Movimentacoes movimento : this.getMovimentacoesRegiao()) {
             System.out.println(movimento+"\n");
             movimentacoes += movimento+"%n%n";
        }
        return movimentacoes;
           
     }   

      public String relatorioLeituras() {
       
        String leituraSaida ="";
        for (Leituras leitura : this.getLeitura()) {
             System.out.println(leitura+"\n");
             leituraSaida+="%n "+leitura+"%n%n";
        }
        return leituraSaida;
           
     }   
            
     

    
    public String relatorioMgsEnviadasRegiao() {
        String msgEnviadaSaida ="";
        for (MensagensEnviadas mensagem : this.getMensagemEnviadaRergiao()) {
            System.out.println(mensagem+"\n");
            msgEnviadaSaida+="%n "+mensagem+"%n%n";
                
            
        }
        return msgEnviadaSaida;
        
    }
    
    
    
    
    
     public String addPontoNaRegiao(PontoRegiao p , int testa) {
         
        if( testa == -1 || (verificarSePodeAdicionar() == 1 && testa == 1) ){
            this.pontosRegiao.add(p);
            
        }else{
            
              return "Regiao{" + "nomeRegiao=" + nomeRegiao + ",tem tamanho de " +calcularTamanhoRegiao()+",e ja possui o numero maximo de celulas" +'}';
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
  
    
    public int[] pegarPontoDestinoDispositivo( PontoRegiao p ,Dispositivo d){
        
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
                }else
                  Trabalho1.warnings+=" %n IdDispositivo= "+d.getIdDispositivo()+" nao pode ingressar no ponto!%n";
;             break; 
            case 1:
                if( this.verificarSePodeMovimentar135(p)==1){
                   retornos = this.getPonto135(indiceX , indiceY);
                 }else
                  Trabalho1.warnings+=" %n IdDispositivo= "+d.getIdDispositivo()+"  nao pode ingressar no ponto!%n";
                 break;
            case 2:
               if( this.verificarSePodeMovimentar225( p)==1){
                     retornos = this.getPonto225(indiceX , indiceY);
                }else
                  Trabalho1.warnings+=" %n IdDispositivo= "+d.getIdDispositivo()+" nao pode ingressar no ponto!%n";
                break;
            case 3:
                if( this.verificarSePodeMovimentar315( p)==1){
                    retornos = this.getPonto315(indiceX , indiceY);                  
                }else
                  Trabalho1.warnings+="%n IdDispositivo= "+d.getIdDispositivo()+" nao pode ingressar no ponto!%n";
                break;
             case 4:                    
                 break;                 
        }              
      return retornos;             
    }
     public void movimentarVariosDispositivos(){
        
          int limitePontoRegiao = this.pontosRegiao.size() ;
          for (int i = 0; i < limitePontoRegiao; i++) {   
               int limiteDispositivos =  this.pontosRegiao.get(i).calcularNumDispositivosNoPonto();
               //percorre todos os dispositivos
               int movimenta =  m.gerarNumero(0, 10);
               if(movimenta >2){
                    for (int j = 0; j < limiteDispositivos; j++) {
                        if(this.pontosRegiao.get(i).getDispositivos().get(j).getEhMovel() ==1){
                            if(this.pontosRegiao.get(i).getDispositivos().get(j).getCargaBateria() <= 0){

                                Trabalho1.warnings +=("%n%nO dispositivo " + this.pontosRegiao.get(i).getDispositivos().get(j).getIdDispositivo()+" foi desligado por falta de energia"); 
                                this.pontosRegiao.get(i).getDispositivos().get(j).setStatus(-1);
                                break;
                            }
                        
                             //if(this.pontosRegiao.get(i).getDispositivos().get(j).getIdDispositivo() != 0 ){  
                            int[] retorno = new int[2];
                            retorno = this.pegarPontoDestinoDispositivo(this.pontosRegiao.get(i),this.pontosRegiao.get(i).getDispositivos().get(j));
                            int indiceXNovoPonto = retorno[0];
                            int indiceYNovoPonto = retorno[1];

                            if(this.pontosRegiao.get(i).getEnderecoX() != indiceXNovoPonto){
                               for (PontoRegiao pontoRegiao : this.getPontosRegiao()) {

                                          if(indiceXNovoPonto == pontoRegiao.getEnderecoX() && indiceYNovoPonto == pontoRegiao.getEnderecoY()){

                                              Movimentacoes mov = new Movimentacoes(this.pontosRegiao.get(i), pontoRegiao, this.pontosRegiao.get(i).getDispositivos().get(j));
                                              this.addMovimentoRegiao(mov);
                                              pontoRegiao.addDispositivo(this.pontosRegiao.get(i).getDispositivos().get(j));
                                              this.pontosRegiao.get(i).getDispositivos().get(j).consumirBateriaMovimento();
                                              this.pontosRegiao.get(i).removeDispositivo(this.pontosRegiao.get(i).getDispositivos().get(j));
                                              limiteDispositivos--;

                                             break;

                                          }
                               }          

                            }
                    }
                }       

             }

         }
                        
                  
     }
     
    public void envioMsgVariosDispositivos(){
            
          int limitePontoRegiao = this.pontosRegiao.size() ;
          for (int i = 0; i < limitePontoRegiao; i++) {   
               int limiteDispositivos =  this.pontosRegiao.get(i).getDispositivos().size() ;
               //percorre todos os dispositivos
                 int comunica =  m.gerarNumero(0, 10);
                    if(comunica >9){
                    for (int j = 0; j < limiteDispositivos; j++) {
                        if(comunica >9){
                         if(this.pontosRegiao.get(i).getDispositivos().get(j).getStatus()!=-1){
                           
                                    int minY = 0;
                                    int minX = 0;
                                    int maxY = 0;
                                    int maxX = 0;
                                    minX = this.pontosRegiao.get(i).getEnderecoX() -  this.pontosRegiao.get(i).getDispositivos().get(j).getAlcanceComunicacao();
                                    if( minX< 0){
                                        minX = 0;
                                    }    
                                    minY = this.pontosRegiao.get(i).getEnderecoY() - this.pontosRegiao.get(i).getDispositivos().get(j).getAlcanceComunicacao();
                                    if(minY < 0){
                                        minY = 0;
                                    }    
                                    maxX = this.pontosRegiao.get(i).getEnderecoX()+this.pontosRegiao.get(i).getDispositivos().get(j).getAlcanceComunicacao();
                                    if(maxX > this.getTamanhoX()){
                                        maxX =this.getTamanhoX();
                                    }
                                    maxY =this.pontosRegiao.get(i).getEnderecoY() + this.pontosRegiao.get(i).getDispositivos().get(j).getAlcanceComunicacao();
                                    if(maxY > this.getTamanhoY()){
                                        maxY =this.getTamanhoY();
                                    }
                                   LinkedList<PontoRegiao> pontosRegiaoDispositivosComunicar = new LinkedList<PontoRegiao>();
                                   for (int x = minX; x <= maxX; x++) {

                                       for (int y = minY; y <= maxY; y++) {
                                           for (PontoRegiao pontoRegiao : this.pontosRegiao) {
                                               if(pontoRegiao.getEnderecoX() == x && pontoRegiao.getEnderecoY()==y /*&&(x!= this.getPontosRegiao().get(i).getEnderecoX() &&x!= this.getPontosRegiao().get(i).getEnderecoY())*/){
                                                   pontosRegiaoDispositivosComunicar.add(pontoRegiao); 
                                                   break;
                                               }
                                           }     
                                       } 
                                    }
                                    for (PontoRegiao pontoRegiao : pontosRegiaoDispositivosComunicar) {
                                        int enviaMsg =  m.gerarNumero(0, 10);
                                        if(enviaMsg >8){
                                            for (Dispositivo dispositivo : pontoRegiao.getDispositivos()) {
                                                   if(this.pontosRegiao.get(i).getDispositivos().get(j).getIdDispositivo() != dispositivo.getIdDispositivo()){    
                                                        // mensagem do despositivo origem para destino

                                                        if( dispositivo.getTamStorage()<=0){
                                                             Trabalho1.warnings+="%n Espaço disponivel no dispositivo de ID="+dispositivo.getIdDispositivo()+" é apenas"+ dispositivo.getTamStorage()+", será apagado o storage atual para inserir novasinformaçoes%n";
                                                             dispositivo.setTamStorage(dispositivo.getTamStorage());
                                                             dispositivo.setStorage("");

                                                        }
                                                        MensagensEnviadas msg = new MensagensEnviadas(this.pontosRegiao.get(i).getDispositivos().get(j),dispositivo, this.pontosRegiao.get(i).getDispositivos().get(j).getTextoStrage(this));
                                                        //mensagem do dispositivo destino para origem
                                                       // MensagensEnviadas msg2 = new MensagensEnviadas(dispositivo,this.pontosRegiao.get(i).getDispositivos().get(j), this.pontosRegiao.get(i).getDispositivos().get(j).getTextoStrage(this));
                                                        dispositivo.consumirBateriaComunicacao();
                                                        dispositivo.setStorage( this.pontosRegiao.get(i).getDispositivos().get(j).getStorage()  );
                                                        this.pontosRegiao.get(i).getDispositivos().get(j).consumirBateriaComunicacao();
                                                        dispositivo.setTamStorage( dispositivo.getTamStorage() -100);
                                                        this.addMensagemEnviadas(msg);
                                                       // this.addMensagemEnviadas(msg2);

                                                   }
                                                }
                                         }
                                    }

                            }
                    } 
                }   
            }
                        
                  
        }
     }
    
    
    
    
    //somente na linha da matriz
   /*  public void envioMsgVariosDispositivos2(){
    
          int limitePontoRegiao = this.pontosRegiao.size() - 1;
          for (int i = 0; i < limitePontoRegiao; i++) {   
               int limiteDispositivos =  this.pontosRegiao.get(i).getDispositivos().size();
               //percorre todos os dispositivos
               for (int j = 0; j < limiteDispositivos; j++) {
                   
                 
                  int indexInicioRange  = j - this.pontosRegiao.get(i).getDispositivos().get(j).getAlcanceComunicacao(); 
                  int indexFimRange = j + this.pontosRegiao.get(i).getDispositivos().get(j).getAlcanceComunicacao();
                  if(indexInicioRange < 0){
                      indexInicioRange = 0;
                  } 
                  if(indexFimRange > this.pontosRegiao.size() ){
                      indexFimRange = this.pontosRegiao.size();
                  } 
                  
                  
                  for (int k = indexInicioRange; k <= indexFimRange; k++) {
                      int limiteDispositivosDestino =  this.pontosRegiao.get(k).getDispositivos().size();
                       
                        for (Dispositivo dispositivo : this.pontosRegiao.get(k).getDispositivos()) {
                          
                            if(this.pontosRegiao.get(i).getDispositivos().get(j).getIdDispositivo() != dispositivo.getIdDispositivo()){    
                                MensagensEnviadas msg = new MensagensEnviadas(this.pontosRegiao.get(i).getDispositivos().get(j),dispositivo, this.pontosRegiao.get(i).getDispositivos().get(j).getStorage());
                               if( dispositivo.getTamStorage()<=0){
                                   System.out.println("Espaço disponivel é muito pequeno, será apagado o storage atual para inserir novasinformaçoes");
                                    dispositivo.setTamStorage(1000);
                               }else{
                                     dispositivo.setTamStorage( dispositivo.getTamStorage() -10);
                                     this.addMensagemEnviadas(msg);
                               }
                            } 
                        }
                       
                          
                   }
               }                  
                                 
                                      
          }
     }*/
     
     public void fazerLeituraDosSensores(){
         
          for (PontoRegiao pontoRegiao : this.getPontosRegiao()) {
                for (Dispositivo dispositivo : pontoRegiao.getDispositivos()) {
                    
                    String leitura = "";
                     //   System.out.println(dispositivo.getClass());
                    if(dispositivo.getClass() == SensorDeUmidade.class){

                      dispositivo.setStorage("Leitura :Umidade atual = " +pontoRegiao.getUmidade());
                      
                    }
                     if(dispositivo.getClass() == SensorDeTemperatura.class){

                      dispositivo.setStorage("Leitura :Temperatura atual = " +pontoRegiao.getTemperatura());
                    } 
                     if(dispositivo.getClass() == SensorDeLuminosidade.class){

                      dispositivo.setStorage("Leitura :Luminosidade atual = " +pontoRegiao.getLuminosidade());
                    }
                     if(dispositivo.getStorage() != null){
                        leitura = dispositivo.getStorage();

                        Leituras l = new Leituras(pontoRegiao, dispositivo, leitura);
                        this.addLeitura(l);
                     }
                }
            
          }
     }
    
      public String retornarCelulaDoDispositivo(Dispositivo d) {
      
     String retorno ="";
      for (PontoRegiao pontoRegiao : this.getPontosRegiao()) {  
          for (Dispositivo dispositivo : pontoRegiao.getDispositivos()) { 
                    if(dispositivo.getIdDispositivo() == d.getIdDispositivo()){
                         retorno= "["+pontoRegiao.getEnderecoX()+", "+pontoRegiao.getEnderecoY()+"]";
                    }
                } 
      }  
                  
        return retorno;
          
    }


    
    public int verificarSePodeMovimentar45x( PontoRegiao pontoAtual) {  
       if(
            (pontoAtual.getEnderecoX() > 0  && pontoAtual.getEnderecoY() >=0)&&
           (pontoAtual.getEnderecoX()<= this.tamanhoX && pontoAtual.getEnderecoY() < this.tamanhoY)
           ){
            if(pontoAtual.getEhInvalido() != 0 && pontoAtual.calcularNumDispositivosNoPonto() < 11){
                return 1;
            }else{             
                return 0 ;        
            }
        }
      return 0;
    }
    
    public int verificarSePodeMovimentar135(PontoRegiao pontoAtual) {        
     
       if(
            (pontoAtual.getEnderecoX() > 0  && pontoAtual.getEnderecoY() >0)&&
           (pontoAtual.getEnderecoX()<= this.tamanhoX && pontoAtual.getEnderecoY() <= this.tamanhoY)
           ){   
                if(pontoAtual.getEhInvalido() != 0 && pontoAtual.calcularNumDispositivosNoPonto() < 11){
                    return 1;
                }else{
                    return 0 ;        
                }
        }
        return 0;
    }

    public int verificarSePodeMovimentar225(PontoRegiao pontoAtual) {
        if(
            (pontoAtual.getEnderecoX() > 0  && pontoAtual.getEnderecoY() >=0)&&
           (pontoAtual.getEnderecoX()<= this.tamanhoX && pontoAtual.getEnderecoY() < this.tamanhoY)
           ){
                if(pontoAtual.getEhInvalido() != 0 && pontoAtual.calcularNumDispositivosNoPonto() < 11){
                    return 1;
                }else{
                    return 0 ;        
                }
        }
        return 0;
    }

    public int verificarSePodeMovimentar315(PontoRegiao pontoAtual ) {
        if(
            (pontoAtual.getEnderecoX() >= 0  && pontoAtual.getEnderecoY() >=0)&&
           (pontoAtual.getEnderecoX()< this.tamanhoX && pontoAtual.getEnderecoY() < this.tamanhoY)
           ){
                if(pontoAtual.getEhInvalido() != 0 && pontoAtual.calcularNumDispositivosNoPonto() < 11){
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
    
    public void gerarDispositivos(){     
        for (PontoRegiao pontoRegiao : this.getPontosRegiao()) {                    
              if(pontoRegiao.getTipoPOnto() != 0 && pontoRegiao.calcularNumDispositivosNoPonto()<10){
                   Smartphone smartphone = new Smartphone(1, this);
                   Tablet tablet = new Tablet(1, this);
                    Smartphone smartphone2 = new Smartphone(1, this);
                   Tablet tablet2 = new Tablet(1, this);
                    Smartphone smartphone3 = new Smartphone(1, this);
                   Tablet tablet3 = new Tablet(1, this);
                   SensorDeLuminosidade sensorLuminosidade = new SensorDeLuminosidade(1, this);
                   SensorDeTemperatura sensorDetemperatura = new SensorDeTemperatura(1, this);
                   SensorDeUmidade sensorDeUmidade = new SensorDeUmidade(1, this);
                   Vants vant = new Vants(1, this, pontoRegiao.getEnderecoX(), pontoRegiao.getEnderecoY());
                   Geladeira geladeira = new Geladeira(1, this);
                   Automoveis automovel = new Automoveis(1, this);
                   
                  
                   pontoRegiao.addDispositivo(sensorLuminosidade);
                   pontoRegiao.addDispositivo(sensorDetemperatura);
                   pontoRegiao.addDispositivo(sensorDeUmidade);
                   pontoRegiao.addDispositivo(tablet); 
                   pontoRegiao.addDispositivo(smartphone);
                   pontoRegiao.addDispositivo(tablet2); 
                   pontoRegiao.addDispositivo(smartphone2);
                   pontoRegiao.addDispositivo(tablet3); 
                   pontoRegiao.addDispositivo(smartphone3);
                   
                   pontoRegiao.addDispositivo(vant);
                   pontoRegiao.addDispositivo(geladeira);
                   pontoRegiao.addDispositivo(automovel);
                   
                  
              }
         }
        this.gerarTodosTextosStorage();

    }
    
    public void racarregarDispositivosEmPontosRecarga(){
        for (PontoRegiao pontoRegiao : this.getPontosRegiao()) {
            if(pontoRegiao.getTipoPOnto() == 2){//tipo 2 é de recarga
                for (Dispositivo dispositivo : pontoRegiao.getDispositivos()) {
                        dispositivo.setCargaBateria(dispositivo.getTamanhoMaximoBateria());
                        if(dispositivo.getStatus() ==-1){
                             Trabalho1.warnings +="%n%n O dispositivo com IDdispositivo= " +dispositivo.getIdDispositivo()+" estava desligado e foi ligado novamente.";
                            dispositivo.setStatus(1);
                        }
                }
            }            
      
        }
    }
    public int retornarTotalDeRecargas(){
        int valor =0;
        for (PontoRegiao pontoRegiao : this.getPontosRegiao()) {
            if(pontoRegiao.getTipoPOnto() == 2){//tipo 2 é de recarga
                for (Dispositivo dispositivo : pontoRegiao.getDispositivos()) {
                        valor = valor + (dispositivo.getTamanhoMaximoBateria() - dispositivo.getCargaBateria());
                        dispositivo.setCargaBateria(dispositivo.getTamanhoMaximoBateria());
                        if(dispositivo.getStatus() ==-1){
                            dispositivo.setStatus(1);
                        }
                }
            }            
      
        }
        return valor;
    }
    
    public void gerarTodosTextosStorage(){
        
         for (PontoRegiao pontoRegiao : this.getPontosRegiao()) {
                for (Dispositivo dispositivo : pontoRegiao.getDispositivos()) {                    
                    dispositivo.setStorage(dispositivo.getTextoStrage(this));
                }
         }               
    }

    public String totalMovimentacoes() {
        int totalMovimento = 0;
        
        
        
        for (Movimentacoes movimento : this.getMovimentacoesRegiao()) {
            
             totalMovimento = totalMovimento+ this.getTamanhoY();
        }
        return "Foram efetuadas "+this.movimentacoesRegiao.size()+" movimentações na região, somano um total de "+ totalMovimento +" unidades de distância";
    }

    public String totalComunicacoes() {
        int totalComunicacoes = 0;
        for (MensagensEnviadas mensagem : this.getMensagemEnviadaRergiao()) {
            
             totalComunicacoes = totalComunicacoes+ 1;
        }
        return "Foram efetuadas "+totalComunicacoes+" envios de mensagem na região.";
    }

    public String totalEnergiaRecarregada() {
        
        
        return "Foram recarregadas um total de "+this.retornarTotalDeRecargas() + " unidades de bateria. ";
    }

    public String relatorioDispositivosDesligados() {
        String dispositivosDesligados ="%n\n ____Lista de dispositivos Desligados:%n\n";
         for (PontoRegiao pontoRegiao : this.getPontosRegiao()) {
                for (Dispositivo dispositivo : pontoRegiao.getDispositivos()) { 
                    if(dispositivo.getStatus() ==-1){
                       dispositivosDesligados +="%n\n "+" IDDispositivo= "+dispositivo.getIdDispositivo()+" na celula"+this.retornarCelulaDoDispositivo(dispositivo)+" está desligado.%n\n";
                        
                    }
                }
         }    
        return dispositivosDesligados;
    }
    
}
