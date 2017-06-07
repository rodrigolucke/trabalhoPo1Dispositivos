/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.Dispositivos;

import java.util.Date;
/**
 *
 * @author rodrigolucke
 */
public class Sensor extends DispositivosFixos{
    private Date dataImplantacao;
    private int valorLeitura;

    public Sensor(Date dataImplantacao, int valorLeitura, int cargaBateria, int consumoBateria, int ehMovel) {
        super(cargaBateria, consumoBateria, ehMovel);
        this.dataImplantacao = dataImplantacao;
        this.valorLeitura = valorLeitura;
    }

    
    

    
    
}
