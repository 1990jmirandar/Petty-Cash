/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javier.miranda.sfe.dao;

import com.javier.miranda.sfe.interfaces.IDao;
import com.javier.miranda.sfe.model.RequestMoney;
import com.javier.miranda.sfe.utils.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author andres
 */
public class RequestMoneyDAO implements IDao<RequestMoney>{
    
    Connection conexion;
    public RequestMoneyDAO() {
        conexion=new Conexion().conectar();
    }
    

    @Override
    public void save(RequestMoney model) throws Exception {
        PreparedStatement insertRM = conexion.prepareStatement("insert into tb_requestmoney (valorrm,nombrerm,fecharegistro) values(?,?,?)");
        insertRM.setDouble(1, model.getValorRM());
        insertRM.setString(2, model.getNombreRM());
        insertRM.setTimestamp(3,new Timestamp(new java.util.Date().getTime()));
        if (insertRM.executeUpdate()!=1)
            throw new Exception("No inserto la solicitud de dinero");
        
    }

    @Override
    public void delete(RequestMoney model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RequestMoney> getAll() throws Exception {
        List<RequestMoney> lista = new ArrayList<>();
        PreparedStatement ps = conexion.prepareStatement("select idrm,nombrerm,valorrm,fecharegistro from tb_requestmoney where delivered=0");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            RequestMoney requestMoney = new RequestMoney(rs.getInt("idrm"),rs.getDouble("valorrm"),rs.getString("nombrerm"),rs.getDate("fecharegistro"));
            lista.add(requestMoney);
        }
        return lista;
    }

    @Override
    public RequestMoney getByParameter(Map<String, Object> parameter) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
