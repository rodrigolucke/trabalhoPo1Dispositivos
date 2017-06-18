/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.Dispositivos;

import java.util.Scanner;
import trabalho1.MetodosAuxiliares;
import trabalho1.Regiao;

/**
 *
 * @author rodrigolucke
 */
public class DispositivosMoveis extends Dispositivo{
    private int numDispositivo;

   

    public DispositivosMoveis(int automatico, Regiao r) {
       super(automatico, r);         
       this.setTamanhoMaximoBateria(700);
       MetodosAuxiliares m = new MetodosAuxiliares();
       this.numDispositivo = m.gerarNumero(800000000, 999999999);
       super.setCargaBateria(m.gerarNumero(100, 700)); 
       //1 - movel 0 -imovel
       super.setEhMovel(1);
    }

    @Override
    public void setEhMovel(int ehMovel) {
       super.setEhMovel(ehMovel);//To change body of generated methods, choose Tools | Templates.
    }

    
    public DispositivosMoveis(int numDispositivo) {
        super();
        this.numDispositivo = numDispositivo;
       
    }

    public void setNumDispositivo(int numDispositivo) {
        this.numDispositivo = numDispositivo;
    }

    @Override
    public void consumirBateria() {
        super.consumirBateria(); //To change body of generated methods, choose Tools | Templates.
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
        int max = 999999;
        int min = 800000;
        num = (int) Math.floor(Math.random() * (max - min + 1) + min);

          this.setNumDispositivo(num);
         
    }

    @Override
    public void restaurarBateria() {
        super.restaurarBateria(); //To change body of generated methods, choose Tools | Templates.
    }
    @Override 
   public void consumirBateriaMovimento() {
      int valor = m.gerarNumero(30, 300);
        super.setCargaBateria(super.getCargaBateria()- valor);
    }

  @Override    
    public void consumirBateriaComunicacao() {
       int valor = m.gerarNumero(30, 200);
       
       super.setCargaBateria(super.getCargaBateria() - valor);     
    }

    @Override
    public int getTamStorage() {
        return super.getTamStorage(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setStatus(int status) {
        super.setStatus(status); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getStatus() {
        return super.getStatus(); //To change body of generated methods, choose Tools | Templates.
    }

   

    

    @Override
    public void setTamanhoMaximoBateria(int tamanhoMaximoBateria) {
        super.setTamanhoMaximoBateria(tamanhoMaximoBateria); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTamanhoMaximoBateria() {
        return super.getTamanhoMaximoBateria(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTextoStrage(Regiao r) {
        return "Dispositivo Movel"+super.getTextoStrage(r); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTamStorage(int tamStorage) {
        super.setTamStorage(tamStorage); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
