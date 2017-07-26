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
public class RecordMoney {
    int idRMC;
    double valorRMC;
    Date fechaRegistro;

    public RecordMoney(int idRMC, double valorRMC, Date fechaRegistro) {
        this.idRMC = idRMC;
        this.valorRMC = valorRMC;
        this.fechaRegistro = fechaRegistro;
    }
    
    

    public int getIdRMC() {
        return idRMC;
    }

    public void setIdRMC(int idRMC) {
        this.idRMC = idRMC;
    }

    public double getValorRMC() {
        return valorRMC;
    }

    public void setValorRMC(double valorRMC) {
        this.valorRMC = valorRMC;
    }

    
    public RecordMoney() {
    }
    
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    
    
    
}
