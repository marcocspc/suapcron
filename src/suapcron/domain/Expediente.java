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
    private String observacao;

    public Expediente(Date dia, Hora horasTrabalhadas) {
        this.dia = dia;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public Expediente(Date dia, Hora horasTrabalhadas, String observacao) {
        this.dia = dia;
        this.horasTrabalhadas = horasTrabalhadas;
        this.observacao = observacao;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
    
}
