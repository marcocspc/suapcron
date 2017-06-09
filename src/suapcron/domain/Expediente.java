/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suapcron.domain;

import java.util.Date;

/**
 *
 * @author marcocspc
 */
public class Expediente {
    private Date dia;
    private Hora horasTrabalhadas;

    public Expediente(Date dia, Hora horasTrabalhadas) {
        this.dia = dia;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public Expediente() {
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Hora getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(Hora horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }
    
    
}
