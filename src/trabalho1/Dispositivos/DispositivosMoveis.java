/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.Dispositivos;

import java.util.Scanner;
import trabalho1.Regiao;

/**
 *
 * @author rodrigolucke
 */
public class DispositivosMoveis extends Dispositivo{
    private int numDispositivo;

    public DispositivosMoveis( ) {
        super();
        System.out.println("Digite um numero para este dispositivo:");
        this.numDispositivo = s.nextInt();
    }

    public DispositivosMoveis(int automatico, Regiao r) {
        super(automatico, r);        
       // this.numDispositivo = this.gerarNumero();
       this.numDispositivo = 9999999;
       this.setEhMovel(1);
    }

    @Override
    public void setEhMovel(int ehMovel) {
        super.setEhMovel(ehMovel); //To change body of generated methods, choose Tools | Templates.
    }

    
    public DispositivosMoveis(int numDispositivo) {
        super();
        this.numDispositivo = numDispositivo;
       
    }

    public void setNumDispositivo(int numDispositivo) {
        this.numDispositivo = numDispositivo;
    }

    @Override
    public void consomeBateria() {
        super.consomeBateria(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void gerarIdValidoDispositivo(Regiao r) {
        super.gerarIdValidoDispositivo(r); //To change body of generated methods, choose Tools | Templates.
    }

   
    @Override
    public String toString() {
        return super.toString() + ", numDispositivo=" + this.numDispositivo; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setIdDispositivo(int idDispositivo) {
        super.setIdDispositivo(idDispositivo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIdDispositivo() {
        return super.getIdDispositivo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getEhMovel() {
        return super.getEhMovel(); //To change body of generated methods, choose Tools | Templates.
    }

   
    @Override
    public void setAlcanceComunicacao(int alcanceComunicacao) {
        super.setAlcanceComunicacao(alcanceComunicacao); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getAlcanceComunicacao() {
        return super.getAlcanceComunicacao(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setStorage(String storage) {
        super.setStorage(storage); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getStorage() {
        return super.getStorage(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCor(String cor) {
        super.setCor(cor); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCor() {
        return super.getCor(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPeso(int peso) {
        super.setPeso(peso); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPeso() {
        return super.getPeso(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCargaBateria(int cargaBateria) {
        super.setCargaBateria(cargaBateria); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCargaBateria() {
        return super.getCargaBateria(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void gerarNumero(){
     // Random random = new Random(); 
   
        int num =0;
        int max = 9999999;
        int min = 8000000;
        num = (int) Math.floor(Math.random() * (max - min + 1) + min);

          this.setNumDispositivo(num);
         
    }
    
    
}
