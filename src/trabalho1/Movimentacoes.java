/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import trabalho1.Dispositivos.Dispositivo;

/**
 *
 * @author rodrigolucke
 */
public class Movimentacoes {
     private PontoRegiao pontoOrigem;
     private PontoRegiao pontoDestino;
     private Dispositivo dispositivoMovimentado;

    public Movimentacoes(PontoRegiao pontoOrigem, PontoRegiao pontoDestino, Dispositivo dispositivoMovimentado) {
        this.pontoOrigem = pontoOrigem;
        this.pontoDestino = pontoDestino;
        this.dispositivoMovimentado = dispositivoMovimentado;
    }

    public Movimentacoes() {
    }
    

    @Override
    public String toString() {
        return "Movimentacoes{" +", dispositivoMovimentado= " +dispositivoMovimentado.getClass()+ " ID do dispositivo ="+ dispositivoMovimentado.getIdDispositivo()+ " saiu do ponto do pontoOrigem=" + this.pontoOrigem.getEnderecoX() + ", " +this.pontoOrigem.getEnderecoY() + ",foi para o pontoDestino=" + this.pontoDestino.getEnderecoX() + ", " +this.pontoDestino.getEnderecoY()  +  '}';
    }

    public PontoRegiao getPontoOrigem() {
        return pontoOrigem;
    }

    public void setPontoOrigem(PontoRegiao pontoOrigem) {
        this.pontoOrigem = pontoOrigem;
    }

    public PontoRegiao getPontoDestino() {
        return pontoDestino;
    }

    public void setPontoDestino(PontoRegiao pontoDestino) {
        this.pontoDestino = pontoDestino;
    }

    public Dispositivo getDispositivoMovimentado() {
        return dispositivoMovimentado;
    }

    public void setDispositivoMovimentado(Dispositivo dispositivoMovimentado) {
        this.dispositivoMovimentado = dispositivoMovimentado;
    }
     
     
    
}
