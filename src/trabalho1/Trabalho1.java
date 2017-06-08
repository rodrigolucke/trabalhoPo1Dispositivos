/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;
import java.util.LinkedList;
import java.util.Scanner;
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
        
       Regiao r1 = new Regiao();
       
        LinkedList pontosR1 = r1.getPontosRegiao();
       
        System.out.println(pontosR1);
        
     //  Smartphone s1 =  new Smartphone( r1 );
      //r1.movimentarDispositivo(s1);
       
      
       
    
    }
    
}
