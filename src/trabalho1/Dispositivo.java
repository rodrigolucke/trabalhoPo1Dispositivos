/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

/**
 *
 * @author home
 */
public abstract class  Dispositivo {
    
    private int cargaBateria;
    private int consumoBateria;
    private int ehMovel;
    private int peso;
    private String cor;
    private int tamanhoStorage;
    private int alcanceComunicacao;
    

    public Dispositivo() {
    }

    public Dispositivo(int cargaBateria, int consumoBateria, int ehMovel) {
        this.cargaBateria = cargaBateria;
        this.consumoBateria = consumoBateria;
        this.ehMovel = ehMovel;
    }

    public int getCargaBateria() {
        return cargaBateria;
    }

    public void setCargaBateria(int cargaBateria) {
        this.cargaBateria = cargaBateria;
    }

    public int getConsumoPorHora() {
        return consumoBateria;
    }

    public void setConsumoPorHora(int consumoBateria) {
        this.consumoBateria = consumoBateria;
    }

    public int getEhMovel() {
        return ehMovel;
    }

    public void setEhMovel(int ehMovel) {
        this.ehMovel = ehMovel;
    }

    @Override
    public String toString() {
        return "Dispositivo{" + "cargaBateria=" + cargaBateria + ", consumoPorHora=" + consumoBateria + ", ehMovel=" + ehMovel + '}';
    }
    
    
}
