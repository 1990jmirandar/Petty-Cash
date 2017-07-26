/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javier.miranda.sfe.interfaces;

import javax.annotation.PostConstruct;

/**
 *
 * @author andres
 */
public interface IBeans {
    
    public void init();
    
    public void save();
    
    public void delete();
    
    public void modify(Object obj);
}
