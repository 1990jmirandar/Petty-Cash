/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javier.miranda.sfe.model;

import java.util.Date;

/**
 *
 * @author andres
 */
public class RequestMoney {
    int idRM;
    double valorRM;
    String nombreRM;
    Date fechaRegistro;
    int delivered;

    public RequestMoney(int idRM, double valorRM, String nombreRM, Date fechaRegistro) {
        this.idRM = idRM;
        this.valorRM = valorRM;
        this.nombreRM = nombreRM;
        this.fechaRegistro = fechaRegistro;
    }

    public RequestMoney() {
    }
    
    

    public int getIdRM() {
        return idRM;
    }

    public void setIdRM(int idRM) {
        this.idRM = idRM;
    }

    public double getValorRM() {
        return valorRM;
    }

    public void setValorRM(double valorRM) {
        this.valorRM = valorRM;
    }

    public String getNombreRM() {
        return nombreRM;
    }

    public void setNombreRM(String nombreRM) {
        this.nombreRM = nombreRM;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getDelivered() {
        return delivered;
    }

    public void setDelivered(int delivered) {
        this.delivered = delivered;
    }
    
    
    
    
}
