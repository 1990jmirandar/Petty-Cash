/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javier.miranda.sfe.interfaces;

import java.util.List;
import java.util.Map;

/**
 *
 * @author andres
 */
public interface IDao<T> {
    public void save(T model) throws Exception;
    public void delete(T model)throws Exception;
    public List<T> getAll()throws Exception;
    public T getByParameter(Map<String,Object> parameter) throws Exception;
    
}
