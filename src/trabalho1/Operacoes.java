/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import java.util.Scanner;

/**
 *
 * @author rodrigolucke
 */
public class Operacoes {
    

    public int listarOperacoesIniciais() {
      Scanner s = new Scanner(System.in);
      
    int op =10;
    System.out.println("\n");
    System.out.println("|______________________________|\n");
    System.out.println("|         Simulador de IOT     |\n");
    System.out.println("|______________________________|\n");
    System.out.println("|           1-Listar Regiões   |\n");
    System.out.println("|           2-Sair             |\n");
    System.out.println("   INFORME A OPCAO DESEJADA:    \n\n");
    System.out.println("Digite:");
    s.nextInt(op);
    
    return op;
    }
    
    public String listarOperacoesIniciais2() {
      Scanner s = new Scanner(System.in);
    String menu = "";
   	menu+=("\n");
    menu+=("|______________________________|\n");
    menu+=("|         Simulador de IOT     |\n");
    menu+=("|______________________________|\n");
    menu+=("|           1-Listar Regiões   |\n");
    menu+=("|           2-Sair             |\n");
    menu+=("|______________________________|\n");
    menu+=("   INFORME A OPCAO DESEJADA:    \n\n");
   
    
    return menu;
    }
    
    
   public int listarOperacoesPontosRegiao() {
      Scanner s = new Scanner(System.in);
    int op =-1;
    System.out.println("\n");
    System.out.println("|______________________________|\n");
    System.out.println("|         Simulador de IOT     |\n");
    System.out.println("|______________________________|\n");
    System.out.println("|  1-Listar Pontos de regiao   |\n");
    System.out.println("|  2-Voltar                    |\n");
    System.out.println("|______________________________|\n");
    System.out.println("   INFORME A OPCAO DESEJADA:    \n\n--->");
    System.out.println("Digite:");
    s.nextInt(op);
    
    return op;
    }
    
    
    
}
