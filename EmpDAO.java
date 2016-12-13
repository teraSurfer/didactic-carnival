/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.spring.dao;

import com.tm.spring.beans.Employee;
import java.util.List;

/**
 *
 * @author MSLCELTP1800
 */
public interface EmpDAO {
    boolean empInsert(Employee emp);
    boolean empUpdate(int id,Employee emp);
    boolean empDelete(int id);
    Employee display(int id);
    List displayAll();
    List displayAll(int i);
}
