/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.Dispositivos;

import trabalho1.Regiao;

/**
 *
 * @author home
 */
public class Vants extends DispositivosMoveis{
    private int enderecoX;
    private int enderecoY;

    public Vants( int automatico, Regiao r , int enderecoX, int enderecoY) {
        super(automatico, r);
        this.enderecoX = r.retornarPosicaoDispositivo(this).getEnderecoX();
        this.enderecoY = r.retornarPosicaoDispositivo(this).getEnderecoY();
    }

    @Override
    public void setTamStorage(int tamStorage) {
        super.setTamStorage(tamStorage); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTextoStrage(Regiao r) {
        return super.getTextoStrage(r); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTamanhoMaximoBateria() {
        return super.getTamanhoMaximoBateria(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTamanhoMaximoBateria(int tamanhoMaximoBateria) {
        super.setTamanhoMaximoBateria(tamanhoMaximoBateria); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consomeBateriaMovimento() {
        super.consomeBateriaMovimento(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void restaurarBateria() {
        super.restaurarBateria(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void gerarNumero() {
        super.gerarNumero(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCargaBateria() {
        return super.getCargaBateria(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCargaBateria(int cargaBateria) {
        super.setCargaBateria(cargaBateria); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPeso() {
        return super.getPeso(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPeso(int peso) {
        super.setPeso(peso); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCor() {
        return super.getCor(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCor(String cor) {
        super.setCor(cor); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getStorage() {
        return super.getStorage(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setStorage(String storage) {
        super.setStorage(storage); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getAlcanceComunicacao() {
        return super.getAlcanceComunicacao(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAlcanceComunicacao(int alcanceComunicacao) {
        super.setAlcanceComunicacao(alcanceComunicacao); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getEhMovel() {
        return super.getEhMovel(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIdDispositivo() {
        return super.getIdDispositivo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setIdDispositivo(int idDispositivo) {
        super.setIdDispositivo(idDispositivo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Vants "+super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void gerarIdValidoDispositivo(Regiao r) {
        super.gerarIdValidoDispositivo(r); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consomeBateria() {
        super.consomeBateria(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNumDispositivo(int numDispositivo) {
        super.setNumDispositivo(numDispositivo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEhMovel(int ehMovel) {
        super.setEhMovel(ehMovel); //To change body of generated methods, choose Tools | Templates.
    }
   
    
    
}