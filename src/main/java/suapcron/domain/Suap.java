/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.suapcron.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import main.java.suapcron.suapdealer.SuapConnection;
import main.java.suapcron.suapdealer.SuapConnectionFactory;

/**
 *
 * @author marcocspc
 */
public class Suap {

    private Servidor servidor;

    public Suap() {
    }

    public Suap(Servidor servidor) {
        this.servidor = servidor;
    }

    public void inserirObservacao(Expediente e) throws Exception {
        SuapConnection sp = SuapConnectionFactory.getConnection(servidor.getMatricula(), servidor.getSenha());

        sp.putObservation(e.getObservacao(), montarURLObservacao(e.getDia()));
    }

    public boolean verificarCredenciais() throws Exception {
        SuapConnection sp = SuapConnectionFactory.getConnection(servidor.getMatricula(), servidor.getSenha());
        return sp.validate(servidor.getMatricula(), servidor.getSenha());
    }

    private String montarURLObservacao(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        return SuapConnection.SUAP_OSERVATION_PAGE_BASE_URL + sdf.format(d) + "/";
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

}
