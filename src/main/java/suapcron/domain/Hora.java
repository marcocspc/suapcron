/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.suapcron.domain;

/**
 *
 * @author marcocspc
 */
public class Hora {

    private int horas;
    private int minutos;
    private int segundos;

    public Hora(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public Hora() {
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public void mais(Hora h) {
        //calculo para segundos
        this.segundos += h.getSegundos();
        while (this.segundos >= 60) {
            this.minutos++;
            this.segundos -= 60;
        }

        //calculo para minutos
        this.minutos += h.minutos;
        while (this.minutos >= 60) {
            this.horas++;
            this.minutos -= 60;
        }
        
        //calculo para horas
        this.horas += h.getHoras();
    }

    public void menos(Hora h) {
        if (this.compareTo(h) < 0) {
            Hora haux = new Hora(h.getHoras(), h.getMinutos(), h.getSegundos());

            h.setHoras(this.horas);
            h.setMinutos(this.minutos);
            h.setSegundos(this.segundos);

            this.horas = haux.getHoras();
            this.minutos = haux.getMinutos();
            this.segundos = haux.getSegundos();
        }

        if (this.segundos < h.getSegundos()) {
            this.segundos += 60;
            this.minutos--;

            this.segundos -= h.getSegundos();
        } else {
            this.segundos -= h.getSegundos();
        }

        if (this.minutos < h.getMinutos()) {
            this.minutos += 60;
            this.horas--;

            this.minutos -= h.getMinutos();
        } else {
            this.minutos -= h.getMinutos();
        }

        this.horas -= h.getHoras();
    }

    @Override
    public String toString() {
        return String.format("%02d", horas) + ":" + String.format("%02d", minutos) + ":" + String.format("%02d", segundos);
    }

    public int compareTo(Hora h) {
        if (this.horas == h.getHoras()) {
            if (this.minutos == h.getMinutos()) {
                return this.segundos - h.getSegundos();
            } else {
                return this.minutos - h.getMinutos();
            }
        } else {
            return this.horas - h.getHoras();
        }
    }
}
