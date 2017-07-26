package com.javier.miranda.sfe.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andres
 */
public class Conexion {
    String driver = "org.postgresql.Driver";
    String connectString = "jdbc:postgresql://localhost:5432/db_pettycash";
    String user = "postgres";
    String password = "Ctek2314";
    public Connection conectar(){
        Connection conexion=null;
        try{
            Class.forName(driver);
            conexion = DriverManager.getConnection(connectString, user , password);
        }catch(Exception e){
            e.printStackTrace();
            conexion=null;
        }
        return conexion;
        
    }
    
    public void closeConnection(Connection conexion) throws SQLException{
        conexion.close();
    }
}
