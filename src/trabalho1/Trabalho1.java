/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;
import trabalho1.Dispositivos.SensorDeLuminosidade;
import trabalho1.Dispositivos.Smartphone;
/**
 *
 * @author home
 */
public class Trabalho1 {
 
 public static String warnings = "";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       
        // TODO code application logic here
         String saida ="";
         String saidaTxt ="";
          Scanner s = new Scanner(System.in);
          Regiao r1 = new Regiao(1);
           r1.gerarDispositivos();   
        for (int i = 0; i < 50; i++) {
                   
                         
                     r1.movimentarVariosDispositivos();
                     r1.racarregarDispositivosEmPontosRecarga();
                     r1.envioMsgVariosDispositivos();
                     //r1.envioMsgVariosDispositivos2();
                     
                     r1.fazerLeituraDosSensores();
                                         
                   
      } 
                     saidaTxt += r1.relatorioMovimenacoes();
                     saidaTxt +=r1.relatorioMgsEnviadasRegiao();
                     
       
                     saidaTxt +=r1.relatorioDispositivosDesligados();
                     saidaTxt +="%n"+r1.relatorioLeituras();
                     saidaTxt+="%n"+r1.relatorioDispositivosDesligados();
                     saidaTxt+="%n"+Trabalho1.warnings;
                     saidaTxt +="%n"+r1.totalMovimentacoes();
                     saidaTxt +="%n"+r1.totalComunicacoes();
                     saidaTxt +="%n"+r1.totalEnergiaRecarregada()+"%n";
                     
                     saida +=r1.totalMovimentacoes();
                     saida +="\n"+r1.totalComunicacoes();
                     saida +="\n"+r1.totalEnergiaRecarregada()+"\n";
                    String regiao =r1.toString(); 
                    System.out.println(saida);
                    System.out.println(r1);
                    FileWriter arq = new FileWriter("C:\\Users\\home\\Documents\\NetBeansProjects\\Trabalho1\\dist\\Relatorio.txt");
                    
                    PrintWriter gravarArq = new PrintWriter(arq);
                    gravarArq.printf("+--Resultado Simulação--+%n");
                    gravarArq.printf("%n"+saidaTxt+"%n");
                    gravarArq.printf("%n+-------------+%n");
                    arq.close();
                    
                    FileWriter arq2 = new FileWriter("C:\\Users\\home\\Documents\\NetBeansProjects\\Trabalho1\\dist\\RelatorioRegiao.txt");
                    
                    PrintWriter gravarArq2 = new PrintWriter(arq2);
                    gravarArq.printf("+--Resultado Simulação--+%n");
                    gravarArq.printf("%n"+regiao+"%n");
                    gravarArq.printf("%n+-------------+%n");
                    arq2.close();
                    
         
        
             
       /*int op = -1;
              
        Operacoes operacao = new Operacoes();
     while(op != 0){
         op= operacao.listarOperacoesIniciais();
         
      
         
        switch (op){
            case 1:
                operacao.listarOperacoesPontosRegiao();

                break;
           case 2:

               break;
       
      
          }
    }
    }   */
      // s1.gerarIdValidoDispositivo(r1);
      //r1.movimentarDispositivo(s1);
       

      /* for (PontoRegiao pontoRegiao : r1.getPontosRegiao()) {
        
       }*/
    
    }
}
    

