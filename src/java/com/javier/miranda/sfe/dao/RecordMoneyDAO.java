/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javier.miranda.sfe.dao;

import com.javier.miranda.sfe.interfaces.IDao;
import com.javier.miranda.sfe.model.RecordMoney;
import com.javier.miranda.sfe.model.RequestMoney;
import com.javier.miranda.sfe.utils.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 *
 * @author andres
 */
public class RecordMoneyDAO implements IDao<RecordMoney>{
    
    Connection conexion;
    public RecordMoneyDAO() {
        conexion=new Conexion().conectar();
    }
    

    @Override
    public void save(RecordMoney model) throws Exception {
        PreparedStatement insertRMC = conexion.prepareStatement("insert into tb_recordmoney (valorrmc,fecharegistro) values(?,?)");
        insertRMC.setDouble(1, model.getValorRMC());
        insertRMC.setDate(2,new Date(model.getFechaRegistro().getTime()));
        if (insertRMC.executeUpdate()!=1)
            throw new Exception("No inserto la solicitud de dinero");
        
    }

    @Override
    public void delete(RecordMoney model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RecordMoney> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RecordMoney getByParameter(Map<String, Object> parameter) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double getCurrentBalance() throws Exception{
        double currentBalance = 0;
        PreparedStatement pr = conexion.prepareStatement("select sum(valorrmc) as current from tb_recordmoney");
        ResultSet rs = pr.executeQuery();
        while(rs.next()){
            currentBalance = rs.getDouble("current");
        }
        pr = conexion.prepareStatement("select sum(valorrm) as request from tb_requestmoney where delivered=1");
        rs = pr.executeQuery();
         while(rs.next()){
            currentBalance -= rs.getDouble("request");
        }
        return currentBalance;
    }
    
   
    public void updateDelivery(List<RequestMoney> listRequest) throws Exception {
        for (int i=0;i<listRequest.size();i++){
            PreparedStatement ps = conexion.prepareStatement("update tb_requestmoney set delivered=1, fechadelivered=? where idrm=?");
            ps.setTimestamp(1, new Timestamp( new java.util.Date().getTime()));
            ps.setInt(2, listRequest.get(i).getIdRM());
            if (ps.executeUpdate()!=1)
                throw new Exception("No actualizo la solicitud de dinero");
            
        }
        
        
    }
    
}
