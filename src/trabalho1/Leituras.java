/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import trabalho1.Dispositivos.Dispositivo;
import trabalho1.Dispositivos.Sensor;

/**
 *
 * @author home
 */
public class Leituras {
    private PontoRegiao pontoLeitura;
    private Dispositivo sensorLeitura;
    private String informacaoLida;

    public Leituras(PontoRegiao pontoLeitura, Dispositivo sensorLeitura, String informacaoLida) {
        this.pontoLeitura = pontoLeitura;
        this.sensorLeitura = sensorLeitura;
        this.informacaoLida = informacaoLida;
    }
    
    

    public PontoRegiao getPontoLeitura() {
        return pontoLeitura;
    }

    public void setPontoLeitura(PontoRegiao pontoLeitura) {
        this.pontoLeitura = pontoLeitura;
    }

    public Dispositivo getSensorLeitura() {
        return sensorLeitura;
    }

    public void setSensorLeitura(Sensor sensorLeitura) {
        this.sensorLeitura = sensorLeitura;
    }

    public String getInformacaoLida() {
        return informacaoLida;
    }

    public void setInformacaoLida(String informacaoLida) {
        this.informacaoLida = informacaoLida;
    }

    @Override
    public String toString() {
        return "Leituras{" + "Endereço pontoLeitura=" + pontoLeitura.getEnderecoX() + "," +pontoLeitura.getEnderecoY()+ " \n ID do sensorLeitura= " + sensorLeitura.getIdDispositivo() + ",\n informacaoLida=" + informacaoLida + '}';
    }
    public String toString2() {
        return "Leituras{" + "Endereço pontoLeitura=" + pontoLeitura.getEnderecoX() + "," +pontoLeitura.getEnderecoY()+ " \n ID do sensorLeitura= " + sensorLeitura.getIdDispositivo() + ",\n informacaoLida=" + informacaoLida +"\n\n"+ '}';
    }
    
    
    
}
