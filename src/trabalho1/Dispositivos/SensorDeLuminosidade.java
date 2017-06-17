/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.Dispositivos;

import java.util.Calendar;
import java.util.Date;
import trabalho1.Regiao;

/**
 *
 * @author rodrigolucke
 */
public class SensorDeLuminosidade extends Sensor{

    public SensorDeLuminosidade() {
        super();
    }

    public SensorDeLuminosidade(int automatico, Regiao r) {
        super(automatico, r);
        super.setCargaBateria(1000);
        super.setStorage(this.getLuminosidadeAtual());
                   
    }

    
    @Override
    public void consomeBateria() {
        super.consomeBateria(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Sensor de Luminosidade "+super.toString(); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public Calendar getPegaDataAtual() {
        return super.getPegaDataAtual(); //To change body of generated methods, choose Tools | Templates.
    }

    private String getLuminosidadeAtual() {
        return "Luminosidade atual = 50";
    }

    
    
}
