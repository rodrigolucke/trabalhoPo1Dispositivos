/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;
import java.util.LinkedList;
import java.util.Scanner;
import trabalho1.Dispositivos.SensorDeLuminosidade;
import trabalho1.Dispositivos.Smartphone;
/**
 *
 * @author home
 */
public class Trabalho1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       Scanner s = new Scanner(System.in);
        
       Regiao r1 = new Regiao(1);
       
       
        r1.gerarDspositivos();
        
        r1.movimentarVariosDispositivos();
        r1.envioMsgVariosDispositivos();
        r1.relatorioMovimentos();
        r1.relatorioMgsEnviadasRegiao();
        
       
       
        
         
        
             
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
    

