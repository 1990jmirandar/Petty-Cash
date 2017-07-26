/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javier.miranda.sfe.bean;

import com.javier.miranda.sfe.dao.RequestMoneyDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.javier.miranda.sfe.interfaces.IBeans;
import com.javier.miranda.sfe.model.RequestMoney;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


/**
 *
 * @author andres
 */
@ManagedBean
@ViewScoped
public class RequestMoneayBean implements IBeans{
    private RequestMoney requestMoney;
    @PostConstruct
    @Override
    public void init() {
        requestMoney = new RequestMoney();
    }

    @Override
    public void save() {
        try {
            new RequestMoneyDAO().save(requestMoney);
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

    public RequestMoney getRequestMoney() {
        return requestMoney;
    }

    public void setRequestMoney(RequestMoney requestMoney) {
        this.requestMoney = requestMoney;
    }
    
    
    

}
