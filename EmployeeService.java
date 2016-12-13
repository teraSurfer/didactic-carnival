/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.spring.service;

import java.util.List;

/**
 *
 * @author MSLCELTP1800
 */
public interface EmployeeService {
    public void insert(com.tm.spring.beans.Employee e);
    public void update(com.tm.spring.beans.Employee e,int id);
    public com.tm.spring.beans.Employee display(int id);
    public List displayAll();
   public List displayAll(int p);
    public void delete(int id);
    public List getPages();
}
