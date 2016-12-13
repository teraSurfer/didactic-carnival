/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.tm.spring.beans.Employee;
import com.tm.spring.service.EmployeeService;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author MSLCELTP1800
 */
@Component
@Controller
@SessionAttributes("emp")
public class EmployeeController {
    
    @Autowired
    private EmployeeService es;
    
    @RequestMapping("/index.htm")
    protected ModelAndView indexGenerator(){
        return new ModelAndView("index");
    }
    
    @RequestMapping("/insert.htm")
    protected ModelAndView insertGenerator(){
        return new ModelAndView("insert");
    }
    @RequestMapping(value="/update.htm")
    protected ModelAndView updateGenerator(){
        return new ModelAndView("update");
    }
    @RequestMapping(value="/delete.htm")
    protected ModelAndView deleteGenerator(){
        return new ModelAndView("delete");
    }
    @RequestMapping(value="/display.htm")
    protected ModelAndView displayGenerator(){
        return new ModelAndView("display");
    }
    @RequestMapping(value="/inserting.htm",method = RequestMethod.POST )
    protected ModelAndView insert(@ModelAttribute("cmdIns") Employee emp ){
        es.insert(emp);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("insert");
        mav.addObject("emp","Inserted Employee "+emp.getEmployeeId());
        return mav;
    }
    @RequestMapping(value="/updating.htm",method=RequestMethod.POST)
    protected ModelAndView update(@ModelAttribute("cmdUp") Employee emp){
        ModelAndView mav = new ModelAndView();
        es.update(emp,emp.getEmployeeId());
        mav.setViewName("index");
        mav.addObject("emp","Updated Employee "+emp.getEmployeeId());
        return mav;
    }
    @RequestMapping(value="/Udisplaying.htm",method=RequestMethod.GET)
    protected ModelAndView displayU(@RequestParam("id") int id){
        ModelAndView mav = new ModelAndView();
        Employee e= es.display(id);
        System.out.println("requested employee-------------------->"+e);
        mav.setViewName("update");
        //ModelMap mm 
        mav.addObject("upid",e);
        return mav;
    }
    @RequestMapping(value="/displaying.htm",method=RequestMethod.POST)
    protected ModelAndView display(@RequestParam("id") int id){
        ModelAndView mav = new ModelAndView();
        Employee e= es.display(id);
        System.out.println("requested employee-------------------->"+e);
        mav.setViewName("display");
        //ModelMap mm 
        mav.addObject("did",e);
        return mav;
    }
    @RequestMapping(value="/deleting.htm",method=RequestMethod.POST)
    protected ModelAndView delete(@RequestParam("id") int id){
        ModelAndView mav = new ModelAndView();
        es.delete(id);
        mav.setViewName("delete");
        mav.addObject("emp","Deleted employee: "+id);
        return mav;
    }
    @RequestMapping(value="/displayAll.htm",method=RequestMethod.POST)
    protected ModelAndView displayAll(){
        ModelAndView mav = new ModelAndView();
         List l = es.displayAll(1);
         List p = es.getPages();
        mav.setViewName("displayAll");
        mav.addObject("elist", l);
        mav.addObject("pages",p);
        System.out.println(l);
        return mav;
    }
     @RequestMapping(value="pages.htm",method=RequestMethod.GET)
    protected ModelAndView displayX(@RequestParam("id")int pg){
        ModelAndView mav = new ModelAndView();
        List l = es.displayAll(pg);
        List p = es.getPages();
        mav.setViewName("displayAll");
        mav.addObject("elist", l);
        mav.addObject("pages",p);
        return mav;
    }
    @RequestMapping(value="/delmultiple.htm",method = RequestMethod.POST)
    protected ModelAndView deleteMul(@RequestParam("select") List<String> s){
        Iterator itr = s.iterator();
        while(itr.hasNext()){
            int id = Integer.parseInt((String)itr.next());
            es.delete(id);
        }
        System.out.println("deleted!!!!!!!!!!!!");
        return displayAll();
    }
    
    
    
}
