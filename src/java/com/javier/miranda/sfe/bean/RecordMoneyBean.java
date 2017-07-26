/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javier.miranda.sfe.bean;

import com.javier.miranda.sfe.dao.RecordMoneyDAO;
import com.javier.miranda.sfe.dao.RequestMoneyDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.javier.miranda.sfe.interfaces.IBeans;
import com.javier.miranda.sfe.model.RecordMoney;
import com.javier.miranda.sfe.model.RequestMoney;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;


/**
 *
 * @author andres
 */
@ManagedBean
@ViewScoped
public class RecordMoneyBean implements IBeans{
    @ManagedProperty(value = "#{loginCustodio}")
    private LoginCustodio loginCustodio;
    
    private RecordMoney recordMoney;
    private double currentBalance;
    @PostConstruct
    @Override
    public void init() {
        try {
            if (!loginCustodio.isLoggin()){
                FacesContext.getCurrentInstance().getExternalContext().redirect("./login.xhtml");
            }
            recordMoney = new RecordMoney();
            currentBalance = new RecordMoneyDAO().getCurrentBalance();
        } catch (Exception ex) {
            Logger.getLogger(RecordMoneyBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save() {
        try {
            new RecordMoneyDAO().save(recordMoney);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Guardado"));
            init();
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(ex.getMessage()));
        }
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modify(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public RecordMoney getRecordMoney() {
        return recordMoney;
    }

    public void setRecordMoney(RecordMoney recordMoney) {
        this.recordMoney = recordMoney;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public LoginCustodio getLoginCustodio() {
        return loginCustodio;
    }

    public void setLoginCustodio(LoginCustodio loginCustodio) {
        this.loginCustodio = loginCustodio;
    }


    
    
    

}
