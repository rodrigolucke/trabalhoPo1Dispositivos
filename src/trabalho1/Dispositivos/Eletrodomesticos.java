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
public class Eletrodomesticos  extends DispositivosFixos{
    private int volume;

    public Eletrodomesticos(int volume, int automatico, Regiao r) {
        super(automatico, r);
        this.volume = volume;
    }

  

    @Override
    public void setTamStorage(int tamStorage) {
        super.setTamStorage(tamStorage); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTamStorage() {
        return super.getTamStorage(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
