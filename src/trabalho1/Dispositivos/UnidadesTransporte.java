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
public class UnidadesTransporte extends Dispositivo {

    public UnidadesTransporte(int automatico, Regiao r) {
        super(automatico, r);
        super.setEhMovel(1);                                               
    }

    @Override
    public void restaurarBateria() {
        super.restaurarBateria(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consumirBateriaComunicacao() {
        super.consumirBateriaComunicacao(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consumirBateriaMovimento() {
        super.consumirBateriaMovimento(); //To change body of generated methods, choose Tools | Templates.
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
    public String getTextoStrage(Regiao r) {
        return super.getTextoStrage(r); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
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
    public void setTamStorage(int tamStorage) {
        super.setTamStorage(tamStorage); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTamStorage() {
        return super.getTamStorage(); //To change body of generated methods, choose Tools | Templates.
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
    public void setStatus(int status) {
        super.setStatus(status); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getStatus() {
        return super.getStatus(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEhMovel(int ehMOvel) {
        super.setEhMovel(ehMOvel); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCargaBateria() {
        return super.getCargaBateria(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
