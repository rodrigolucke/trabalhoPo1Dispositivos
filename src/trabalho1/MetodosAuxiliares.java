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
      //  int max = 10;
      //  int min = 5;
        num = (int) Math.floor(Math.random() * (max - min + 1) + min);

          return num;
         
    }
}
