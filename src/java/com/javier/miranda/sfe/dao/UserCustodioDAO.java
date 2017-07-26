/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javier.miranda.sfe.dao;

import com.javier.miranda.sfe.interfaces.IDao;
import com.javier.miranda.sfe.model.UserCustodio;
import com.javier.miranda.sfe.utils.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author andres
 */
public class UserCustodioDAO implements IDao<UserCustodio>{
    Connection conexion;
    public UserCustodioDAO() {
        conexion= new Conexion().conectar();
    }
    

    @Override
    public void save(UserCustodio model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(UserCustodio model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserCustodio> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserCustodio getByParameter(Map<String,Object> parameter) throws Exception {
        UserCustodio userCustodio=null;
        PreparedStatement ps = conexion.prepareStatement("select username, pass from tb_usercustodio where username=? and pass=?");
        ps.setString(1, parameter.get("username").toString());
        ps.setString(2, parameter.get("pass").toString());
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            userCustodio= new UserCustodio();
            userCustodio.setUser(rs.getString("username"));
            userCustodio.setPass(rs.getString("pass"));
        }
        return userCustodio;
    }
    
}
