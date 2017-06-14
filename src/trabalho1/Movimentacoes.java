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
        return "Movimentacoes{" + "pontoOrigem=" + pontoOrigem + ", pontoDestino=" + pontoDestino + ", dispositivoMovimentado=" + dispositivoMovimentado + '}';
    }
     
     
    
}