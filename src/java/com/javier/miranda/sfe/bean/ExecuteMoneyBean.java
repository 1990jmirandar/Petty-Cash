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
import java.util.List;
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
public class ExecuteMoneyBean implements IBeans {
    
    @ManagedProperty(value = "#{loginCustodio}")
    private LoginCustodio loginCustodio;

    private List<RequestMoney> listaRequestMoney;
    private List<RequestMoney> listaRequestMoneySelected;
    private double currentBalance;
    private double deliveryRequest;

    @PostConstruct
    @Override
    public void init() {
        try {
            if (!loginCustodio.isLoggin()){
                FacesContext.getCurrentInstance().getExternalContext().redirect("./login.xhtml");
            }
            listaRequestMoney = new RequestMoneyDAO().getAll();
            currentBalance = new RecordMoneyDAO().getCurrentBalance();
            deliveryRequest=0;
        } catch (Exception ex) {
            Logger.getLogger(ExecuteMoneyBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void requestDelivery() {
        deliveryRequest=0;
        for (int i = 0; i < listaRequestMoneySelected.size(); i++) {
            deliveryRequest += listaRequestMoneySelected.get(i).getValorRM();
        }
    }

    @Override
    public void save() {
        try {
            new RecordMoneyDAO().updateDelivery(listaRequestMoneySelected);
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

    public List<RequestMoney> getListaRequestMoney() {
        return listaRequestMoney;
    }

    public void setListaRequestMoney(List<RequestMoney> listaRequestMoney) {
        this.listaRequestMoney = listaRequestMoney;
    }

    public List<RequestMoney> getListaRequestMoneySelected() {
        return listaRequestMoneySelected;
    }

    public void setListaRequestMoneySelected(List<RequestMoney> listaRequestMoneySelected) {
        this.listaRequestMoneySelected = listaRequestMoneySelected;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public double getDeliveryRequest() {
        return deliveryRequest;
    }

    public void setDeliveryRequest(double deliveryRequest) {
        this.deliveryRequest = deliveryRequest;
    }

    public LoginCustodio getLoginCustodio() {
        return loginCustodio;
    }

    public void setLoginCustodio(LoginCustodio loginCustodio) {
        this.loginCustodio = loginCustodio;
    }
    
    

}
