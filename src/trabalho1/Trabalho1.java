/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;
import java.util.LinkedList;
import java.util.Scanner;
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
       
       LinkedList PontosRegiaoR1  = new  LinkedList<>();
       PontosRegiaoR1 = r1.getPontosRegiao();
               
        
    }
    
}
