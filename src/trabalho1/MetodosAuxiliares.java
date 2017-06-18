/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

/**
 *
 * @author home
 */
public class MetodosAuxiliares {

    public MetodosAuxiliares() {
    }
    
    
    
      public int gerarNumero( int min, int max){
     // Random random = new Random(); 
   
        int num =0;
     
        num = (int) Math.floor(Math.random() * (max - min + 1) + min);

          return num;
         
    }
      public String retornaCor(){
          String cor = "";
          int numCor = this.gerarNumero(0, 10);
           switch (numCor){
            case 0:
                cor= "Branco";
            case 1:
                cor= "Amarelo";   
            case 2:
                cor= "Verde";
            case 3:
                cor= "Laranja";  
            case 4:                    
                cor= "Preto";    
            case 5:
                cor= "Cinza";  
            case 6:
                cor= "Prata";
            case 7:
                cor= "Ciano";
            case 8:
                cor= "Vermelho";
            case 9:
                cor= "Rosa";
            case 10:
                cor= "Transparente";
        } 
        return null;
        
      }
      
}
