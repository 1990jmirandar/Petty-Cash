/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javier.miranda.sfe.bean;

import com.javier.miranda.sfe.dao.UserCustodioDAO;
import com.javier.miranda.sfe.model.UserCustodio;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author andres
 */
@ManagedBean
@SessionScoped
public class LoginCustodio {
    UserCustodio custodio=new UserCustodio();
    boolean loggin=false;
    public void validar(){
        try {
            Map parametros = new HashMap<String, Object>();
            parametros.put("username", custodio.getUser());
            parametros.put("pass", custodio.getPass());
            custodio= new UserCustodioDAO().getByParameter(parametros);
            if (custodio!=null){
                loggin=true;
                FacesContext.getCurrentInstance().getExternalContext().redirect("./menu_custodio.xhtml");
            }
            else
                custodio= new UserCustodio();
        } catch (Exception ex) {
            Logger.getLogger(LoginCustodio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public UserCustodio getCustodio() {
        return custodio;
    }

    public void setCustodio(UserCustodio custodio) {
        this.custodio = custodio;
    }

    public boolean isLoggin() {
        return loggin;
    }

    public void setLoggin(boolean loggin) {
        this.loggin = loggin;
    }
    
    public void cerrarSesion(){
        loggin=false;
        custodio= new UserCustodio();
    }
    
    
}
